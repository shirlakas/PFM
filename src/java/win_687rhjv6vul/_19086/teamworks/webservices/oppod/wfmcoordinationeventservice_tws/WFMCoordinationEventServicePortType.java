package win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice_tws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2012-03-09T12:14:43.830-05:00
 * Generated source version: 2.4.6
 * 
 */
@WebService(targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", name = "WFMCoordinationEventServicePortType")
@XmlSeeAlso({win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ObjectFactory.class})
public interface WFMCoordinationEventServicePortType {

    @RequestWrapper(localName = "OrderExecutionCompleted", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.OrderExecutionCompleted")
    @WebMethod(operationName = "OrderExecutionCompleted", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/OrderExecutionCompleted")
    @ResponseWrapper(localName = "OrderExecutionCompletedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.OrderExecutionCompletedResponse")
    public void orderExecutionCompleted(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "ConsultationCompleted2", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationCompleted2")
    @WebMethod(operationName = "ConsultationCompleted2", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/ConsultationCompleted2")
    @ResponseWrapper(localName = "ConsultationCompleted2Response", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationCompleted2Response")
    public void consultationCompleted2(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Physician_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String physicianID,
        @WebParam(name = "Location_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String locationID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "WaitForConsultation2", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForConsultation2")
    @WebMethod(operationName = "WaitForConsultation2", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/WaitForConsultation2")
    @ResponseWrapper(localName = "WaitForConsultation2Response", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForConsultation2Response")
    public void waitForConsultation2(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Location_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String locationID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "PatientAdmittedWithBed", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientAdmittedWithBed")
    @WebMethod(operationName = "PatientAdmittedWithBed", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/PatientAdmittedWithBed")
    @ResponseWrapper(localName = "PatientAdmittedWithBedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientAdmittedWithBedResponse")
    public void patientAdmittedWithBed(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "Bed_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String bedID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "ConsultationStarted1", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationStarted1")
    @WebMethod(operationName = "ConsultationStarted1", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/ConsultationStarted1")
    @ResponseWrapper(localName = "ConsultationStarted1Response", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationStarted1Response")
    public void consultationStarted1(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Physician_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String physicianID,
        @WebParam(name = "Location_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String locationID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "ConsultationStarted2", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationStarted2")
    @WebMethod(operationName = "ConsultationStarted2", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/ConsultationStarted2")
    @ResponseWrapper(localName = "ConsultationStarted2Response", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationStarted2Response")
    public void consultationStarted2(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Physician_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String physicianID,
        @WebParam(name = "Location_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String locationID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "OrderRequest", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.OrderRequest")
    @WebMethod(operationName = "OrderRequest", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/OrderRequest")
    @ResponseWrapper(localName = "OrderRequestResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.OrderRequestResponse")
    public void orderRequest(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Provider_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String providerID,
        @WebParam(name = "OrderType", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String orderType,
        @WebParam(name = "Order_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String orderID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "PatientAdmittedWithNoBed", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientAdmittedWithNoBed")
    @WebMethod(operationName = "PatientAdmittedWithNoBed", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/PatientAdmittedWithNoBed")
    @ResponseWrapper(localName = "PatientAdmittedWithNoBedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientAdmittedWithNoBedResponse")
    public void patientAdmittedWithNoBed(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "WaitForOrderExecution", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForOrderExecution")
    @WebMethod(operationName = "WaitForOrderExecution", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/WaitForOrderExecution")
    @ResponseWrapper(localName = "WaitForOrderExecutionResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForOrderExecutionResponse")
    public void waitForOrderExecution(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "OrderRequestCompleted", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.OrderRequestCompleted")
    @WebMethod(operationName = "OrderRequestCompleted", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/OrderRequestCompleted")
    @ResponseWrapper(localName = "OrderRequestCompletedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.OrderRequestCompletedResponse")
    public void orderRequestCompleted(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Provider_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String providerID,
        @WebParam(name = "OrderType", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String orderType,
        @WebParam(name = "Order_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String orderID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "WaitForBed", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForBed")
    @WebMethod(operationName = "WaitForBed", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/WaitForBed")
    @ResponseWrapper(localName = "WaitForBedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForBedResponse")
    public void waitForBed(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "PatientArriveInBed", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientArriveInBed")
    @WebMethod(operationName = "PatientArriveInBed", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/PatientArriveInBed")
    @ResponseWrapper(localName = "PatientArriveInBedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientArriveInBedResponse")
    public void patientArriveInBed(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Bed_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String bedID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "PatientTransportRequest", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientTransportRequest")
    @WebMethod(operationName = "PatientTransportRequest", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/PatientTransportRequest")
    @ResponseWrapper(localName = "PatientTransportRequestResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientTransportRequestResponse")
    public void patientTransportRequest(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Provider_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String providerID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "WaitForConsultation1", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForConsultation1")
    @WebMethod(operationName = "WaitForConsultation1", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/WaitForConsultation1")
    @ResponseWrapper(localName = "WaitForConsultation1Response", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForConsultation1Response")
    public void waitForConsultation1(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Location_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String locationID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "ConsultationCompleted1", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationCompleted1")
    @WebMethod(operationName = "ConsultationCompleted1", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/ConsultationCompleted1")
    @ResponseWrapper(localName = "ConsultationCompleted1Response", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.ConsultationCompleted1Response")
    public void consultationCompleted1(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Physician_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String physicianID,
        @WebParam(name = "Location_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String locationID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "TriageScore", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.TriageScore")
    @WebMethod(operationName = "TriageScore", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/TriageScore")
    @ResponseWrapper(localName = "TriageScoreResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.TriageScoreResponse")
    public void triageScore(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Provider_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String providerID,
        @WebParam(name = "CTAS", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String ctas,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "WaitForTransport", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForTransport")
    @WebMethod(operationName = "WaitForTransport", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/WaitForTransport")
    @ResponseWrapper(localName = "WaitForTransportResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.WaitForTransportResponse")
    public void waitForTransport(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "PatientRegistered", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientRegistered")
    @WebMethod(operationName = "PatientRegistered", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/PatientRegistered")
    @ResponseWrapper(localName = "PatientRegisteredResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientRegisteredResponse")
    public void patientRegistered(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Room_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String roomID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "PatientTransportStarted", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientTransportStarted")
    @WebMethod(operationName = "PatientTransportStarted", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/PatientTransportStarted")
    @ResponseWrapper(localName = "PatientTransportStartedResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.PatientTransportStartedResponse")
    public void patientTransportStarted(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );

    @RequestWrapper(localName = "BedRequest", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.BedRequest")
    @WebMethod(operationName = "BedRequest", action = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws/BedRequest")
    @ResponseWrapper(localName = "BedRequestResponse", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws", className = "win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice.BedRequestResponse")
    public void bedRequest(
        @WebParam(name = "Patient_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String patientID,
        @WebParam(name = "Provider_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String providerID,
        @WebParam(name = "Unit_ID", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String unitID,
        @WebParam(name = "timestamp", targetNamespace = "http://WIN-687RHJV6VUL:19086/teamworks/webservices/OPPOD/WFMCoordinationEventService.tws")
        java.lang.String timestamp
    );
}