
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bedCleanUpRequestResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bedCleanUpRequestResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BedCleanUpRequestResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bedCleanUpRequestResponse", propOrder = {
    "bedCleanUpRequestResponse"
})
public class BedCleanUpRequestResponse {

    @XmlElement(name = "BedCleanUpRequestResponse")
    protected String bedCleanUpRequestResponse;

    /**
     * Gets the value of the bedCleanUpRequestResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedCleanUpRequestResponse() {
        return bedCleanUpRequestResponse;
    }

    /**
     * Sets the value of the bedCleanUpRequestResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedCleanUpRequestResponse(String value) {
        this.bedCleanUpRequestResponse = value;
    }

}
