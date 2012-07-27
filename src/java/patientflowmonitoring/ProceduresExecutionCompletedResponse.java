
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for proceduresExecutionCompletedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="proceduresExecutionCompletedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProceduresExecutionCompletedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proceduresExecutionCompletedResponse", propOrder = {
    "proceduresExecutionCompletedResponse"
})
public class ProceduresExecutionCompletedResponse {

    @XmlElement(name = "ProceduresExecutionCompletedResponse")
    protected String proceduresExecutionCompletedResponse;

    /**
     * Gets the value of the proceduresExecutionCompletedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProceduresExecutionCompletedResponse() {
        return proceduresExecutionCompletedResponse;
    }

    /**
     * Sets the value of the proceduresExecutionCompletedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProceduresExecutionCompletedResponse(String value) {
        this.proceduresExecutionCompletedResponse = value;
    }

}
