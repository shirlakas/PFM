
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for patientAdmittedWithNoBedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientAdmittedWithNoBedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PatientAdmittedWithNoBedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientAdmittedWithNoBedResponse", propOrder = {
    "patientAdmittedWithNoBedResponse"
})
public class PatientAdmittedWithNoBedResponse {

    @XmlElement(name = "PatientAdmittedWithNoBedResponse")
    protected String patientAdmittedWithNoBedResponse;

    /**
     * Gets the value of the patientAdmittedWithNoBedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientAdmittedWithNoBedResponse() {
        return patientAdmittedWithNoBedResponse;
    }

    /**
     * Sets the value of the patientAdmittedWithNoBedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientAdmittedWithNoBedResponse(String value) {
        this.patientAdmittedWithNoBedResponse = value;
    }

}
