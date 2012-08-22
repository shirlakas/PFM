
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderRequestCompletedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderRequestCompletedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderRequestCompletedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderRequestCompletedResponse", propOrder = {
    "orderRequestCompletedResponse"
})
public class OrderRequestCompletedResponse {

    @XmlElement(name = "OrderRequestCompletedResponse")
    protected String orderRequestCompletedResponse;

    /**
     * Gets the value of the orderRequestCompletedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderRequestCompletedResponse() {
        return orderRequestCompletedResponse;
    }

    /**
     * Sets the value of the orderRequestCompletedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderRequestCompletedResponse(String value) {
        this.orderRequestCompletedResponse = value;
    }

}
