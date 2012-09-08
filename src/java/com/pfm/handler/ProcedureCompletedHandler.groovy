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
<<<<<<< HEAD
		patientState.target = 60
=======
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		updatePatientState(patientState)
		
		return null;
	}

}
