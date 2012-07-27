
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bedCleanUpCompletedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bedCleanUpCompletedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BedCleanUpCompletedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bedCleanUpCompletedResponse", propOrder = {
    "bedCleanUpCompletedResponse"
})
public class BedCleanUpCompletedResponse {

    @XmlElement(name = "BedCleanUpCompletedResponse")
    protected String bedCleanUpCompletedResponse;

    /**
     * Gets the value of the bedCleanUpCompletedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedCleanUpCompletedResponse() {
        return bedCleanUpCompletedResponse;
    }

    /**
     * Sets the value of the bedCleanUpCompletedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedCleanUpCompletedResponse(String value) {
        this.bedCleanUpCompletedResponse = value;
    }

}
