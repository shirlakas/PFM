package patientflowmonitoring

import javax.jws.*
import java.util.Map
import java.util.Date
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes;
import com.pfm.handler.EventHandler;
import org.springframework.context.*
import grails.plugin.jms.*
import java.text.SimpleDateFormat
import groovy.xml.MarkupBuilder

class PFMServerService {

    static transactional = true
	static expose=['cxfjax']
		
	def patientService
	def bedService
	def monitorService
	def unitService
	def grailsApplication
	def jmsService
	
    def serviceMethod() {
    }
	
	@WebResult(name="pingResponse")
	@WebMethod(operationName="ping")
	String ping(@WebParam(name="message")String message){
		//return the received message
		return message;
	}
	/*************** Start of PFM events *************************/

	@WebResult(name="triageScoreResponse")
	@WebMethod(operationName="triageScore")
	String triageScore(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="ctas")String ctas,
		@WebParam(name="timestamp")String timestamp){
		/********Processing request using the variables provided:*******
		*******   patientId, providerId, ctas, timestamp****************/
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss 
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString
		String msg= "event:TriageScore,Patient_ID:$patientId,Provider_ID:$providerId,CTAS:$ctas,timestamp:$ts"
		
		//Sending the event to the message queue
		jmsService.send(queue:'PFM_Event',msg)	
		return "Message received"		
	}
		
	@WebResult(name="PatientRegisteredResponse")
	@WebMethod(operationName="patientRegistered")
	String patientRegistered(@WebParam(name="patientId")String patientId,
		@WebParam(name="roomId")String roomId,
		@WebParam(name="timestamp")String timestamp){
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
			
		//Receiving values sent in event as a GString and sending to message queue
		String msg= "event:PatientRegistered,Patient_ID:$patientId,Room_ID:$roomId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		/******************  Input to CEP ******************/
		//Writing PatientRegistered.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,roomId,timestamp]
		PatientRegistered(eventAttributes)
		/****************** End of CEP input ***************/
		return "Message received"
	}	
	
	@WebResult(name="ConsultationStarted1Response")
	@WebMethod(operationName="consultationStarted1")
	String ConsultationStarted1(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationStarted1,Patient_ID:$patientId,Provider_ID:$providerId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="WaitForConsultation1Response")
	@WebMethod(operationName="waitForConsultation1")
	String waitForConsultation1(@WebParam(name="patientId")String patientId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForConsultation1,Patient_ID:$patientId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
	
	@WebResult(name="ConsultationCompleted1Response")
	@WebMethod(operationName="consultationCompleted1")
	String consultationCompleted1(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationCompleted1,Patient_ID:$patientId,Provider_ID:$providerId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
	
	@WebResult(name="ConsultationStarted2Response")
	@WebMethod(operationName="consultationStarted2")
	String ConsultationStarted2(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationStarted2,Patient_ID:$patientId,Provider_ID:$providerId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	} 
	
	@WebResult(name="WaitForConsultation2Response")
	@WebMethod(operationName="waitForConsultation2")
	String waitForConsultation2(@WebParam(name="patientId")String patientId,
		@WebParam(name="timestamp")String timestamp){
				
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForConsultation2,Patient_ID:$patientId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="ConsultationCompleted2Response")
	@WebMethod(operationName="consultationCompleted2")
	String ConsultationCompleted2(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="timestamp")String timestamp){

		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationCompleted2,Patient_ID:$patientId,Provider_ID:$providerId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}		
		
	@WebResult(name="OrderRequestResponse")
	@WebMethod(operationName="orderRequest")
	String orderRequest(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="orderType")String orderType,
		@WebParam(name="orderId")String orderId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:OrderRequest,Patient_ID:$patientId,Provider_ID:$providerId,OrderType:$orderType,Order_ID:$orderId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)	
		
		/*****************  CEP Input begins ************************/
		//Writing OrderRequest.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,orderType,orderId,timestamp]
		OrderRequest(eventAttributes)
		/**************** End of CEP Inputs *************************/
		
		return "Message received"
	}
	
	@WebResult(name="OrderRequestCompletedResponse")
	@WebMethod(operationName="orderRequestCompleted")
	String orderRequestCompleted(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="orderType")String orderType,
		@WebParam(name="orderId")String orderId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:OrderRequestCompleted,Patient_ID:$patientId,Provider_ID:$providerId,OrderType:$orderType,Order_ID:$orderId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/*****************  CEP Input begins ************************/
		//Writing OrderRequestCompleted.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,orderType,orderId,timestamp]
		OrderRequestCompleted(eventAttributes)
		/**************** End of CEP Inputs *************************/
		
		return "Message received"
	}
		
	@WebResult(name="WaitForOrderExecutionResponse")
	@WebMethod(operationName="waitForOrderExecution")
	String waitForOrderExecution(@WebParam(name="patientId")String patientId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForOrderExecution,Patient_ID:$patientId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="OrderExecutionCompletedResponse")
	@WebMethod(operationName="orderExecutionCompleted")
	String orderExecutionCompleted(@WebParam(name="patientId")String patientId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:OrderExecutionCompleted,Patient_ID:$patientId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="BedRequestResponse")
	@WebMethod(operationName="bedRequest")
	String bedRequest(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:BedRequest,Patient_ID:$patientId,Provider_ID:$providerId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/**************** CEP Input begins *************************/
		//Writing BedRequest.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,unitId,timestamp]
		BedRequest(eventAttributes)
		/**************** End of CEP Inputs *************************/
		
		return "Message received"
	}
		
	@WebResult(name="PatientAdmittedWithNoBedResponse")
	@WebMethod(operationName="patientAdmittedWithNoBed")
	String patientAdmittedWithNoBed(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientAdmittedWithNoBed,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/**************** CEP Input Begins ***********************/
		//Writing PatientAdmittedWithNoBed.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,unitId,timestamp]
		PatientAdmittedWithNoBed(eventAttributes)
		/*************** End of CEP Input ************************/
		
		return "Message received"
	}
		
	@WebResult(name="WaitForBedResponse")
	@WebMethod(operationName="waitForBed")
	String waitForBed(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForBed,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="PatientAdmittedWithBedResponse")
	@WebMethod(operationName="patientAdmittedWithBed")
	String patientAdmittedWithBed(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="bedId")String bedId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientAdmittedWithBed,Patient_ID:$patientId,Unit_ID:$unitId,Bed_ID:$bedId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/**************** CEP Input Begins*************************/
		//Writing PatientAdmittedWithBed.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,unitId,bedId,timestamp]
		PatientAdmittedWithBed(eventAttributes)
		/***************** End of CEP Input **********************/
		
		return "Message received"
	}
		
	@WebResult(name="PatientTransportRequestResponse")
	@WebMethod(operationName="patientTransportRequest")
	String patientTransportRequest(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientTransportRequest,Patient_ID:$patientId,Provider_ID:$providerId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/****************** CEP Input begins*********************/
		//Writing PatientTransportRequest.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,unitId,timestamp]
		PatientTransportRequest(eventAttributes)
		/***************** End of CEP Input ********************/
		
		return "Message received"
		
	}
		
	@WebResult(name="WaitForTransportResponse")
	@WebMethod(operationName="waitForTransport")
	String waitForTransport(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForTransport,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="PatientTransportStartedResponse")
	@WebMethod(operationName="patientTransportStarted")
	String patientTransportStarted(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientTransportStarted,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="PatientArrivedInBedResponse")
	@WebMethod(operationName="patientArrivedInBed")
	String patientArrivedInBed(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="bedId")String bedId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientArrivedInBed,Patient_ID:$patientId,Unit_ID:$unitId,Bed_ID:$bedId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}		
		
	@WebResult(name="DischargeResponse")
	@WebMethod(operationName="discharge")
	String discharge(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:Discharge,Patient_ID:$patientId,Provider_ID:$providerId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	/*************************** End of PFM events **********************/
		
	/**************************** CEP Events	*************************/
	@Queue(name='CEP_Event')
	@WebResult(name="PatientInEDResponse")
	@WebMethod(operationName="patientInED")
	String patientInED(@WebParam(name="patientId")String patientId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
			
		// Sending the event to the CEP queue
		String msg= "event:PatientInED,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		// CEP calling method to process function
		def eventAttributes=[]
		eventAttributes=[patientId,locationId,timestamp]
		PatientInED(eventAttributes)
		
		return "Message received"
	}
		
	@WebResult(name="PatientOutEDResponse")
	@WebMethod(operationName="patientOutED")
	String patientOutED(@WebParam(name="patientId")String patientId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PatientOutED,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[patientId,locationId,timestamp]
		PatientOutED(eventAttributes)
		
		return "Message received"
	}
			
	@WebResult(name="PatientInCCUResponse")
	@WebMethod(operationName="patientInCCU")
	String patientInCCU(@WebParam(name="patientId")String patientId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PatientInCCU,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[patientId,locationId,timestamp]
		PatientInCCU(eventAttributes)
		
		return "Message received"
	}	
		
	@WebResult(name="PhysicianInEDResponse")
	@WebMethod(operationName="physicianInED")
	String physicianInED(@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PhysicianInED,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[physicianId,locationId,timestamp]
		PhysicianInED(eventAttributes)
		
		return "Message received"
	}
	
	@WebResult(name="PhysicianOutEDResponse")
	@WebMethod(operationName="physicianOutED")
	String physicianOutED(@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
				
		// Sending the event to the CEP queue
		String msg= "event:PhysicianOutED,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[physicianId,locationId,timestamp]
		PhysicianOutED(eventAttributes)
		
		return "Message received"
	}	
		
	/******************** End of CEP Events ***************************/
	
	def String modifyTimeStamp(String ts){
		Date dte= Date.parse ("yyyy-MM-dd'T'HH:mm:ss", ts)
		String out = dte.format("yyyy-MM-dd/HH-mm-ss")
		return out
	}
		
	
	
	/************************ CEP Methods ******************************/
	/*Input to CEP Event Methods*/
	
	
	/* 1- PatientInEd Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientInED(List attributes){
	
	def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientInED.xml"
	def file= new File(fileName)
	def writer=new FileWriter(file)
	def xml= new MarkupBuilder(writer)
	xml.setDoubleQuotes(true)
	def time= creatTimeStamp(attributes[2])
	
	xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientInED',"version":"6.2",name:"RTLS"){
	"connector-bundle"(name:"PatientInED",type:"Event") {
		PatientInEDObject{
			
			Patient_ID (type:"String",attributes[0])
			Location_ID (type:"String",attributes[1])
			timestamp(type:"DateTime",time)
		}
	}
	system("WIN-U8BMQ67RW9Y")
	timestamp(time)
	loginfo("Test values from WebSphere Business Events:Design Data")
	}
	
	
	return "The file ${fileName} is created"
	}
/* -----------------------------------------------------------------------------*/
	
	
	/* 2- PatientOutED Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientOutED(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientOutED.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientOutED',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PatientOutED",type:"Event") {
			PatientOutEDObject{
				
				Patient_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 3- PatientInCCU Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientInCCU(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientInCCU.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientInCCU',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PatientInCCU",type:"Event") {
			PatientInCCUObject{
				
				Patient_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 4- PhysicianInED Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PhysicianInED(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PhysicianInED.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PhysicianInED',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PhysicianInED",type:"Event") {
			PhysicianInEDObject{
				
				Physician_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	/* 5- PhysicianOutED Method*/
	
	def PhysicianOutED(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PhysicianOutED.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PhysicianOutED',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PhysicianOutED",type:"Event") {
			PhysicianOutEDobject{
				
				Physician_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 6- PatientRegistered Method*/
	def PatientRegistered(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientRegistered.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientRegistered',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"PatientRegistered",type:"Event") {
			PatientRegisteredObject{
				
				Patient_ID (type:"String",attributes[0])
				Room_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	/* 7-  OrderRequest Method*/
	
	def OrderRequest(List attributes){
		
		def fileName= "C:\\OslerProject\\TestCase1\\InputEvents\\OrderRequest.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[4])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/OrderRequest',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"OrderRequest",type:"Event") {
			OrderRequestObject{
				
				Patient_ID (type:"String",attributes[0])
				Provider_ID (type:"String",attributes[1])
				Order_ID(type:"String",attributes[2])
				Order_Type(type:"String",attributes[3])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	/* 8- BedRequest Method*/
	
	def BedRequest(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\BedRequest.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[3])
		
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/BedRequest',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"BedRequest",type:"Event") {
			BedRequestobject{
				
				Patient_ID (type:"String",attributes[0])
				Provider_ID (type:"String",attributes[1])
				Unit_ID(type:"String",attributes[2])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	
	/* -----------------------------------------------------------------------------*/
	
	/* 9- OrderRequestCompleted Method*/
	
	def OrderRequestCompleted(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\OrderRequestCompleted.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[4])
		
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/OrderRequestCompleted',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"OrderRequestCompleted",type:"Event") {
			OrderRequestCompletedObject{
				
				Patient_ID (type:"String",attributes[0])
				Provider_ID (type:"String",attributes[1])
				Order_ID(type:"String",attributes[2])
				Order_Type(type:"String",attributes[3])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/

	/* 10- PatientAdmittedWithBed Method*/
	
	def PatientAdmittedWithBed(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientAdmittedWithBed.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[3])
		
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientAdmittedWithBed',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"PatientAdmittedWithBed",type:"Event") {
			PatientAdmittedWithBedObject{
				
				Patient_ID (type:"String",attributes[0])
				Unit_ID(type:"String",attributes[1])
				Bed_ID(type:"String",attributes[2])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	
	/* -----------------------------------------------------------------------------*/
	/* 11- PatientAdmittedWithBed Method*/
	
	def PatientAdmittedWithNoBed(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientAdmittedWithNoBed.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientAdmittedWithNoBed',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"PatientAdmittedWithNoBed",type:"Event") {
			PatientAdmittedWithNoBedObject{
				
				Patient_ID (type:"String",attributes[0])
				Unit_ID(type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
		}
	
	/* -----------------------------------------------------------------------------*/
	
	/* 12- PatientTransportRequest Method*/
	
	def PatientTransportRequest(List attributes){
		
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientTransportRequest.xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[3])
		
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientTransportRequest',"version":"6.2",name:"WFM"){
			"connector-bundle"(name:"PatientTransportRequest",type:"Event") {
				PatientTransportRequestObject{
					Patient_ID (type:"String",attributes[0])
					Provider_ID (type:"String",attributes[1])
					Unit_ID(type:"String",attributes[2])
					timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
		}
		return "The file ${fileName} is created"
	}
	
	
	
	/* -----------------------------------------------------------------------------*/
	
	def creatTimeStamp(String t){
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
		Date d=sdf.parse(t)
		def time=sdf.format(d)
		return time
	}
		  
   /****************************  End of CEP Methods ********************************/
}

    