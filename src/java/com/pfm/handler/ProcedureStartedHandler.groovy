package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class ProcedureStartedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.ProcedureStarted
	
		def patientState = new PatientState()
		patientState.stateAttributes.put ('ProviderId', props['Provider_ID'])
		patientState.stateAttributes.put ('ProcedureType', props['Procedure_Type'])
		def procedureType = props['Procedure_Type']
		log.info( "procedure type is " + procedureType );
		if(patientState.stateAttributes.ProcedureType=='Angiogram'){
			patientState.stateName = PatientStateName.IN_PROCEDURE_ANGIOGRAM
<<<<<<< HEAD
			patientState.target = 45
		}
		else if(patientState.stateAttributes.ProcedureType=='PCI'){
			patientState.stateName = PatientStateName.IN_PROCEDURE_PCI
			patientState.target = 90
=======
		}
		else if(patientState.stateAttributes.ProcedureType=='PCI'){
			patientState.stateName = PatientStateName.IN_PROCEDURE_PCI
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		}
		else{
			patientState.stateName = PatientStateName.IN_PROCEDURE
		}
		updatePatientState(patientState)
		
		return null;
	}

}

