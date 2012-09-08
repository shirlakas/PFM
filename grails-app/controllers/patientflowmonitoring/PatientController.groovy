package patientflowmonitoring

import java.util.Date;
import groovy.time.TimeCategory;
import java.util.List;
import java.util.Map;
import grails.converters.*
import patientflowmonitoring.PatientState.PatientStateName
import patientflowmonitoring.PatientState

class PatientController {
	
	def scaffold = true
	def unitService
	def patientService
	
	static navigation = [
		[group:'tabs',action:'getPatientMap', title:'Floor',order:0],
		[action:'getPatientDetails', title:'Patient',order:5]
	]
	
	def getPatientRoomMapping = {
		
		def retVal = new StringBuffer()
		retVal.append("[")
		def patientMap = patientService.queryPatientMap()
		def es = patientMap.entrySet()
		es.each{
			retVal.append("{\"patientId\":\"${it.value}\",\"roomId\":\"${it.key}\"},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(contentType:"application/json",text:retVal)
		
	}
	
	def getPatientMap = {
		
		def patientMap = patientService.queryPatientMap()
		
		render(view:"UnitMap1",model:
			[mapping:patientMap,unitIds:unitService.getUnitIds()])
	}
	
	def getEventList = {
		
		def patientId = params.id
		Patient patient = Patient.findByPatientID(params.id)
		List events = patient.events
		
		def retVal = new StringBuffer()
		retVal.append("[")
		events.each{
			retVal.append("{\"event\":\"${it.eventName}\",\"timeStamp\":\"${it.timeStamp}\"},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(contentType:"application/json",text:retVal)
		
	}
	
	def getStateList = {
		
		def patientId = params.id
		Patient patient = Patient.findByPatientID(params.id)
		List states = patient.states
		
		def retVal = new StringBuffer()
		retVal.append("[")
		states.each{
			retVal.append("{\"state\":\"${it.stateName}\",\"startTime\":\"${it.startTime}\",\"endTime\":\"${it.endTime}\",\"duration\":\"${it.duration}\",\"target\":\"${it.target}\"},")
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
		render(contentType:"application/json",text:retVal)
		
	}
	
	def getPatientDetails = {
		def file = new File(servletContext.getRealPath("/html/ClinicalPathway.html"))
		String clincalpathWay = file.getText()
		int total=0;
		int totalhrs=0;
		int totalmins=0;
		def duratn;
		if (params.id){
			Patient patient = Patient.findByPatientID(params.id)
			session.patient=patient
		
			
			List states = patient.states
			if(patient.roomID==""){
				//Obtain list of states and compute the total duration
				states.each{
				 duratn=it.duration
				 total +=duratn.toInteger()
				}
			}
			else{
				//Obtain start time of TRIAGED event and compute total by subtracting from current time
				def triage = states.get(0)
				def strtTime = triage.startTime
				def now = new Date()
				total=TimeCategory.minus(now,strtTime).toMilliseconds()/60000;	
			}
			total=total.intValue()
			totalhrs = total.intdiv(60)
			totalmins = total%totalhrs
			render(view:"patientDetails",model:
				[patient:patient,clincalPathWay:clincalpathWay,totalhrs:totalhrs,totalmins:totalmins])
			
		}else if(session.patient){
			Patient patient=session.patient
			List states = patient.states
			if(patient.roomID==""){
				states.each{
				duratn=it.duration
				total +=duratn.toInteger()
				}
				
			}
			else{
				def triage = states.get(0)
				def strtTime = triage.startTime
				def now = new Date()
				total=TimeCategory.minus(now,strtTime).toMilliseconds()/60000 +1;	
			}
			
			//totalhrs = TimeCategory.getHour( total)
			total=total.intValue()
			//total=total.round(0)
			totalhrs = total.intdiv(60)
			totalmins = total%totalhrs
		
		render(view:"patientDetails",model:
		[patient:session.patient,clincalPathWay:clincalpathWay, totalhrs:totalhrs,totalmins:totalmins])
		}else{
			getPatientMap()
		}

	}
	
	def getCurrentPatientsWaitTime = {
	
		def patients = patientService.getWaitingPatients()

		render(view:"currentPatientsWaitTime",model:[patients:patients])
	}
	
	def getAverageDuration = {
		def retVal =  "[{\"state\":\"TRIAGED\",\"duration\":\"3\"},{\"state\":\"WAIT_FOR_CONSULTATION1\",\"duration\":\"2\"},{\"state\":\"IN_CONSULTATION1\",\"duration\":\"3\"},{\"state\":\"IN_BED_ED\",\"duration\":\"5\"},{\"state\":\"WAIT_FOR_ORDER_EXECUTION\",\"duration\":\"1\"},{\"state\":\"WAIT_FOR_CONSULTATION2\",\"duration\":\"2\"},{\"state\":\"IN_CONSULTATION2\",\"duration\":\"1\"},{\"state\":\"IN_BED_ED\",\"duration\":\"3\"},{\"state\":\"WAIT_FOR_BED_CW\",\"duration\":\"5\"},{\"state\":\"WAIT_FOR_TRANSPORT_CW\",\"duration\":\"1\"},{\"state\":\"IN_TRANSPORT_CW\",\"duration\":\"1\"},{\"state\":\"IN_BED_CW\",\"duration\":\"5\"},{\"state\":\"WAIT_FOR_PROCEDURES\",\"duration\":\"5\"},{\"state\":\"WAIT_FOR_TRANSPORT_CCL\",\"duration\":\"1\"},{\"state\":\"IN_TRANSPORT_CCL\",\"duration\":\"1\"},{\"state\":\"IN_BED_CCL\",\"duration\":\"2\"},{\"state\":\"IN_PROCEDURE_ANGIOGRAM\",\"duration\":\"4\"},{\"state\":\"IN_BED_CCL\",\"duration\":\"1\"},{\"state\":\"IN_PROCEDURE_PCI\",\"duration\":\"5\"},{\"state\":\"IN_BED_CCL\",\"duration\":\"5\"},{\"state\":\"WAIT_FOR_TRANSPORT_CW\",\"duration\":\"1\"},{\"state\":\"IN_TRANSPORT_CW\",\"duration\":\"1\"},{\"state\":\"IN_BED_CW\",\"duration\":\"10\"},{\"state\":\"IN_CONSULTATION3\",\"duration\":\"2\"},{\"state\":\"IN_BED_CW\",\"duration\":\"3\"},{\"state\":\"WAIT_FOR_DISCHARGE\",\"duration\":\"1\"},{\"state\":\"DISCHARGED\",\"duration\":\"0\"}]";
		render(contentType:"application/json",text:retVal)
		
		}
	
	def getWaitTime = {
		def patientId = params.id
		Patient patient = Patient.findByPatientID(params.id)
		List states = patient.states
		def total = 0
		def retVal = new StringBuffer()
		retVal.append("[")
		states.each{
			retVal.append("{\"state\":\"${it.stateName}\",\"duration\":\"${it.duration}\"},")
			
		}
		if (retVal.size()>1){
			def temp = retVal.substring(0,retVal.size()-1);
			retVal = new StringBuffer(temp);
		}
		retVal.append("]")
	  render(contentType:"application/json",text:retVal)

	}
	
	def Date createTimeStamp(String ts){
		return Date.parse ("yyyy-MM-dd/HH-mm-ss", ts)
	}
}
