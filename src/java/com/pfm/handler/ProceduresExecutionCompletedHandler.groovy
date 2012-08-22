package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ProceduresExecutionCompletedHandler extends EventHandler{
	
	@Override
	public Object process(Map props){
		
		event.eventName = EventName.ProceduresExecutionCompleted
		
		return null;
		
	}

}