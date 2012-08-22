package com.pfm.handler;

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName

public class PatientRegisteredHandler extends EventHandler {

	def process(Map props){

		event.eventName = EventName.Registered
		
		patient.roomID = props['Room_ID']
	//	patient.save()
		
		log.info(patientId + " Patient Registered") // for logging purpose only
		
		def patientState = new PatientState()				// Since this event will cause the state change of the patient, the following three lines are for updating patient state
		patientState.stateName = PatientStateName.NEW
		updatePatientState(patientState)
		
//		log.info("PatientRegisteredHandler")
		
//		log.info("patient id is ${patientId}")
//		def patient = Patient.findByPatientID(patientId)
//		log.info("patient is ${patient}")
//		
//		patient.appendEvent(event)
//		patient.save()
		
		return null;
	}

}
