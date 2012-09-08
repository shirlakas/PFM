package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class PatientTransportStartedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientTransportStarted
		
		def patientState = new PatientState()
		patientState.stateAttributes.put ('LocationId', props['Location_ID'])
		patientState.stateAttributes.put ('UnitId', props['Unit_ID'])
<<<<<<< HEAD
		patientState.target = 15
=======
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		if(patientState.stateAttributes.UnitId=='CCL'){
			patientState.stateName = PatientStateName.IN_TRANSPORT_CCL
		}
		else if(patientState.stateAttributes.UnitId=='CW'){
			patientState.stateName = PatientStateName.IN_TRANSPORT_CW
		}
		else{
			patientState.stateName = PatientStateName.IN_TRANSPORT
		}
		updatePatientState(patientState)
				
		return null;
	}

}