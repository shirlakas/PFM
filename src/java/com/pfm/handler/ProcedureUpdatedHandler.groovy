package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ProcedureUpdatedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ProcedureUpdated
		//def patientState = new PatientState()
		
		//patientState.stateAttributes.put ('ProcedureType', props['Procedure_Type'])
		//patientState.stateAttributes.put ('Status', props['Status'])
		
		//updatePatientState(patientState)
		
		return null;
	}

}
