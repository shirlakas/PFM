
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for houseKeepingInCWResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="houseKeepingInCWResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HouseKeepingnInCWResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "houseKeepingInCWResponse", propOrder = {
    "houseKeepingnInCWResponse"
})
public class HouseKeepingInCWResponse {

    @XmlElement(name = "HouseKeepingnInCWResponse")
    protected String houseKeepingnInCWResponse;

    /**
     * Gets the value of the houseKeepingnInCWResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseKeepingnInCWResponse() {
        return houseKeepingnInCWResponse;
    }

    /**
     * Sets the value of the houseKeepingnInCWResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseKeepingnInCWResponse(String value) {
        this.houseKeepingnInCWResponse = value;
    }

}
