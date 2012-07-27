
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultationStarted1Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultationStarted1Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsultationStarted1Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultationStarted1Response", propOrder = {
    "consultationStarted1Response"
})
public class ConsultationStarted1Response {

    @XmlElement(name = "ConsultationStarted1Response")
    protected String consultationStarted1Response;

    /**
     * Gets the value of the consultationStarted1Response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsultationStarted1Response() {
        return consultationStarted1Response;
    }

    /**
     * Sets the value of the consultationStarted1Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsultationStarted1Response(String value) {
        this.consultationStarted1Response = value;
    }

}
