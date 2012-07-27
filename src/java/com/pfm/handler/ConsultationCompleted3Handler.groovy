package com.pfm.handler
import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class ConsultationCompleted3Handler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ConsultationCompleted3
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_BED_CW
		//patientState.stateAttributes.put ('PhysicianId', props['Physician_ID'])
		updatePatientState(patientState)
		
		return null;
	}

}