/* This file creates a cron job which runs every 2 secs to 
 * check the CEP output folder (xml) for xml files
 * If a file exists, it parses it, puts it on the PFM queue 
 * and sends a copy to message broker via SOAP
 */


package patientflowmonitoring


import win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice_tws.WFMCoordinationEventServicePortType;
import win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.*;
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
	WFMCoordinationEventServicePortType oslerServiceClient
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
									def patientId=connector."connector-bundle".ConsultationStartedObject.Patient_ID.text()
									def locationId=connector."connector-bundle".ConsultationStartedObject.Location_ID.text()
									def physicianId=connector."connector-bundle".ConsultationStartedObject.Physician_ID.text()
									def timestamp=connector."connector-bundle".ConsultationStartedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Provider_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationStarted1Response response=oslerServiceClient.consultationStarted1("$patientId", "$physicianId", "$locationId", "$timestamp")
									}
								else if ("${event.toString()}".compareTo("ConsultationStarted2")==0)
								{
									def patientId=connector."connector-bundle".ConsultationStartedObject.Patient_ID.text()
									def locationId=connector."connector-bundle".ConsultationStartedObject.Location_ID.text()
									def physicianId=connector."connector-bundle".ConsultationStartedObject.Physician_ID.text()
									def timestamp=connector."connector-bundle".ConsultationStartedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Provider_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationStarted2Response response = oslerServiceClient.consultationStarted2("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ConsultationCompleted1")==0)
								{
									def patientId=connector."connector-bundle".ConsultationCompletedObject.Patient_ID.text()
									def locationId=connector."connector-bundle".ConsultationCompletedObject.Location_ID.text()
									def physicianId=connector."connector-bundle".ConsultationCompletedObject.Physician_ID.text()
									def timestamp=connector."connector-bundle".ConsultationCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Provider_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationCompleted1Response response = oslerServiceClient.consultationCompleted1("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("ConsultationCompleted2")==0)
								{
									def patientId=connector."connector-bundle".ConsultationCompletedObject.Patient_ID.text()
									def locationId=connector."connector-bundle".ConsultationCompletedObject.Location_ID.text()
									def physicianId=connector."connector-bundle".ConsultationCompletedObject.Physician_ID.text()
									def timestamp=connector."connector-bundle".ConsultationCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Provider_ID:$physicianId,Location_ID:$locationId,timestamp:$timestp"
									ConsultationCompleted2Response response = oslerServiceClient.consultationCompleted2("$patientId","$physicianId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForConsultation1")==0)
								{
									def patientId=connector."connector-bundle".WaitForConsultationObject.Patient_ID.text()
									def locationId=connector."connector-bundle".WaitForConsultationObject.Location_ID.text()
									def timestamp=connector."connector-bundle".WaitForConsultationObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestp"
									WaitForConsultation1Response response = oslerServiceClient.waitForConsultation1("$patientId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForConsultation2")==0)
								{
									def patientId=connector."connector-bundle".WaitForConsultationObject.Patient_ID.text()
									def locationId=connector."connector-bundle".WaitForConsultationObject.Location_ID.text()
									def timestamp=connector."connector-bundle".WaitForConsultationObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestp"
									WaitForConsultation2Response response = oslerServiceClient.waitForConsultation2("$patientId","$locationId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForBed")==0)
								{
									def patientId=connector."connector-bundle".WaitForBedObject.Patient_ID.text()
									def unitId=connector."connector-bundle".WaitForBedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForBedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForBedResponse response = oslerServiceClient.waitForBed("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForTransport")==0)
								{
									def patientId=connector."connector-bundle".WaitForTransportObject.Patient_ID.text()
									def unitId=connector."connector-bundle".WaitForTransportObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".WaitForTransportObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									WaitForTransportResponse response = oslerServiceClient.waitForTransport("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("WaitForOrderExecution")==0)
								{
									def patientId=connector."connector-bundle".WaitForOrderExecutionObject.Patient_ID.text()
									def timestamp=connector."connector-bundle".WaitForOrderExecutionObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,timestamp:$timestp"
									WaitForOrderExecutionResponse response = oslerServiceClient.waitForOrderExecution("$patientId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("PatientTransportStarted")==0)
								{
									def patientId=connector."connector-bundle".PatientTransportStartedObject.Patient_ID.text()
									def unitId=connector."connector-bundle".PatientTransportStartedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".PatientTransportStartedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$timestp"
									PatientTransportStartedResponse response = oslerServiceClient.patientTransportStarted("$patientId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("PatientArrivedInBed")==0)
								{
									def patientId=connector."connector-bundle".PatientArrivedInBedObject.Patient_ID.text()
									def bedId=connector."connector-bundle".PatientArrivedInBedObject.Bed_ID.text()
									def unitId=connector."connector-bundle".PatientArrivedInBedObject.Unit_ID.text()
									def timestamp=connector."connector-bundle".PatientArrivedInBedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,Bed_ID:$bedId,Unit_ID:$unitId,timestamp:$timestp"
									PatientArriveInBedResponse response = oslerServiceClient.patientArriveInBed("$patientId","$bedId","$unitId","$timestamp")
								}
								else if ("${event.toString()}".compareTo("OrderExecutionCompleted")==0)
								{
									def patientId=connector."connector-bundle".OrderExecutionCompletedObject.Patient_ID.text()
									def timestamp=connector."connector-bundle".OrderExecutionCompletedObject.timestamp.text()
									def timestp = modifyTimeStamp(timestamp)
									msg= "event:$event,Patient_ID:$patientId,timestamp:$timestp"
									OrderExecutionCompletedResponse response = oslerServiceClient.orderExecutionCompleted("$patientId","$timestamp")
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

