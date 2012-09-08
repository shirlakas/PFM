package pfm
import javax.jws.*
import java.util.List;
import java.util.Map
import java.util.Date
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes;
import com.pfm.handler.EventHandler;
import org.springframework.context.*
import grails.plugin.jms.*
import java.text.SimpleDateFormat
import groovy.xml.MarkupBuilder

class PFMReceiveService {

   static transactional = true
	static expose=['cxfjax']
		
	def patientService
	def roomService
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
		
		/******************  Input to CEP ******************/
		//Writing PatientRegistered.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,ctas,timestamp]
		TriageScore(eventAttributes)
		/****************** End of CEP input ***************/
		return "Message received"
	}
		
		
		@WebResult(name="WaitForConsultation1Response")
		@WebMethod(operationName="waitForConsultation1")
		String waitForConsultation1(@WebParam(name="patientId")String patientId,
			@WebParam(name="locationId")String locationId,
			@WebParam(name="timestamp")String timestamp){
			
			//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
			String ts=modifyTimeStamp(timestamp)
			
			//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
			String msg= "event:WaitForConsultation1,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$ts"
			jmsService.send(queue:'PFM_Event',msg)
			
			return "Message received"
		}		
	
	@WebResult(name="ConsultationStarted1Response")
	@WebMethod(operationName="consultationStarted1")
	String consultationStarted1(@WebParam(name="patientId")String patientId,
		@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationStarted1,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
	
	@WebResult(name="ConsultationCompleted1Response")
	@WebMethod(operationName="consultationCompleted1")
	String consultationCompleted1(@WebParam(name="patientId")String patientId,
		@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationCompleted1,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$ts"
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
			eventAttributes=[patientId,providerId,orderId,orderType,timestamp]
			OrderRequest(eventAttributes)
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
				eventAttributes=[patientId,providerId,orderId,orderType,timestamp]
				OrderRequestCompleted(eventAttributes)
				/**************** End of CEP Inputs *************************/
				
				return "Message received"
			}
			
		@WebResult(name="OrdersExecutionCompletedResponse")
		@WebMethod(operationName="ordersExecutionCompleted")
		String ordersExecutionCompleted(@WebParam(name="patientId")String patientId,
			@WebParam(name="timestamp")String timestamp){
			
			//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
			String ts=modifyTimeStamp(timestamp)
			
			//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
			String msg= "event:OrdersExecutionCompleted,Patient_ID:$patientId,timestamp:$ts"
			jmsService.send(queue:'PFM_Event',msg)
			
			return "Message received"
		}
			
		@WebResult(name="WaitForConsultation2Response")
		@WebMethod(operationName="waitForConsultation2")
		String waitForConsultation2(@WebParam(name="patientId")String patientId,
			@WebParam(name="locationId")String locationId,
			@WebParam(name="timestamp")String timestamp){
						
			//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
			String ts=modifyTimeStamp(timestamp)
				
			//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
			String msg= "event:WaitForConsultation2,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$ts"
			jmsService.send(queue:'PFM_Event',msg)
				
			return "Message received"
		}
	
	@WebResult(name="ConsultationStarted2Response")
	@WebMethod(operationName="consultationStarted2")
	String consultationStarted2(@WebParam(name="patientId")String patientId,
		@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationStarted2,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	} 
	
		
	@WebResult(name="ConsultationCompleted2Response")
	@WebMethod(operationName="consultationCompleted2")
	String consultationCompleted2(@WebParam(name="patientId")String patientId,
		@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){

		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
				
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationCompleted2,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="RequestReferralResponse")
	@WebMethod(operationName="requestReferral")
	String requestReferral(@WebParam(name="patientId")String patientId,
			@WebParam(name="providerId")String providerId,
			@WebParam(name="referralType")String referralType,
			@WebParam(name="unitId")String unitId,
			@WebParam(name="timestamp")String timestamp){
			
			//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
			String ts=modifyTimeStamp(timestamp)
			
			//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
			String msg= "event:RequestReferral,Patient_ID:$patientId,Provider_ID:$providerId,ReferralType:$referralType,Unit_ID:$unitId,timestamp:$ts"
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
		
	@WebResult(name="ProceduresScheduledResponse")
	@WebMethod(operationName="proceduresScheduled")
	String proceduresScheduled(@WebParam(name="patientId")String patientId,
		@WebParam(name="procedureScheduledTime")String procedureScheduledTime,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ProceduresScheduled,Patient_ID:$patientId,ProcedureScheduledTime:$procedureScheduledTime,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/****************** CEP Input begins*********************/
		//Writing ProcedureScheduled.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,procedureScheduledTime,unitId,timestamp]
		ProceduresScheduled(eventAttributes)
		/***************** End of CEP Input ********************/
		
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
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientAdmittedWithBed,Patient_ID:$patientId,Unit_ID:$unitId,Location_ID:$locationId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		/**************** CEP Input Begins*************************/
		//Writing PatientAdmittedWithBed.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,unitId,locationId,timestamp]
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
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:PatientArrivedInBed,Patient_ID:$patientId,Unit_ID:$unitId,Location_ID:$locationId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}	
		
	/******** Extended Scenario Events Start Here **************************/
	@WebResult(name="WaitForProceduresResponse")
	@WebMethod(operationName="waitForProcedures")
	String waitForProcedures(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
			
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
			
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForProcedures,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
			
		return "Message received"
	}
			
		
	@WebResult(name="ProcedureStartedResponse")
	@WebMethod(operationName="procedureStarted")
	String procedureStarted(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="procedureType")String procedureType,
		@WebParam(name="timestamp")String timestamp){
			
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
					
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ProcedureStarted,Patient_ID:$patientId,Provider_ID:$providerId,Procedure_Type:$procedureType,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		/****************** CEP Input begins*********************/
		//Writing ProcedureStarted.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,procedureType,timestamp]
		ProcedureStarted(eventAttributes)
		/***************** End of CEP Input ********************/
			
			return "Message received"
		}
		
		@WebResult(name="ProcedureCompletedResponse")
		@WebMethod(operationName="procedureCompleted")
		String procedureCompleted(@WebParam(name="patientId")String patientId,
			@WebParam(name="providerId")String providerId,
			@WebParam(name="procedureType")String procedureType,
			@WebParam(name="timestamp")String timestamp){
			
			//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
			String ts=modifyTimeStamp(timestamp)
					
			//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
			String msg= "event:ProcedureCompleted,Patient_ID:$patientId,Provider_ID:$providerId,Procedure_Type:$procedureType,timestamp:$ts"
			jmsService.send(queue:'PFM_Event',msg)
			
			/****************** CEP Input begins*********************/
			//Writing ProcedureStarted.xml to InputCEP directory
			def eventAttributes=[]
			eventAttributes=[patientId,providerId,procedureType,timestamp]
			ProcedureCompleted(eventAttributes)
			/***************** End of CEP Input ********************/
			
			return "Message received"
		}
		
		@WebResult(name="ProcedureUpdatedResponse")
		@WebMethod(operationName="procedureUpdated")
		String procedureUpdated(@WebParam(name="patientId")String patientId,
			@WebParam(name="procedureType")String procedureType,
			@WebParam(name="status")String status,
			@WebParam(name="timestamp")String timestamp){
			
			//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
			String ts=modifyTimeStamp(timestamp)
					
			//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
			String msg= "event:ProcedureUpdated,Patient_ID:$patientId,Procedure_Type:$procedureType,Status:$status,timestamp:$ts"
			jmsService.send(queue:'PFM_Event',msg)
			
			return "Message received"
		}
			
			@WebResult(name="ProceduresExecutionCompletedResponse")
			@WebMethod(operationName="proceduresExecutionCompleted")
			String proceduresExecutionCompleted(@WebParam(name="patientId")String patientId,
				@WebParam(name="timestamp")String timestamp){
				
				//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
				String ts=modifyTimeStamp(timestamp)
				
				//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
				String msg= "event:ProceduresExecutionCompleted,Patient_ID:$patientId,timestamp:$ts"
				jmsService.send(queue:'PFM_Event',msg)
				
				return "Message received"
			}
				
			
	@WebResult(name="ConsultationStarted3Response")
	@WebMethod(operationName="consultationStarted3")
	String consultationStarted3(@WebParam(name="patientId")String patientId,
		@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
				
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
						
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationStarted3,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
				
			return "Message received"
		}
			
	@WebResult(name="ConsultationCompleted3Response")
	@WebMethod(operationName="consultationCompleted3")
	String consultationCompleted3(@WebParam(name="patientId")String patientId,
		@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
				
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
						
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:ConsultationCompleted3,Patient_ID:$patientId,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
				
			return "Message received"
		}	
		
	@WebResult(name="DischargeRequestResponse")
	@WebMethod(operationName="dischargeRequest")
	String dischargeRequest(@WebParam(name="patientId")String patientId,
		@WebParam(name="providerId")String providerId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:DischargeRequest,Patient_ID:$patientId,Provider_ID:$providerId,Unit_ID:$unitId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		/****************** CEP Input begins*********************/
		//Writing DischargeRequest.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[patientId,providerId,unitId,timestamp]
		DischargeRequest(eventAttributes)
		/***************** End of CEP Input ********************/
		
		return "Message received"
	}
		
	@WebResult(name="WaitForDischargeResponse")
	@WebMethod(operationName="waitForDischarge")
	String waitForDischarge(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForDischarge,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="DischargeCompletedResponse")
	@WebMethod(operationName="dischargeCompleted")
	String dischargeCompleted(@WebParam(name="patientId")String patientId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
		
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)			
		
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:DischargeCompleted,Patient_ID:$patientId,Unit_ID:$unitId,timestamp:$ts"	
		jmsService.send(queue:'PFM_Event',msg)
		
		return "Message received"
	}
		
	@WebResult(name="BedCleanUpRequestResponse")
	@WebMethod(operationName="bedCleanUpRequest")
	String bedCleanUpRequest(@WebParam(name="locationId")String locationId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
			
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
			
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:BedCleanUpRequest,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
			
		/****************** CEP Input begins*********************/
		//Writing BedCleanUpRequest.xml to InputCEP directory
		def eventAttributes=[]
		eventAttributes=[locationId,unitId,timestamp]
		BedCleanUpRequest(eventAttributes)
		/***************** End of CEP Input ********************/
			
		return "Message received"
	}
	
	@WebResult(name="WaitForBedCleanUpResponse")
	@WebMethod(operationName="waitForBedCleanUp")
	String waitForBedCleanUp(@WebParam(name="locationId")String locationId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
			
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
			
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:WaitForBedCleanUp,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
			
		return "Message received"
	}
		
	
	@WebResult(name="BedCleanUpStartedResponse")
	@WebMethod(operationName="bedCleanUpStarted")
	String bedCleanUpStarted(@WebParam(name="houseKeepingId")String houseKeepingId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
				
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
						
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:BedCleanUpStarted,HouseKeeping_ID:$houseKeepingId,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$ts"
		jmsService.send(queue:'PFM_Event',msg)
				
			return "Message received"
		}
			
	@WebResult(name="BedCleanUpCompletedResponse")
	@WebMethod(operationName="bedCleanUpCompleted")
	String bedCleanUpCompleted(@WebParam(name="houseKeepingId")String houseKeepingId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="unitId")String unitId,
		@WebParam(name="timestamp")String timestamp){
				
		//Converting timestamp from String with format yyyy-MM-ddTHH:mm:ss to another String with format yyyy-MM-dd/HH-mm-ss
		String ts=modifyTimeStamp(timestamp)
						
		//Receiving values sent in event as a GString and sending the event to the PFM_Event queue
		String msg= "event:BedCleanUpCompleted,HouseKeeping_ID:$houseKeepingId,Location_ID:$locationId,Unit_ID:$unitId,timestamp:$ts"
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
	
	@WebResult(name="PatientInCWResponse")
	@WebMethod(operationName="patientInCW")
	String patientInCW(@WebParam(name="patientId")String patientId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PatientInCW,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[patientId,locationId,timestamp]
		PatientInCW(eventAttributes)
		
		return "Message received"
	}
		
		
	@WebResult(name="PatientInCCLResponse")
	@WebMethod(operationName="patientInCCL")
	String patientInCCL(@WebParam(name="patientId")String patientId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PatientInCCL,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[patientId,locationId,timestamp]
		PatientInCCL(eventAttributes)
		
		return "Message received"
	}	
		
		
	@WebResult(name="PatientOutCWResponse")
	@WebMethod(operationName="patientOutCW")
	String patientOutCW(@WebParam(name="patientId")String patientId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PatientOutCW,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[patientId,locationId,timestamp]
		PatientOutCW(eventAttributes)
		
		return "Message received"
	}	
		
		@WebResult(name="PatientOutCCLResponse")
		@WebMethod(operationName="patientOutCCL")
		String patientOutCCL(@WebParam(name="patientId")String patientId,
			@WebParam(name="locationId")String locationId,
			@WebParam(name="timestamp")String timestamp){
			
			// Sending the event to the CEP queue
			String msg= "event:PatientOutCCL,Patient_ID:$patientId,Location_ID:$locationId,timestamp:$timestamp"
			jmsService.send(queue:'CEP_Event',msg)
			
			def eventAttributes=[]
			eventAttributes=[patientId,locationId,timestamp]
			PatientOutCCL(eventAttributes)
			
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
		
	@WebResult(name="PhysicianInCWResponse")
	@WebMethod(operationName="physicianInCW")
	String physicianInCW(@WebParam(name="physicianId")String physicianId,
		@WebParam(name="locationId")String locationId,
		@WebParam(name="timestamp")String timestamp){
		
		// Sending the event to the CEP queue
		String msg= "event:PhysicianInCW,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestamp"
		jmsService.send(queue:'CEP_Event',msg)
		
		def eventAttributes=[]
		eventAttributes=[physicianId,locationId,timestamp]
		PhysicianInCW(eventAttributes)
		
		return "Message received"
	}
	
		
		@WebResult(name="PhysicianOutCWResponse")
		@WebMethod(operationName="physicianOutCW")
		String physicianOutCW(@WebParam(name="physicianId")String physicianId,
			@WebParam(name="locationId")String locationId,
			@WebParam(name="timestamp")String timestamp){
			
			// Sending the event to the CEP queue
			String msg= "event:PhysicianOutCW,Physician_ID:$physicianId,Location_ID:$locationId,timestamp:$timestamp"
			jmsService.send(queue:'CEP_Event',msg)
			
			def eventAttributes=[]
			eventAttributes=[physicianId,locationId,timestamp]
			PhysicianOutCW(eventAttributes)
			
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
		
		
		@WebResult(name="HouseKeepingnInCWResponse")
		@WebMethod(operationName="houseKeepingInCW")
		String houseKeepingInCW(@WebParam(name="houseKeepingId")String houseKeepingId,
			@WebParam(name="locationId")String locationId,
			@WebParam(name="timestamp")String timestamp){
			
			// Sending the event to the CEP queue
			String msg= "event:HouseKeepingInCW,HouseKeeping_ID:$houseKeepingId,Location_ID:$locationId,timestamp:$timestamp"
			jmsService.send(queue:'CEP_Event',msg)
			
			def eventAttributes=[]
			eventAttributes=[houseKeepingId,locationId,timestamp]
			HouseKeepingInCW(eventAttributes)
	
			return "Message received"
		}
		
			
			@WebResult(name="HouseKeepingOutCWResponse")
			@WebMethod(operationName="houseKeepingOutCW")
			String houseKeepingOutCW(@WebParam(name="houseKeepingId")String houseKeepingId,
				@WebParam(name="locationId")String locationId,
				@WebParam(name="timestamp")String timestamp){
				
				// Sending the event to the CEP queue
				String msg= "event:HouseKeepingOutCW,HouseKeeping_ID:$houseKeepingId,Location_ID:$locationId,timestamp:$timestamp"
				jmsService.send(queue:'CEP_Event',msg)
				
				def eventAttributes=[]
				eventAttributes=[houseKeepingId,locationId,timestamp]
				HouseKeepingOutCW(eventAttributes)
				
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
	def today= appendTimeStamp()
	def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientInED"+"$today"+".xml"
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
	writer.close()	
	return "The file ${fileName} is created"
	}
/* -----------------------------------------------------------------------------*/
	
	
	/* 2- PatientOutED Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientOutED(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientOutED"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 3- PatientInCW Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientInCW(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientInCW"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientInCW',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PatientInCW",type:"Event") {
			PatientInCWObject{
				
				Patient_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	
	/* 2- PatientOutCW Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientOutCW(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientOutCW"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientOutCW',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PatientOutCW",type:"Event") {
			PatientOutCWObject{
				
				Patient_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 2- PatientOutCCL Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientOutCCL(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientOutCCL"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientOutCCL',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PatientOutCCL",type:"Event") {
			PatientOutCCLObject{
				
				Patient_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	
	/* 3- PatientInCCL Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PatientInCCL(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientInCCL"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PatientInCCL',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PatientInCCL",type:"Event") {
			PatientInCCLObject{
				
				Patient_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	/* 4- PhysicianInED Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PhysicianInED(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PhysicianInED"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	/* 4- PhysicianInCW Method*/
	/* -----------------------------------------------------------------------------*/
	
	def PhysicianInCW(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PhysicianInCW"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PhysicianInCW',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PhysicianInCW",type:"Event") {
			PhysicianInCWObject{
				
				Physician_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	/* 5- PhysicianOutED Method*/
	
	def PhysicianOutED(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PhysicianOutED"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* -----------------------------------------------------------------------------*/
	/* 5- PhysicianOutCW Method*/
	
	def PhysicianOutCW(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PhysicianOutCW"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/PhysicianOutCW',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"PhysicianOutCW",type:"Event") {
			PhysicianOutCWobject{
				
				Physician_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 3- HouseKeepingInCW Method*/
	/* -----------------------------------------------------------------------------*/
	
	def HouseKeepingInCW(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\HouseKeepingInCW"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/HouseKeepingInCW',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"HouseKeepingInCW",type:"Event") {
			HouseKeepingInCWObject{
				
				HouseKeeping_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	
	/* 2- HouseKeepingOutCW Method*/
	/* -----------------------------------------------------------------------------*/
	
	def HouseKeepingOutCW(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\HouseKeepingOutCW"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[2])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/HouseKeepingOutCW',"version":"6.2",name:"RTLS"){
		"connector-bundle"(name:"HouseKeepingOutCW",type:"Event") {
			HouseKeepingOutCWObject{
				
				HouseKeeping_ID (type:"String",attributes[0])
				Location_ID (type:"String",attributes[1])
				timestamp(type:"DateTime",time)
			}
		}
		system("WIN-U8BMQ67RW9Y")
		timestamp(time)
		loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	/* 6- PatientRegistered Method*/
	def PatientRegistered(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientRegistered"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	/* 7-  OrderRequest Method*/
	
	def OrderRequest(List attributes){
		def today= appendTimeStamp()
		def fileName= "C:\\OslerProject\\TestCase1\\InputEvents\\OrderRequest"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
		}
	/* -----------------------------------------------------------------------------*/
	
	
	/* 8- BedRequest Method*/
	
	def BedRequest(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\BedRequest"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
		}
	
	/* -----------------------------------------------------------------------------*/
	
	/* 9- OrderRequestCompleted Method*/
	
	def OrderRequestCompleted(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\OrderRequestCompleted"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
	}
	/* -----------------------------------------------------------------------------*/

	/* 10- PatientAdmittedWithBed Method*/
	
	def PatientAdmittedWithBed(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientAdmittedWithBed"+"$today"+".xml"
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
				Location_ID(type:"String",attributes[2])
				timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
	}
	
	/* -----------------------------------------------------------------------------*/
	/* 11- PatientAdmittedWithBed Method*/
	
	def PatientAdmittedWithNoBed(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientAdmittedWithNoBed"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
	}
	
	/* -----------------------------------------------------------------------------*/
	
	/* 12- PatientTransportRequest Method*/
	
	def PatientTransportRequest(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\PatientTransportRequest"+"$today"+".xml"
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
		writer.close()
		return "The file ${fileName} is created"
	}
	
	/* 13- TriageScore Method*/
	/* -----------------------------------------------------------------------------*/
	
	def TriageScore(List attributes){
		def today= appendTimeStamp()
		def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\TriageScore"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[3])
	
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/TriageScore',"version":"6.2",name:"RTLS"){
			"connector-bundle"(name:"TriageScore",type:"Event") {
				TriageScoreObject{
					Patient_ID (type:"String",attributes[0])
					Provide_ID(type:"String",attributes[1])
					CTAS (type:"String",attributes[2])
					timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
		}
		writer.close()
		return "The file ${fileName} is created"
	}
/* -----------------------------------------------------------------------------*/
	
/* 14-  DischargeRequest Method*/
	
	def DischargeRequest(List attributes){
		def today= appendTimeStamp()
		def fileName= "C:\\OslerProject\\TestCase1\\InputEvents\\DischargeRequest"+"$today"+".xml"
		def file= new File(fileName)
		def writer=new FileWriter(file)
		def xml= new MarkupBuilder(writer)
		xml.setDoubleQuotes(true)
		def time= creatTimeStamp(attributes[3])
		
		xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/DischargeRequest',"version":"6.2",name:"WFM"){
		"connector-bundle"(name:"DischargeRequest",type:"Event") {
			DischargeRequestObject{
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
		writer.close()
		return "The file ${fileName} is created"
		}
/* -----------------------------------------------------------------------------*/
	
	
/* -----------------------------------------------------------------------------*/
/* 15-  BedCleanUpRequest Method*/
		
		def BedCleanUpRequest(List attributes){
			def today= appendTimeStamp()
			def fileName= "C:\\OslerProject\\TestCase1\\InputEvents\\BedCleanUpRequest"+"$today"+".xml"
			def file= new File(fileName)
			def writer=new FileWriter(file)
			def xml= new MarkupBuilder(writer)
			xml.setDoubleQuotes(true)
			def time= creatTimeStamp(attributes[2])
			
			xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/BedCleanUpRequest',"version":"6.2",name:"WFM"){
			"connector-bundle"(name:"BedCleanUpRequest",type:"Event") {
				BedCleanUpRequestObject{
					Location_ID (type:"String",attributes[0])
					Unit_ID(type:"String",attributes[1])
					timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
			}
			writer.close()
			return "The file ${fileName} is created"
			}
	/* -----------------------------------------------------------------------------*/
		
		
/* 16- ProceduresScheduled Method*/
		
		def ProceduresScheduled(List attributes){
			def today= appendTimeStamp()
			def fileName="C:\\OslerProject\\TestCase1\\InputEvents\\ProceduresScheduled"+"$today"+".xml"
			def file= new File(fileName)
			def writer=new FileWriter(file)
			def xml= new MarkupBuilder(writer)
			xml.setDoubleQuotes(true)
			def time= creatTimeStamp(attributes[3])
					
			xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/ProceduresScheduled',"version":"6.2",name:"WFM"){
			"connector-bundle"(name:"ProceduresScheduled",type:"Event") {
				ProceduresScheduledobject{
					Patient_ID (type:"String",attributes[0])
					ProcedureScheduledTime (type:"String",attributes[1])
					Unit_ID(type:"String",attributes[2])
					timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
			}
			writer.close()
			return "The file ${fileName} is created"
			}
		
	/* -----------------------------------------------------------------------------*/
		
		/* 7-  ProcedureStarted Method*/
		
		def ProcedureStarted(List attributes){
			def today= appendTimeStamp()
			def fileName= "C:\\OslerProject\\TestCase1\\InputEvents\\ProcedureStarted"+"$today"+".xml"
			def file= new File(fileName)
			def writer=new FileWriter(file)
			def xml= new MarkupBuilder(writer)
			xml.setDoubleQuotes(true)
			def time= creatTimeStamp(attributes[3])
			
			xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/ProcedureStarted',"version":"6.2",name:"WFM"){
			"connector-bundle"(name:"ProcedureStarted",type:"Event") {
				ProcedureStartedObject{
					
					Patient_ID (type:"String",attributes[0])
					Provider_ID (type:"String",attributes[1])
					Procedure_Type(type:"String",attributes[2])
					timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
			}
			writer.close()
			return "The file ${fileName} is created"
			}
		/* -----------------------------------------------------------------------------*/
		
		/* -----------------------------------------------------------------------------*/
		
		/* 7-  ProcedureCompleted Method*/
		
		def ProcedureCompleted(List attributes){
			def today= appendTimeStamp()
			def fileName= "C:\\OslerProject\\TestCase1\\InputEvents\\ProcedureCompleted"+"$today"+".xml"
			def file= new File(fileName)
			def writer=new FileWriter(file)
			def xml= new MarkupBuilder(writer)
			xml.setDoubleQuotes(true)
			def time= creatTimeStamp(attributes[3])
			
			xml.connector (xmlns:'http://wbe.ibm.com/6.2/Event/ProcedureCompleted',"version":"6.2",name:"WFM"){
			"connector-bundle"(name:"ProcedureCompleted",type:"Event") {
				ProcedureCompletedObject{
					
					Patient_ID (type:"String",attributes[0])
					Provider_ID (type:"String",attributes[1])
					Procedure_Type(type:"String",attributes[2])
					timestamp(type:"DateTime",time)
				}
			}
			system("WIN-U8BMQ67RW9Y")
			timestamp(time)
			loginfo("Test values from WebSphere Business Events:Design Data")
			}
			writer.close()
			return "The file ${fileName} is created"
			}
		/* -----------------------------------------------------------------------------*/
	
/* -----------------------------------------------------------------------------*/
	
	def creatTimeStamp(String t){
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
		Date d=sdf.parse(t)
		def time=sdf.format(d)
		return time
	}
	
	def appendTimeStamp(){
		def c= new GregorianCalendar()
		def year = c.get(Calendar.YEAR).toString()
		def month = (c.get(Calendar.MONTH)+1).toString().padLeft(2,'0')
		def date = c.get(Calendar.DATE).toString()
		def h=c.get(Calendar.HOUR).toString()
		def m=c.get(Calendar.MINUTE).toString()
		def s=c.get(Calendar.SECOND).toString()
		def today= "${year}"+"${month}"+"${date}"+"${h}"+"${m}"+"${s}"
		return today
	}
		  
/* ***************************  End of CEP Methods ******************************* */
}

  
