package com.pfm.handler


import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class WaitForDischargeHandler extends EventHandler{
	
	@Override 
	public Object process(Map props){
		
		event.eventName = EventName.WaitForDischarge
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_DISCHARGE
		updatePatientState(patientState)
		
		return null;
	}

}
