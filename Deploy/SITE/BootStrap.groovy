import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Unit
import patientflowmonitoring.Room


class BootStrap {
	
	def jmsService

    def init = { servletContext ->
		createUnits()
		createTestRecords()
    }
    def destroy = {
    }
	
	def createTestRecords(){
		jmsService.send(queue:'PFM_Event','event:TriageScore,timestamp:2012-09-20/03-30-00,Provider_ID:Nurse745774,CTAS:2,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation1,timestamp:2012-09-20/04-00-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted1,timestamp:2012-09-20/04-20-00,Provider_ID:Phy777777,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ConsultationCompleted1,timestamp:2012-09-20/04-40-00,Provider_ID:Phy777777,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1111,OrderType:ECG,Provider_ID:Phy777777,timestamp:2012-09-20/04-41-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1112,OrderType:BloodSample,Provider_ID:Phy777777,timestamp:2012-09-20/04-41-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1113,OrderType:BloodAnalysis,Provider_ID:Phy777777,timestamp:2012-09-20/04-41-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForOrderExecution,timestamp:2012-09-20/04-42-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1111,OrderType:ECG,Provider_ID:Nurse121212,timestamp:2012-09-20/05-05-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1112,OrderType:BloodSample,Provider_ID:Nurse121212,timestamp:2012-09-20/05-08-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1113,OrderType:BloodAnalysis,Provider_ID:Nurse121212,timestamp:2012-09-20/05-40-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:OrdersExecutionCompleted,timestamp:2012-09-20/05-40-10,Provider_ID:Nurse121212,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation2,timestamp:2012-09-20/05-40-50,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted2,timestamp:2012-09-20/06-00-00,Provider_ID:Phy777777,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ConsultationCompleted2,timestamp:2012-09-20/06-34-00,Provider_ID:Phy777777,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientAdmittedWithNoBed,timestamp:2012-09-20/06-41-10,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForBed,timestamp:2012-09-20/06-42-00,Unit_ID:CW,Patient_ID:Pa111111')
		
		jmsService.send(queue:'PFM_Event','event:PatientAdmittedWithBed,timestamp:2012-09-20/15-40-00,Location_ID:R105,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForTransport,timestamp:2012-09-20/15-41-00,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientTransportStarted,Unit_ID:CW,timestamp:2012-09-20/16-00-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientArrivedInBed,timestamp:2012-09-20/16-10-00,Location_ID:R105,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForProcedures,timestamp:2012-09-21/08-10-10,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientTransportRequest,Unit_ID:CCL,timestamp:2012-09-21/09-05-00,Provider_ID:Nur121212,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForTransport,timestamp:2012-09-21/09-05-10,Unit_ID:CCL,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientTransportStarted,Unit_ID:CCL,timestamp:2012-09-21/09-30-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientArrivedInBed,timestamp:2012-09-21/09-40-00,Location_ID:CCLRoom,Unit_ID:CCL,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ProcedureStarted,timestamp:2012-09-21/10-10-00,Provider_ID:Phy777777,Procedure_Type:Angiogram,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ProcedureCompleted,timestamp:2012-09-21/10-45-00,Provider_ID:Phy777777,Procedure_Type:Angiogram,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ProcedureStarted,timestamp:2012-09-21/11-00-00,Provider_ID:Phy777777,Procedure_Type:PCI,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ProcedureCompleted,timestamp:2012-09-21/11-40-00,Provider_ID:Phy777777,Procedure_Type:PCI,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ProceduresExecutionCompleted,timestamp:2012-09-21/11-42-50,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientTransportRequest,Unit_ID:CW,timestamp:2012-09-21/12-00-00,Provider_ID:Nur121212,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:WaitForTransport,timestamp:2012-09-21/12-01-10,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientTransportStarted,Unit_ID:CW,timestamp:2012-09-21/12-10-00,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:PatientArrivedInBed,timestamp:2012-09-21/13-20-00,Location_ID:R105,Unit_ID:CW,Patient_ID:Pa111111')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted3,timestamp:2012-09-21/13-40-00,Provider_ID:Phy777777,Patient_ID:Pa111111')
		//jmsService.send(queue:'PFM_Event','event:ConsultationCompleted3,timestamp:2012-09-21/08-10-00,Provider_ID:Phy777777,Patient_ID:Pa111111')
		//jmsService.send(queue:'PFM_Event','event:WaitForDischarge,timestamp:2012-09-21/08-11-00,Unit_ID:CW,Patient_ID:Pa111111')
		//jmsService.send(queue:'PFM_Event','event:DischargeCompleted,timestamp:2012-09-21/09-00-00,Unit_ID:CW,Patient_ID:Pa111111')
		
				
		jmsService.send(queue:'PFM_Event','event:TriageScore,timestamp:2012-09-20/23-54-00,Provider_ID:Nurse745774,CTAS:2,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation1,timestamp:2012-09-21/00-04-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted1,timestamp:2012-09-21/00-20-00,Provider_ID:Phy777777,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:ConsultationCompleted1,timestamp:2012-09-21/00-41-00,Provider_ID:Phy777777,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1111,OrderType:ECG,Provider_ID:Phy777777,timestamp:2012-09-21/00-43-10,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1112,OrderType:BloodSample,Provider_ID:Phy777777,timestamp:2012-09-21/00-45-30,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrderRequest,Order_ID:Order1113,OrderType:BloodAnalysis,Provider_ID:Phy777777,timestamp:2012-09-21/00-46-40,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForOrderExecution,timestamp:2012-09-21/00-47-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1111,OrderType:ECG,Provider_ID:Nurse121212,timestamp:2012-09-21/01-00-10,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1112,OrderType:BloodSample,Provider_ID:Nurse121212,timestamp:2012-09-21/01-04-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrderRequestCompleted,Order_ID:Order1113,OrderType:BloodAnalysis,Provider_ID:Nurse121212,timestamp:2012-09-21/01-10-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:OrdersExecutionCompleted,timestamp:2012-09-21/01-12-10,Provider_ID:Nurse121212,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForConsultation2,timestamp:2012-09-21/01-13-50,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:ConsultationStarted2,timestamp:2012-09-21/01-35-00,Provider_ID:Phy777777,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:ConsultationCompleted2,timestamp:2012-09-21/01-56-00,Provider_ID:Phy777777,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:PatientAdmittedWithNoBed,timestamp:2012-09-21/02-01-10,Unit_ID:CW,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForBed,timestamp:2012-09-21/02-04-45,Unit_ID:CW,Patient_ID:Pa123457')
		
		jmsService.send(queue:'PFM_Event','event:PatientAdmittedWithBed,timestamp:2012-09-21/4-26-00,Location_ID:R106,Unit_ID:CW,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:WaitForTransport,timestamp:2012-09-21/4-27-00,Unit_ID:CW,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:PatientTransportStarted,Unit_ID:CW,timestamp:2012-09-21/4-39-00,Patient_ID:Pa123457')
		jmsService.send(queue:'PFM_Event','event:PatientArrivedInBed,timestamp:2012-09-21/4-57-00,Location_ID:R106,Unit_ID:CW,Patient_ID:Pa123457')
		
		jmsService.send(queue:'PFM_Event','event:BedCleanUpRequest,timestamp:2012-09-21/09-10-00,Unit_ID:CW,Location_ID:R107')
		jmsService.send(queue:'PFM_Event','event:WaitForBedCleanUp,timestamp:2012-09-21/09-10-10,Unit_ID:CW,Location_ID:R107')
		//jmsService.send(queue:'PFM_Event','event:BedCleanUpStarted,timestamp:2012-09-21/11-10-00,Unit_ID:CW,Location_ID:R107,HouseKeeping_ID:R107')
		//jmsService.send(queue:'PFM_Event','event:BedCleanUpCompleted,timestamp:2012-09-21/12-10-10,Unit_ID:CW,Location_ID:R107,HouseKeeping_ID:R107')
	}
	def createUnits() {
		
		def room1 = new Room()
		room1.roomID = "AssessmentRoom"
		room1.save()
		def unit1 = new Unit()
		unit1.unitId = "ED"
		unit1.rooms.add(room1)
		unit1.save()
		
		def room2 = new Room()
		room2.roomID = "CCLRoom"
		room2.save()
		def unit2 = new Unit()
		unit2.unitId = "CCL"
		unit2.rooms.add(room2)
		unit2.save()
		
		def room3 = new Room()
		room3.roomID = "R107"
		room3.save()
		def room4 = new Room()
		room4.roomID = "R106"
		room4.save()
		def room5 = new Room()
		room5.roomID = "R105"
		room5.save()
		def unit3 = new Unit()
		unit3.unitId = "CW"
		unit3.rooms.add(room3)
		unit3.rooms.add(room4)
		unit3.rooms.add(room5)
		unit3.save()
		
	}
}
