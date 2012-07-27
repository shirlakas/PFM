package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ConsultationStarted3Handler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ConsultationStarted3
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_CONSULTATION3
		//patientState.stateAttributes.put ('PhysicianId', props['Physician_ID'])
		updatePatientState(patientState)

		
		return null;
	}

}

