
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procedureUpdatedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procedureUpdatedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcedureUpdatedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procedureUpdatedResponse", propOrder = {
    "procedureUpdatedResponse"
})
public class ProcedureUpdatedResponse {

    @XmlElement(name = "ProcedureUpdatedResponse")
    protected String procedureUpdatedResponse;

    /**
     * Gets the value of the procedureUpdatedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcedureUpdatedResponse() {
        return procedureUpdatedResponse;
    }

    /**
     * Sets the value of the procedureUpdatedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcedureUpdatedResponse(String value) {
        this.procedureUpdatedResponse = value;
    }

}
