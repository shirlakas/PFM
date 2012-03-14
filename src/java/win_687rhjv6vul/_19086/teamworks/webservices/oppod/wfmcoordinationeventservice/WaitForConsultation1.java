
package win_687rhjv6vul._19086.teamworks.webservices.oppod.wfmcoordinationeventservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Patient_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Location_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "patientID",
    "locationID",
    "timestamp"
})
@XmlRootElement(name = "WaitForConsultation1")
public class WaitForConsultation1 {

    @XmlElement(name = "Patient_ID", required = true)
    protected String patientID;
    @XmlElement(name = "Location_ID", required = true)
    protected String locationID;
    @XmlElement(required = true)
    protected String timestamp;

    /**
     * Gets the value of the patientID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientID() {
        return patientID;
    }

    /**
     * Sets the value of the patientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientID(String value) {
        this.patientID = value;
    }

    /**
     * Gets the value of the locationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationID() {
        return locationID;
    }

    /**
     * Sets the value of the locationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationID(String value) {
        this.locationID = value;
    }

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimestamp(String value) {
        this.timestamp = value;
    }

}
