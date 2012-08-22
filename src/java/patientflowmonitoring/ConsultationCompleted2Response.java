
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultationCompleted2Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultationCompleted2Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsultationCompleted2Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultationCompleted2Response", propOrder = {
    "consultationCompleted2Response"
})
public class ConsultationCompleted2Response {

    @XmlElement(name = "ConsultationCompleted2Response")
    protected String consultationCompleted2Response;

    /**
     * Gets the value of the consultationCompleted2Response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsultationCompleted2Response() {
        return consultationCompleted2Response;
    }

    /**
     * Sets the value of the consultationCompleted2Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsultationCompleted2Response(String value) {
        this.consultationCompleted2Response = value;
    }

}
