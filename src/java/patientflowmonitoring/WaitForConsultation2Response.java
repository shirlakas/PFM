
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForConsultation2Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForConsultation2Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForConsultation2Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForConsultation2Response", propOrder = {
    "waitForConsultation2Response"
})
public class WaitForConsultation2Response {

    @XmlElement(name = "WaitForConsultation2Response")
    protected String waitForConsultation2Response;

    /**
     * Gets the value of the waitForConsultation2Response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForConsultation2Response() {
        return waitForConsultation2Response;
    }

    /**
     * Sets the value of the waitForConsultation2Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForConsultation2Response(String value) {
        this.waitForConsultation2Response = value;
    }

}
