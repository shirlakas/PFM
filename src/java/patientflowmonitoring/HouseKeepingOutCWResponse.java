
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for houseKeepingOutCWResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="houseKeepingOutCWResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HouseKeepingOutCWResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "houseKeepingOutCWResponse", propOrder = {
    "houseKeepingOutCWResponse"
})
public class HouseKeepingOutCWResponse {

    @XmlElement(name = "HouseKeepingOutCWResponse")
    protected String houseKeepingOutCWResponse;

    /**
     * Gets the value of the houseKeepingOutCWResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseKeepingOutCWResponse() {
        return houseKeepingOutCWResponse;
    }

    /**
     * Sets the value of the houseKeepingOutCWResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseKeepingOutCWResponse(String value) {
        this.houseKeepingOutCWResponse = value;
    }

}
