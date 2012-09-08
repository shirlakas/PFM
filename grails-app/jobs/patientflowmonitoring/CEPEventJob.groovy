/* This file creates a cron job which runs every 2 secs to 
 * check the CEP output folder (xml) for xml files
 * If a file exists, it parses it, puts it on the PFM queue 
 * and sends a copy to message broker via SOAP
 */


package patientflowmonitoring


import groovy.util.XmlSlurper
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.IOException;
import java.util.Map
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes;
import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.springframework.context.*;
import java.text.SimpleDateFormat;
import groovy.io.FileType
import grails.plugin.jms.*


class CEPEventJob {
	
	PFMServerService	sendClient
	def jmsService
    static triggers = {
      simple name: 'ReadCEPTrigger', repeatInterval: 2000l // execute job once in 2 seconds 
    }

    def execute() {
						
						def servletContext = ServletContextHolder.servletContext
						def folder = servletContext.getRealPath('/xml')
						def baseDir = new File(folder)
						def files=[]
						def msg=""
						def iterator=0
						baseDir.eachFileRecurse(){
								files<<it.name
							
								//parsing the file contents and processing in PFM
								
								def connector = new XmlParser().parse("$folder"+'/'+"${files[iterator]}")
								def event= connector.'connector-bundle'[0].@name
								if ("${event.toString()}".compareTo("ConsultationStarted1")==0)
								{
									def patientId=connector."connector-bundle".ConsultationStarted1Object.Patient_ID.text()
									def physicianId=connector."connector-bundle".ConsultationStarted1Object.Physician_ID.text()
									def locationId=connector."connector-bundle".ConsultationStarted1Object.Location_ID.text()
									def timestamp=connector."connector-bundle".ConsultationStarted1Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationStarted1Response response=sendClient.consultationStarted1("$patientId", "$physicianId", "$locationId", "$timestamp")
									}
								else if ("${event.toString()}".compareTo("ConsultationStarted2")==0)
								{
									def patientId=connector."connector-bundle".ConsultationStarted2Object.Patient_ID.text()
									def physicianId=connector."connector-bundle".ConsultationStarted2Object.Physician_ID.text()
									def locationId=connector."connector-bundle".ConsultationStarted2Object.Location_ID.text()
									def timestamp=connector."connector-bundle".ConsultationStarted2Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationStarted2Response response = sendClient.consultationStarted2("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ConsultationCompleted1")==0)
								{
									def patientId=connector."connector-bundle".ConsultationCompleted1Object.Patient_ID.text()
									def physicianId=connector."connector-bundle".ConsultationCompleted1Object.Physician_ID.text()
									def locationId=connector."connector-bundle".ConsultationCompleted1Object.Location_ID.text()
									def timestamp=connector."connector-bundle".ConsultationCompleted1Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationCompleted1Response response = sendClient.consultationCompleted1("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ConsultationCompleted2")==0)
								{
									def patientId=connector."connector-bundle".ConsultationCompleted2Object.Patient_ID.text()
									def physicianId=connector."connector-bundle".ConsultationCompleted2Object.Physician_ID.text()
									def locationId=connector."connector-bundle".ConsultationCompleted2Object.Location_ID.text()
									def timestamp=connector."connector-bundle".ConsultationCompleted2Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationCompleted2Response response = sendClient.consultationCompleted2("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForConsultation1")==0)
								{
									def patientId=connector."connector-bundle".WaitForConsultation1Object.Patient_ID.text()
									def locationId=connector."connector-bundle".WaitForConsultation1Object.Location_ID.text()
									def timestamp=connector."connector-bundle".WaitForConsultation1Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestp"
									WaitForConsultation1Response response = sendClient.waitForConsultation1("$patientId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForConsultation2")==0)
								{
									def patientId=connector."connector-bundle".WaitForConsultation2Object.Patient_ID.text()
									def locationId=connector."connector-bundle".WaitForConsultation2Object.Location_ID.text()
									def timestamp=connector."connector-bundle".WaitForConsultation2Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestp"
									WaitForConsultation2Response response = sendClient.waitForConsultation2("$patientId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForBed")==0)
								{
									def patientId=connector."connector-bundle".WaitForBedObject.Patient_ID.text()
									def unitId=connector."connector-bundle".WaitForBedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForBedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForBedResponse response = sendClient.waitForBed("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForTransport")==0)
								{
									def patientId=connector."connector-bundle".WaitForTransportObject.Patient_ID.text()
									def unitId=connector."connector-bundle".WaitForTransportObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForTransportObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForTransportResponse response = sendClient.waitForTransport("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForOrderExecution")==0)
								{
									def patientId=connector."connector-bundle".WaitForOrderExecutionObject.Patient_ID.text()
									def timestamp=connector."connector-bundle".WaitForOrderExecutionObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,timestamp:$timestp"
									WaitForOrderExecutionResponse response = sendClient.waitForOrderExecution("$patientId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("PatientTransportStarted")==0)
								{
									def patientId=connector."connector-bundle".PatientTransportStartedObject.Patient_ID.text()
									def unitId=connector."connector-bundle".PatientTransportStartedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".PatientTransportStartedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									PatientTransportStartedResponse response = sendClient.patientTransportStarted("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("PatientArrivedInBed")==0)
								{
									def patientId=connector."connector-bundle".PatientArrivedInBedObject.Patient_ID.text()
									def locationId=connector."connector-bundle".PatientArrivedInBedObject.Location_ID.text()
									def unitId=connector."connector-bundle".PatientArrivedInBedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".PatientArrivedInBedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$timestp"
									PatientArrivedInBedResponse response = sendClient.patientArrivedInBed("$patientId","$locationId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("OrdersExecutionCompleted")==0)
								{
									def patientId=connector."connector-bundle".OrdersExecutionCompletedObject.Patient_ID.text()
									def timestamp=connector."connector-bundle".OrdersExecutionCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,timestamp:$timestp"
									OrdersExecutionCompletedResponse response = sendClient.ordersExecutionCompleted("$patientId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForProcedures")==0)
								{
									def patientId=connector."connector-bundle".WaitForProceduresObject.Patient_ID.text()
									def unitId=connector."connector-bundle".WaitForProceduresObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForProceduresObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForProceduresResponse response = sendClient.waitForProcedures("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ProceduresExecutionCompleted")==0)
								{
									def patientId=connector."connector-bundle".ProceduresExecutionCompletedObject.Patient_ID.text()
									def timestamp=connector."connector-bundle".ProceduresExecutionCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,timestamp:$timestp"
									ProceduresExecutionCompletedResponse response = sendClient.proceduresExecutionCompleted("$patientId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ConsultationStarted3")==0)
								{
									def patientId=connector."connector-bundle".ConsultationStarted3Object.Patient_ID.text()
									def physicianId=connector."connector-bundle".ConsultationStarted3Object.Physician_ID.text()
									def locationId=connector."connector-bundle".ConsultationStarted3Object.Location_ID.text()
									def timestamp=connector."connector-bundle".ConsultationStarted3Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationStarted3Response response = sendClient.consultationStarted3("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ConsultationCompleted3")==0)
								{
									def patientId=connector."connector-bundle".ConsultationCompleted3Object.Patient_ID.text()
									def physicianId=connector."connector-bundle".ConsultationCompleted3Object.Physician_ID.text()
									def locationId=connector."connector-bundle".ConsultationCompleted3Object.Location_ID.text()
									def timestamp=connector."connector-bundle".ConsultationCompleted3Object.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationCompleted3Response response = sendClient.consultationCompleted3("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForDischarge")==0)
								{
									def patientId=connector."connector-bundle".WaitForDischargeObject.Patient_ID.text()
									def unitId=connector."connector-bundle".WaitForDischargeObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForDischargeObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForDischargeResponse response = sendClient.waitForDischarge("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("DischargeCompleted")==0)
								{
									def patientId=connector."connector-bundle".DischargeCompletedObject.Patient_ID.text()
									def unitId=connector."connector-bundle".DischargeCompletedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".DischargeCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									DischargeCompletedResponse response = sendClient.dischargeCompleted("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForBedCleanUp")==0)
								{
									def locationId=connector."connector-bundle".WaitForBedCleanUpObject.Location_ID.text()
									def unitId=connector."connector-bundle".WaitForBedCleanUpObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForBedCleanUpObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForBedCleanUpResponse response = sendClient.waitForBedCleanUp("$locationId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("BedCleanUpStarted")==0)
								{
									def houseKeepingId=connector."connector-bundle".BedCleanUpStartedObject.HouseKeeping_ID.text()
									def locationId=connector."connector-bundle".BedCleanUpStartedObject.Location_ID.text()
									def unitId=connector."connector-bundle".BedCleanUpStartedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".BedCleanUpStartedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,HouseKeeping_ID:$houseKeepingId,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$timestp"
									BedCleanUpStartedResponse response = sendClient.bedCleanUpStarted("$houseKeepingId","$locationId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("BedCleanUpCompleted")==0)
								{
									def houseKeepingId=connector."connector-bundle".BedCleanUpCompletedObject.HouseKeeping_ID.text()
									def locationId=connector."connector-bundle".BedCleanUpCompletedObject.Location_ID.text()
									def unitId=connector."connector-bundle".BedCleanUpCompletedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".BedCleanUpCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,HouseKeeping_ID:$houseKeepingId,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$timestp"
									BedCleanUpCompletedResponse response = sendClient.bedCleanUpCompleted("$houseKeepingId","$locationId","$unitId","$timestamp")
								}
								iterator++
								it.delete()
								jmsService.send(queue:'PFM_Event',msg)
								
								msg=""
								
							}
	        // execute job 
		print "Job run!"
		}	
	
	//Converting data to format accepted by PFM
	def String modifyTimeStamp(String ts){
		String pattern = "yyyy-MM-dd'T'HH:mm:ss"
		SimpleDateFormat dte = new SimpleDateFormat(pattern)
		Date dat = dte.parse(ts)
		String out = dat.format("yyyy-MM-dd/HH-mm-ss")
		return out
	}
}

