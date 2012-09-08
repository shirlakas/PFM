package com.pfm.handler


import java.util.Map;

import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.PatientState.PatientStateName;
import patientflowmonitoring.Discharge;

class DischargeCompletedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.DischargeCompleted
		
		def patientState = new PatientState()
		patientState.stateName = PatientStateName.DISCHARGED
<<<<<<< HEAD
		patientState.target = 15
		patient.roomID = ""
		patientState.endTime = createTimeStamp(props['timestamp'])+1
=======
		patient.roomID = ""
>>>>>>> f4fa27adbc363f20abc26a27a8643268f9638a66
		updatePatientState(patientState)
		
		def Discharge discharge = new Discharge()
		discharge.setTimeStamp(createTimeStamp(props['timestamp']))
		discharge.save()
		
		return null;
	}

}

