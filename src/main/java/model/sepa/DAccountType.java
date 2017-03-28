//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.03.28 à 05:04:30 PM CEST 
//


package model.sepa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour dAccountType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="dAccountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="IBAN" type="{http://univ.fr/sepa}IBANType"/>
 *         &lt;element name="PrvtId" type="{http://univ.fr/sepa}max35Text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dAccountType", propOrder = {
    "iban",
    "prvtId"
})
public class DAccountType {

    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "PrvtId")
    protected String prvtId;

    /**
     * Obtient la valeur de la propriété iban.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Définit la valeur de la propriété iban.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Obtient la valeur de la propriété prvtId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrvtId() {
        return prvtId;
    }

    /**
     * Définit la valeur de la propriété prvtId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrvtId(String value) {
        this.prvtId = value;
    }

}
