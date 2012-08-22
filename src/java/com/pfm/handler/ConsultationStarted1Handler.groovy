package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ConsultationStarted1Handler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ConsultationStarted1
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_CONSULTATION1
		//patientState.stateAttributes.put ('PhysicianId', props['Physician_ID'])
		updatePatientState(patientState)
		
		return null;
	}

}

