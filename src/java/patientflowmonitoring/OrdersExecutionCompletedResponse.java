
package patientflowmonitoring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ordersExecutionCompletedResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ordersExecutionCompletedResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrdersExecutionCompletedResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ordersExecutionCompletedResponse", propOrder = {
    "ordersExecutionCompletedResponse"
})
public class OrdersExecutionCompletedResponse {

    @XmlElement(name = "OrdersExecutionCompletedResponse")
    protected String ordersExecutionCompletedResponse;

    /**
     * Gets the value of the ordersExecutionCompletedResponse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdersExecutionCompletedResponse() {
        return ordersExecutionCompletedResponse;
    }

    /**
     * Sets the value of the ordersExecutionCompletedResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdersExecutionCompletedResponse(String value) {
        this.ordersExecutionCompletedResponse = value;
    }

}
