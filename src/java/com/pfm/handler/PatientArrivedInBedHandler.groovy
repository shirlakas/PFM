package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.BEvent.BEventName;
import patientflowmonitoring.PatientState.PatientStateName;
import patientflowmonitoring.Room;
import patientflowmonitoring.RoomState;
import patientflowmonitoring.RoomState.RoomStateName;

class PatientArrivedInBedHandler extends EventHandler {
	
	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientArrivedInBed
		def patientState = new PatientState()
		patientState.stateAttributes.put ('Room_ID', props['Location_ID'])
		patientState.stateAttributes.put ('UnitId', props['Unit_ID'])
		if(patientState.stateAttributes.UnitId=='CCL'){
			patientState.stateName = PatientStateName.IN_BED_CCL
		}
		else if(patientState.stateAttributes.UnitId=='CW'){
			patientState.stateName = PatientStateName.IN_BED_CW
		}
		else{
			patientState.stateName = PatientStateName.IN_BED
		}
		updatePatientState(patientState)
		
		event1.eventName = BEventName.PatientArrivedInBed
		def roomState = new RoomState()
		roomState.stateName = RoomStateName.BED_OCCUPIED
		roomState.stateAttributes.put ("RoomId", props["Location_ID"])
		updateRoomState(roomState)
			
		return null;
	}

}
