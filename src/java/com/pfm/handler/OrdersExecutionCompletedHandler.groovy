package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class OrdersExecutionCompletedHandler extends EventHandler{
	
	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.OrdersExecutionCompleted
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.ORDERS_EXECUTION_COMPLETE
		updatePatientState(patientState)
		
		return null;
	}

}
