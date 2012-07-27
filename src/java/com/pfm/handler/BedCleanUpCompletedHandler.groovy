package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Room;
import patientflowmonitoring.RoomState;
import patientflowmonitoring.RoomState.RoomStateName;
import patientflowmonitoring.BEvent.BEventName;

class BedCleanUpCompletedHandler extends EventHandler{
	@Override
	
	public Object process(Map props){
		
		event1.eventName = BEventName.BedCleanUpCompleted
		
		//Code to update the bed state to BED_AVAILABLE
		def roomState = new RoomState()
		roomState.stateName = RoomStateName.BED_AVAILABLE
		//roomState.stateAttributes.put ("Room_ID", props["Location_ID"])
		updateRoomState(roomState)
		
		return null;
		
	}

}
