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
<<<<<<< HEAD
		patientState.target = 30
=======
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		updatePatientState(patientState)
		return null;
	}

}
