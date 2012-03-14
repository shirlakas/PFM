package patientflowmonitoring

class Event {
	
	enum EventName{
		Triage,
		Registered,
		//WaitForConsultation,
		WaitForConsultation1,
		//ConsultationStarted,
		//ConsultationCompleted,
		ConsultationStarted1,
		ConsultationCompleted1,
		ConsultationStarted2,
		ConsultationCompleted2,
		OrderRequest,
		WaitForOrderExecution,
		OrderRequestCompleted,
		OrderExecutionCompleted,
		WaitForConsultation2,
		BedRequest,
		PatientAdmittedWithNoBed,
		PatientAdmittedWithBed,
		WaitForBed,
		PatientTransportRequest,
		WaitForTransport,
		PatientTransportStarted,
		PatientArrivedInBed,
		Discharge
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
