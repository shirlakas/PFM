
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientTransportStartedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientTransportStartedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientTransportStartedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientTransportStartedResponse", propOrder = {
    "patientTransportStartedResponse"
})
public class PatientTransportStartedResponse {

    @XmlElement(name = "PatientTransportStartedResponse")
    protected String patientTransportStartedResponse;

    /**
     * Gets the value of the patientTransportStartedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientTransportStartedResponse() {
        return patientTransportStartedResponse;
    }

    /**
     * Sets the value of the patientTransportStartedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientTransportStartedResponse(String value) {
        this.patientTransportStartedResponse = value;
    }

}
