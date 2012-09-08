package patientflowmonitoring

class Monitor {
	
	List patients
	List rooms
	
	static hasMany = [patients:Patient,rooms:Room]

    static constraints = {
    }
}
