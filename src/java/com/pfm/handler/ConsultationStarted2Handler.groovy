package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ConsultationStarted2Handler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ConsultationStarted2
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_CONSULTATION2
		updatePatientState(patientState)
		
		return null;
	}

}

