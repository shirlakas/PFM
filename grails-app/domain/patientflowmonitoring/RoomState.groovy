package patientflowmonitoring

import java.util.Date;
import java.util.Map;
import groovy.time.TimeCategory

class RoomState {

  enum RoomStateName {
		BED_ASSIGNED,
		BED_OCCUPIED,
		WAIT_FOR_BED_CLEANUP,
		IN_CLEANUP,
		BED_AVAILABLE
		}

	RoomStateName stateName;
	Room room;
	Date startTime;
	Date endTime;
	int duration;
	Map stateAttributes=[:];
	
	static belongesTo = [room:Room]

    static constraints = {
		//room()
		stateName(nullable:true)
		startTime(nullable:true)
		endTime(nullable:true)
		duration(nullable:true)
		stateAttributes(nullable:true)
    }

	def void setEndTime(Date ts){
		endTime = ts
		if (startTime!=null&&endTime!=null){
			duration = TimeCategory.minus(endTime,startTime).toMilliseconds()/60000 +1
		}
	}
	
	
	String toString() {"${this.stateName}"}
}
