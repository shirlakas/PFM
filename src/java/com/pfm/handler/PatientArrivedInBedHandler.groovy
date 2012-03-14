package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class PatientArrivedInBedHandler extends EventHandler {
	
	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientArrivedInBed
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.IN_BED
		patientState.stateAttributes.put ('BedId', props['Bed_ID'])
		updatePatientState(patientState)
		
		return null;
	}

}
