
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dischargeRequestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dischargeRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DischargeRequestResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dischargeRequestResponse", propOrder = {
    "dischargeRequestResponse"
})
public class DischargeRequestResponse {

    @XmlElement(name = "DischargeRequestResponse")
    protected String dischargeRequestResponse;

    /**
     * Gets the value of the dischargeRequestResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDischargeRequestResponse() {
        return dischargeRequestResponse;
    }

    /**
     * Sets the value of the dischargeRequestResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDischargeRequestResponse(String value) {
        this.dischargeRequestResponse = value;
    }

}
