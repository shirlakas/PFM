package com.pfm.handler

import java.util.Map;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.BEvent.BEventName;
import patientflowmonitoring.Patient;
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName;
import patientflowmonitoring.Room;
import patientflowmonitoring.RoomState;
import patientflowmonitoring.RoomState.RoomStateName;
import patientflowmonitoring.Admission;


class PatientAdmittedWithBedHandler extends EventHandler {

	@Override
	public Object process(Map props) {
		
		event.eventName = EventName.PatientAdmittedWithBed
		patient.roomID = props['Location_ID']
		
		def Admission admission = new Admission()
		admission.setTimeStamp(createTimeStamp(props['timestamp']))
		admission.save()
		
		//Update the bed state to BED_ASSIGNED
		
		event1.eventName = BEventName.PatientAdmittedWithBed
		def roomState = new RoomState()
		roomState.stateName = RoomStateName.BED_ASSIGNED
	    roomState.stateAttributes.put ("Room_ID", props["Location_ID"])
		updateRoomState(roomState)
			
		return null;
	}

}
