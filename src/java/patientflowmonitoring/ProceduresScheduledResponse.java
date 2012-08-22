
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for proceduresScheduledResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="proceduresScheduledResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProceduresScheduledResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proceduresScheduledResponse", propOrder = {
    "proceduresScheduledResponse"
})
public class ProceduresScheduledResponse {

    @XmlElement(name = "ProceduresScheduledResponse")
    protected String proceduresScheduledResponse;

    /**
     * Gets the value of the proceduresScheduledResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProceduresScheduledResponse() {
        return proceduresScheduledResponse;
    }

    /**
     * Sets the value of the proceduresScheduledResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProceduresScheduledResponse(String value) {
        this.proceduresScheduledResponse = value;
    }

}
