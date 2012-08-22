
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForOrderExecutionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForOrderExecutionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForOrderExecutionResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForOrderExecutionResponse", propOrder = {
    "waitForOrderExecutionResponse"
})
public class WaitForOrderExecutionResponse {

    @XmlElement(name = "WaitForOrderExecutionResponse")
    protected String waitForOrderExecutionResponse;

    /**
     * Gets the value of the waitForOrderExecutionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForOrderExecutionResponse() {
        return waitForOrderExecutionResponse;
    }

    /**
     * Sets the value of the waitForOrderExecutionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForOrderExecutionResponse(String value) {
        this.waitForOrderExecutionResponse = value;
    }

}
