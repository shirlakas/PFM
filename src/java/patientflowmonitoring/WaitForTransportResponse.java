
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForTransportResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForTransportResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForTransportResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForTransportResponse", propOrder = {
    "waitForTransportResponse"
})
public class WaitForTransportResponse {

    @XmlElement(name = "WaitForTransportResponse")
    protected String waitForTransportResponse;

    /**
     * Gets the value of the waitForTransportResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForTransportResponse() {
        return waitForTransportResponse;
    }

    /**
     * Sets the value of the waitForTransportResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForTransportResponse(String value) {
        this.waitForTransportResponse = value;
    }

}
