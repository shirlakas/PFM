
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientInCWResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientInCWResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientInCWResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientInCWResponse", propOrder = {
    "patientInCWResponse"
})
public class PatientInCWResponse {

    @XmlElement(name = "PatientInCWResponse")
    protected String patientInCWResponse;

    /**
     * Gets the value of the patientInCWResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientInCWResponse() {
        return patientInCWResponse;
    }

    /**
     * Sets the value of the patientInCWResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientInCWResponse(String value) {
        this.patientInCWResponse = value;
    }

}
