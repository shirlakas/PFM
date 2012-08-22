package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ProceduresScheduledHandler extends EventHandler{
	
	@Override 
	public Object process(Map Props){
		
		event.eventName = EventName.ProceduresScheduled
		return null;
		
	}

}
