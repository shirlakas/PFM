package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;

class WaitForConsultation1Handler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.WaitForConsultation1
		
//		def patient = Patient.findByPatientID(patientId)
//		log.info("patient is ${patient}")
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.WAIT_FOR_CONSULTATION1
<<<<<<< HEAD
		patientState.target = 30
=======
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		updatePatientState(patientState)
		//patient.setCurrentState(patientState,createTimeStamp(props['timestamp']))
//		patient.appendEvent(event)
//		patient.save()
		
		return null;

	}
}
