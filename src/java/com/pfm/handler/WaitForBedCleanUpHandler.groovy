package com.pfm.handler

import java.util.Map;

import patientflowmonitoring.Room;
import patientflowmonitoring.RoomState;
import patientflowmonitoring.RoomState.RoomStateName;
import patientflowmonitoring.BEvent.BEventName;


class WaitForBedCleanUpHandler extends EventHandler{
	@Override
	
	public process(Map props){
		
		event1.eventName = BEventName.WaitForBedCleanUp
		// Code to update the bed state to WAIT_FOR_BED_CLEANUP
		//def roomState = new RoomState()
		//roomState.stateName = RoomStateName.WAIT_FOR_BED_CLEANUP
		//roomState.stateAttributes.put ("Room_ID", props["Location_ID"])
		//updateRoomState(roomState)
	}

}
