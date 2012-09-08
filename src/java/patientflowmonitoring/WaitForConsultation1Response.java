
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForConsultation1Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForConsultation1Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForConsultation1Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForConsultation1Response", propOrder = {
    "waitForConsultation1Response"
})
public class WaitForConsultation1Response {

    @XmlElement(name = "WaitForConsultation1Response")
    protected String waitForConsultation1Response;

    /**
     * Gets the value of the waitForConsultation1Response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForConsultation1Response() {
        return waitForConsultation1Response;
    }

    /**
     * Sets the value of the waitForConsultation1Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForConsultation1Response(String value) {
        this.waitForConsultation1Response = value;
    }

}
