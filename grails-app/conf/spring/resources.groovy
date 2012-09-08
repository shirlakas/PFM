// Place your Spring DSL code here

import org.apache.activemq.ActiveMQConnectionFactory

beans = {
	
	jmsConnectionFactory(ActiveMQConnectionFactory){
		brokerURL = "tcp://localhost:61616"
	}
	
	defaultJmsTemplate(org.springframework.jms.core.JmsTemplate){
		connectionFactory = ref("jmsConnectionFactory")
	}
	
	triagescoreHandler(com.pfm.handler.TriageScoreHandler){}
	patientregisteredHandler(com.pfm.handler.PatientRegisteredHandler){}
	waitforconsultation1Handler(com.pfm.handler.WaitForConsultation1Handler){}
	waitforconsultation2Handler(com.pfm.handler.WaitForConsultation2Handler){}
	consultationstarted1Handler(com.pfm.handler.ConsultationStarted1Handler){}
	consultationstarted2Handler(com.pfm.handler.ConsultationStarted2Handler){}
	orderrequestHandler(com.pfm.handler.OrderRequestHandler){}
	consultationcompleted1Handler(com.pfm.handler.ConsultationCompleted1Handler){}
	consultationcompleted2Handler(com.pfm.handler.ConsultationCompleted2Handler){}
	requestreferralHandler(com.pfm.handler.RequestReferralHandler){}
	waitfororderexecutionHandler(com.pfm.handler.WaitForOrderExecutionHandler){}
	orderrequestcompletedHandler(com.pfm.handler.OrderRequestCompletedHandler){}
	//orderexecutioncompletedHandler(com.pfm.handler.OrderExecutionCompletedHandler){}
	ordersexecutioncompletedHandler(com.pfm.handler.OrdersExecutionCompletedHandler){}
	bedrequestHandler(com.pfm.handler.BedRequestHandler){}
	patientadmittedwithnobedHandler(com.pfm.handler.PatientAdmittedWithNoBedHandler){}
	waitforbedHandler(com.pfm.handler.WaitForBedHandler){}
	patientadmittedwithbedHandler(com.pfm.handler.PatientAdmittedWithBedHandler){}
	patienttransportrequestHandler(com.pfm.handler.PatientTransportRequestHandler){}
	waitfortransportHandler(com.pfm.handler.WaitForTransportHandler){}
	patienttransportstartedHandler(com.pfm.handler.PatientTransportStartedHandler){}
	patientarrivedinbedHandler(com.pfm.handler.PatientArrivedInBedHandler){}
	
	//extended scenario events
	consultationstarted3Handler(com.pfm.handler.ConsultationStarted3Handler){}
	consultationcompleted3Handler(com.pfm.handler.ConsultationCompleted3Handler){}
	waitforproceduresHandler(com.pfm.handler.WaitForProceduresHandler){}
	procedurerequestHandler(com.pfm.handler.ProcedureRequestHandler){}
	procedurestartedHandler(com.pfm.handler.ProcedureStartedHandler){}
	procedurecompletedHandler(com.pfm.handler.ProcedureCompletedHandler){}
	proceduresexecutioncompletedHandler(com.pfm.handler.ProceduresExecutionCompletedHandler){}
	proceduresscheduledHandler(com.pfm.handler.ProceduresScheduledHandler){}
	procedureupdatedHandler(com.pfm.handler.ProcedureUpdatedHandler){}
	dischargecompletedHandler(com.pfm.handler.DischargeCompletedHandler){}
	dischargerequestHandler(com.pfm.handler.DischargeRequestHandler){}
	waitfordischargeHandler(com.pfm.handler.WaitForDischargeHandler){}
	bedcleanuprequestHandler(com.pfm.handler.BedCleanUpRequestHandler){}
	waitforbedcleanupHandler(com.pfm.handler.WaitForBedCleanUpHandler){}
	bedcleanupstartedHandler(com.pfm.handler.BedCleanUpStartedHandler){}
	bedcleanupcompletedHandler(com.pfm.handler.BedCleanUpCompletedHandler){}
	
	
	
	
	
}
