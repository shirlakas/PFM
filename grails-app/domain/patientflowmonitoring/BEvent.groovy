package patientflowmonitoring

import java.util.Date;
import java.util.Map;

class BEvent {
	
	enum BEventName{
		
		// new events for extended scenario
		PatientAdmittedWithBed,
		PatientArrivedInBed,
		BedCleanUpRequest,
		WaitForBedCleanUp,
		BedCleanUpStarted,
		BedCleanUpCompleted
		
		
	}
	
	BEventName eventName
	Date timeStamp
	Map eventAttrs = [:]
	Room room;
	
	static belongesTo = [room:Room]

    static constraints = {
		room()
		eventName(nullable:true)
		eventAttrs(nullable:true)
		timeStamp(nullable:true)
    }
	
	String toString(){"${this.eventName}"}
}

