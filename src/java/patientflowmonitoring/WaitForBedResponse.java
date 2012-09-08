
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForBedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForBedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForBedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForBedResponse", propOrder = {
    "waitForBedResponse"
})
public class WaitForBedResponse {

    @XmlElement(name = "WaitForBedResponse")
    protected String waitForBedResponse;

    /**
     * Gets the value of the waitForBedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForBedResponse() {
        return waitForBedResponse;
    }

    /**
     * Sets the value of the waitForBedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForBedResponse(String value) {
        this.waitForBedResponse = value;
    }

}
