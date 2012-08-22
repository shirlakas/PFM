
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waitForProceduresResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="waitForProceduresResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WaitForProceduresResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waitForProceduresResponse", propOrder = {
    "waitForProceduresResponse"
})
public class WaitForProceduresResponse {

    @XmlElement(name = "WaitForProceduresResponse")
    protected String waitForProceduresResponse;

    /**
     * Gets the value of the waitForProceduresResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaitForProceduresResponse() {
        return waitForProceduresResponse;
    }

    /**
     * Sets the value of the waitForProceduresResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaitForProceduresResponse(String value) {
        this.waitForProceduresResponse = value;
    }

}
