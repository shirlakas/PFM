
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
 *         &lt;element name="Unit_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bed_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "unitID",
    "bedID",
    "timestamp"
})
@XmlRootElement(name = "PatientAdmittedWithBed")
public class PatientAdmittedWithBed {

    @XmlElement(name = "Patient_ID", required = true)
    protected String patientID;
    @XmlElement(name = "Unit_ID", required = true)
    protected String unitID;
    @XmlElement(name = "Bed_ID", required = true)
    protected String bedID;
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
     * Gets the value of the unitID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitID(String value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the bedID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBedID() {
        return bedID;
    }

    /**
     * Sets the value of the bedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBedID(String value) {
        this.bedID = value;
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
