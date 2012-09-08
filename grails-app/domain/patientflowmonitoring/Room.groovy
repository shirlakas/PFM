package patientflowmonitoring

import java.util.Date;
import java.util.List;
import java.util.Map;

class Room {
	
	String roomID
	RoomState currentState
	BEvent lastEventReceived
	//String roomID
	//String unitID
	Map props = [:]
	List states = []
	List events = []
	
	static hasMany = [states:RoomState,events:BEvent]
	
	static mapping = {
		events cascade:'all-delete-orphan'
		states cascade:'all-delete-orphan'
	}

	static constraints = {
		
		
		lastEventReceived(nullable:true)
		states(nullable:true)
		events(nullable:true)
		props(nullable:true)
	}
 void terminateCurrentState(Date ts){
	  currentState?.setEndTime(ts);
	}
	
	void startCurrentState(Date ts){
	  currentState?.setStartTime(ts);
	}
	
	void changeState(RoomState newState, Date ts){
	  terminateCurrentState(ts);
	  setCurrentState(newState,ts);
	}
	
	void setCurrentState(RoomState newState, Date ts){
	  terminateCurrentState(ts);
	  currentState = newState;
	  states.add(currentState);
	  startCurrentState(ts);
	}
	
	public void appendEvent(BEvent event){
	  events.add(event)
	  lastEventReceived  = event
	}
		
	String toString() {"${this.roomID}"}
}