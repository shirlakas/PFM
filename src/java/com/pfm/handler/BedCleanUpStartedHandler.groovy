package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Room;
import patientflowmonitoring.RoomState;
import patientflowmonitoring.BEvent.BEventName;
import patientflowmonitoring.RoomState.RoomStateName;

class BedCleanUpStartedHandler extends EventHandler{
	
	@Override
	
	public Object process(Map props){
		event1.eventName = BEventName.BedCleanUpStarted
		
		// Code to update bed state to IN_CLEANUP
		def roomState = new RoomState()
		roomState.stateName = RoomStateName.IN_CLEANUP
		roomState.stateAttributes.put ("Room_ID", props["Location_ID"])
		updateRoomState(roomState)
		return null;
	}

}
