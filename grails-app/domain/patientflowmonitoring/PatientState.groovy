package patientflowmonitoring

import java.util.Date;
import java.util.Map;
import groovy.time.TimeCategory

class PatientState {
	
	enum PatientStateName {
		NEW,
		TRIAGED,
		WAIT_FOR_CONSULTATION1,
		WAIT_FOR_CONSULTATION2,
		IN_CONSULTATION1,
		IN_CONSULTATION2,
		IN_BED_ED,
		WAIT_FOR_ORDER_EXECUTION,
		ORDER_EXECUTION,
		ORDER_EXECUTION_COMPLETE,
		WAIT_FOR_BED_CW,
		WAIT_FOR_TRANSPORT_CW,
		WAIT_FOR_TRANSPORT_CCL,
		WAIT_FOR_TRANSPORT,
		IN_TRANSPORT_CCL,
		IN_TRANSPORT_CW,
		IN_TRANSPORT,
		IN_BED,
		IN_BED_CW,
		IN_BED_CCL,
		DISCHARGED,
		IN_PROCEDURE_ANGIOGRAM,
		IN_PROCEDURE_PCI,
		IN_CONSULTATION3,
		ORDERS_EXECUTION_COMPLETE,
		WAIT_FOR_PROCEDURES,
		IN_PROCEDURE,
		PROCEDURES_EXECUTION_COMPLETE,
		WAIT_FOR_DISCHARGE
		}
	
	PatientStateName stateName;
	Patient patient;
	Date startTime;
	Date endTime;
	int duration;
	Map stateAttributes=[:];
	
	static belongesTo = [patient:Patient]

    static constraints = {
		patient()
		stateName()
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
