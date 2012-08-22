package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class WaitForProceduresHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForProcedures
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_PROCEDURES
		patientState.target = 30
		updatePatientState(patientState)
		return null;
	}

}
