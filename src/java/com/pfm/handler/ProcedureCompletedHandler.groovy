package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ProcedureCompletedHandler extends EventHandler{
	@Override 
	public Object process(Map props) {
		
		event.eventName = EventName.ProcedureCompleted
		
		def patientState = new PatientState()
		patientState.stateAttributes.put ('ProviderId', props['Provider_ID'])
		patientState.stateAttributes.put ('ProcedureType', props['Procedure_Type'])
		
		patientState.stateName = PatientStateName.IN_BED_CCL
		patientState.target = 60
		updatePatientState(patientState)
		
		return null;
	}

}
