package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class WaitForConsultation2Handler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForConsultation2
		
//		def patient = Patient.findByPatientID(patientId)
//		log.info("patient is ${patient}")
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_CONSULTATION2
		patientState.target = 30
		updatePatientState(patientState)
		//patient.setCurrentState(patientState,createTimeStamp(props['timestamp']))
//		patient.appendEvent(event)
//		patient.save()
		
		return null;

	}

}
