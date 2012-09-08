
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForBedCleanUpResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForBedCleanUpResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForBedCleanUpResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForBedCleanUpResponse", propOrder = {
    "waitForBedCleanUpResponse"
})
public class WaitForBedCleanUpResponse {

    @XmlElement(name = "WaitForBedCleanUpResponse")
    protected String waitForBedCleanUpResponse;

    /**
     * Gets the value of the waitForBedCleanUpResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForBedCleanUpResponse() {
        return waitForBedCleanUpResponse;
    }

    /**
     * Sets the value of the waitForBedCleanUpResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForBedCleanUpResponse(String value) {
        this.waitForBedCleanUpResponse = value;
    }

}
