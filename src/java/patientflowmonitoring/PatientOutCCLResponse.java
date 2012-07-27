
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientOutCCLResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientOutCCLResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientOutCCLResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientOutCCLResponse", propOrder = {
    "patientOutCCLResponse"
})
public class PatientOutCCLResponse {

    @XmlElement(name = "PatientOutCCLResponse")
    protected String patientOutCCLResponse;

    /**
     * Gets the value of the patientOutCCLResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientOutCCLResponse() {
        return patientOutCCLResponse;
    }

    /**
     * Sets the value of the patientOutCCLResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientOutCCLResponse(String value) {
        this.patientOutCCLResponse = value;
    }

}
