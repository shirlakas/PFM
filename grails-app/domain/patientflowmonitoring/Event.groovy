package patientflowmonitoring

import java.util.Date;
import java.util.Map;

class Event {
	
	enum EventName{
		Triage,
		Registered,
		WaitForConsultation1,
		ConsultationStarted1,
		ConsultationCompleted1,
		ConsultationStarted2,
		ConsultationCompleted2,
		OrderRequest,
		WaitForOrderExecution,
		OrderRequestCompleted,
		WaitForConsultation2,
		BedRequest,
		PatientAdmittedWithNoBed,
		PatientAdmittedWithBed,
		WaitForBed,
		PatientTransportRequest,
		WaitForTransport,
		PatientTransportStarted,
		PatientArrivedInBed,
		
		
		// new events for extended scenario
		OrdersExecutionCompleted,
		RequestReferral,
		ConsultationStarted3,
		ConsultationCompleted3,
		ProcedureRequest,
		ProceduresScheduled,
		WaitForProcedures,
		ProcedureStarted,
		ProcedureCompleted,
		ProcedureUpdated,
		ProceduresExecutionCompleted,
		DischargeRequest,
		WaitForDischarge,
		DischargeCompleted,
		//BedCleanUpRequest,
		//WaitForBedCleanUp,
		//BedCleanUpStarted,
		//BedCleanUpCompleted
		
		
	}
	
	EventName eventName
	Date timeStamp
	Map eventAttrs = [:]
	Patient patient;
	
	static belongesTo = [patient:Patient]

    static constraints = {
		patient()
		eventName(nullable:true)
		eventAttrs(nullable:true)
		timeStamp(nullable:true)
    }
	
	String toString(){"${this.eventName}"}
}
