package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;;

class WaitForBedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForBed
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_BED_CW
<<<<<<< HEAD
		patientState.target = 480
=======
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		patientState.stateAttributes.put ("Unit_ID", props["Unit_ID"])
		//patient.setCurrentState(patientState,null)
		updatePatientState(patientState)
		
		return null;
	}

}
