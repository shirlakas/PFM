package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;
import patientflowmonitoring.Admission;

class PatientAdmittedWithNoBedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientAdmittedWithNoBed
		
		//def patientState = new PatientState()
		//patientState.stateName = PatientStateName.WAIT_FOR_BED_CW
		//patientState.stateAttributes.put ("UnitId", props["Unit_ID"])
		
		//updatePatientState(patientState)
		
		return null;
	}

}
