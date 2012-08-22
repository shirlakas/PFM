
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultationCompleted1Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultationCompleted1Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsultationCompleted1Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultationCompleted1Response", propOrder = {
    "consultationCompleted1Response"
})
public class ConsultationCompleted1Response {

    @XmlElement(name = "ConsultationCompleted1Response")
    protected String consultationCompleted1Response;

    /**
     * Gets the value of the consultationCompleted1Response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsultationCompleted1Response() {
        return consultationCompleted1Response;
    }

    /**
     * Sets the value of the consultationCompleted1Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsultationCompleted1Response(String value) {
        this.consultationCompleted1Response = value;
    }

}
