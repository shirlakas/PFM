
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for triageScoreResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="triageScoreResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="triageScoreResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "triageScoreResponse", propOrder = {
    "triageScoreResponse"
})
public class TriageScoreResponse {

    protected String triageScoreResponse;

    /**
     * Gets the value of the triageScoreResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTriageScoreResponse() {
        return triageScoreResponse;
    }

    /**
     * Sets the value of the triageScoreResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTriageScoreResponse(String value) {
        this.triageScoreResponse = value;
    }

}
