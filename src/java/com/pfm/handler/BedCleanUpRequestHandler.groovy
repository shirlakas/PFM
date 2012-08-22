package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Room;
import patientflowmonitoring.RoomState;
import patientflowmonitoring.RoomState.RoomStateName;
import patientflowmonitoring.BEvent.BEventName;


class BedCleanUpRequestHandler extends EventHandler{
	
	@Override
	
	public Object process(Map props){
		
		event1.eventName = BEventName.BedCleanUpRequest
		def roomState = new RoomState()
		roomState.stateName = RoomStateName.WAIT_FOR_BED_CLEANUP
		roomState.stateAttributes.put ("Room_ID", props["Location_ID"])
		updateRoomState(roomState)
		
		return null;
		
		
	}

}
