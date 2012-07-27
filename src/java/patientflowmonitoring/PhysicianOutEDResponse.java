
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for physicianOutEDResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="physicianOutEDResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhysicianOutEDResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "physicianOutEDResponse", propOrder = {
    "physicianOutEDResponse"
})
public class PhysicianOutEDResponse {

    @XmlElement(name = "PhysicianOutEDResponse")
    protected String physicianOutEDResponse;

    /**
     * Gets the value of the physicianOutEDResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhysicianOutEDResponse() {
        return physicianOutEDResponse;
    }

    /**
     * Sets the value of the physicianOutEDResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhysicianOutEDResponse(String value) {
        this.physicianOutEDResponse = value;
    }

}
