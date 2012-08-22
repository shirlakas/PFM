
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientArrivedInBedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientArrivedInBedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientArrivedInBedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientArrivedInBedResponse", propOrder = {
    "patientArrivedInBedResponse"
})
public class PatientArrivedInBedResponse {

    @XmlElement(name = "PatientArrivedInBedResponse")
    protected String patientArrivedInBedResponse;

    /**
     * Gets the value of the patientArrivedInBedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientArrivedInBedResponse() {
        return patientArrivedInBedResponse;
    }

    /**
     * Sets the value of the patientArrivedInBedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientArrivedInBedResponse(String value) {
        this.patientArrivedInBedResponse = value;
    }

}
