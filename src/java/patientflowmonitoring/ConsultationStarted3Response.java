
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultationStarted3Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultationStarted3Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsultationStarted3Response" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultationStarted3Response", propOrder = {
    "consultationStarted3Response"
})
public class ConsultationStarted3Response {

    @XmlElement(name = "ConsultationStarted3Response")
    protected String consultationStarted3Response;

    /**
     * Gets the value of the consultationStarted3Response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsultationStarted3Response() {
        return consultationStarted3Response;
    }

    /**
     * Sets the value of the consultationStarted3Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsultationStarted3Response(String value) {
        this.consultationStarted3Response = value;
    }

}
