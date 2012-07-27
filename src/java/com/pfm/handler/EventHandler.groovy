package com.pfm.handler

import org.apache.commons.logging.LogFactory;

import patientflowmonitoring.Patient
import patientflowmonitoring.PatientState;
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.Room
import patientflowmonitoring.RoomState;
import patientflowmonitoring.RoomState.RoomStateName
import patientflowmonitoring.Event;
import patientflowmonitoring.Event.EventName;
import patientflowmonitoring.BEvent;
import patientflowmonitoring.BEvent.BEventName;

abstract class EventHandler {
	
	static final log = LogFactory.getLog(this)
	
	def Event event
	def BEvent event1
	def Patient patient
	def Room room
	def String patientId
	def String roomId
	def String eventn
	
	def void handle(Map props){

		pre_process(props)
		process(props)
		post_process()
		
		}
	
	def void pre_process(props){
		patientId = props['Patient_ID']
		roomId = props['Location_ID']
		eventn =props['event']
		log.info("~~~Event received is ${props} is processed~~~")
		// if patientId is not null then find the patient else do nothing.
		//if bedId is not null then find the bed
		if (patientId){
			event = new Event()
			event.eventAttrs = props
			event.timeStamp = createTimeStamp(props['timestamp'])
			patient = Patient.findByPatientID(patientId)
			if (!patient){
				patient = new Patient(patientID:patientId)
				patient.save()
			}
			//patient.save()
		}
		if(((roomId)&&(!patientId))||(eventn=="PatientAdmittedWithBed")||(eventn=="PatientArrivedInBed")){
			event1=new BEvent()
			event1.eventAttrs = props
			event1.timeStamp = createTimeStamp(props['timestamp'])
			log.info("~~~Room ID is ${roomId} ~~~")
			room = Room.findByRoomID(roomId)
			log.info("~~~Room ${room} is found~~~")
			log.info("~~~Bed event attributes are ${event1.eventAttrs} is processed~~~")
			if (!room){
				room = new Room(roomID:roomId)
				log.info("~~~RoomID not found~~~")
				room.save()
			}
			//room.save()
		}
		
	}
	
	def void post_process(){
		if(patientId){
			patient.appendEvent(event)
			patient.save()
			log.info("~~~event ${event.eventName} is processed~~~")
			
		}
		if(((roomId)&&(!patientId))||(eventn=="PatientAdmittedWithBed")||(eventn=="PatientArrivedInBed")){
			room.appendEvent(event1)
			room.save()
			log.info("~~~Post process Bed event ${event1.eventName} is processed~~~")
			
		}
	}
	
	def abstract process(Map props)
	
	def Date createTimeStamp(String ts){
		if (ts.startsWith("*")){
			def c= new GregorianCalendar()
			def year = c.get(Calendar.YEAR).toString()
			def month = (c.get(Calendar.MONTH)+1).toString().padLeft(2,'0')
			def date = c.get(Calendar.DATE).toString()
			ts=ts.replace("*", "${year}-${month}-${date}")
		}
		return Date.parse ("yyyy-MM-dd/HH-mm-ss", ts)
	}
	
	def void updatePatientState(PatientState ps){
		patient.setCurrentState(ps,createTimeStamp(event.eventAttrs['timestamp']))
	}
	
	def void updateRoomState(RoomState ps){
		room.setCurrentState(ps,createTimeStamp(event1.eventAttrs['timestamp']))
	}
	
}
