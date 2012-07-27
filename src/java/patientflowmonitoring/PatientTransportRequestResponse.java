
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientTransportRequestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientTransportRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientTransportRequestResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientTransportRequestResponse", propOrder = {
    "patientTransportRequestResponse"
})
public class PatientTransportRequestResponse {

    @XmlElement(name = "PatientTransportRequestResponse")
    protected String patientTransportRequestResponse;

    /**
     * Gets the value of the patientTransportRequestResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientTransportRequestResponse() {
        return patientTransportRequestResponse;
    }

    /**
     * Sets the value of the patientTransportRequestResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientTransportRequestResponse(String value) {
        this.patientTransportRequestResponse = value;
    }

}
