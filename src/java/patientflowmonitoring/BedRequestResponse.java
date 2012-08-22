
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bedRequestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bedRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BedRequestResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bedRequestResponse", propOrder = {
    "bedRequestResponse"
})
public class BedRequestResponse {

    @XmlElement(name = "BedRequestResponse")
    protected String bedRequestResponse;

    /**
     * Gets the value of the bedRequestResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedRequestResponse() {
        return bedRequestResponse;
    }

    /**
     * Sets the value of the bedRequestResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedRequestResponse(String value) {
        this.bedRequestResponse = value;
    }

}
