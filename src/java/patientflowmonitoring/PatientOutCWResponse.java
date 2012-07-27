
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientOutCWResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientOutCWResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientOutCWResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientOutCWResponse", propOrder = {
    "patientOutCWResponse"
})
public class PatientOutCWResponse {

    @XmlElement(name = "PatientOutCWResponse")
    protected String patientOutCWResponse;

    /**
     * Gets the value of the patientOutCWResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientOutCWResponse() {
        return patientOutCWResponse;
    }

    /**
     * Sets the value of the patientOutCWResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientOutCWResponse(String value) {
        this.patientOutCWResponse = value;
    }

}
