
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procedureStartedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procedureStartedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcedureStartedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procedureStartedResponse", propOrder = {
    "procedureStartedResponse"
})
public class ProcedureStartedResponse {

    @XmlElement(name = "ProcedureStartedResponse")
    protected String procedureStartedResponse;

    /**
     * Gets the value of the procedureStartedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcedureStartedResponse() {
        return procedureStartedResponse;
    }

    /**
     * Sets the value of the procedureStartedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcedureStartedResponse(String value) {
        this.procedureStartedResponse = value;
    }

}
