//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.03.28 à 05:04:30 PM CEST 
//


package model.sepa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour ddtiType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="ddtiType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtId" type="{http://univ.fr/sepa}max35Text"/>
 *         &lt;element name="InstdAmt" type="{http://univ.fr/sepa}InstdAmtType"/>
 *         &lt;element ref="{http://univ.fr/sepa}DrctDbtTx"/>
 *         &lt;element ref="{http://univ.fr/sepa}DbtrAgt"/>
 *         &lt;element ref="{http://univ.fr/sepa}Dbtr"/>
 *         &lt;element ref="{http://univ.fr/sepa}DbtrAcct"/>
 *         &lt;element name="RmtInf" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ddtiType", propOrder = {
    "pmtId",
    "instdAmt",
    "drctDbtTx",
    "dbtrAgt",
    "dbtr",
    "dbtrAcct",
    "rmtInf"
})
public class DdtiType {

    @XmlElement(name = "PmtId", required = true)
    protected String pmtId;
    @XmlElement(name = "InstdAmt", required = true)
    protected InstdAmtType instdAmt;
    @XmlElement(name = "DrctDbtTx", namespace = "http://univ.fr/sepa", required = true)
    protected DdtType drctDbtTx;
    @XmlElement(name = "DbtrAgt", namespace = "http://univ.fr/sepa", required = true)
    protected DAgentType dbtrAgt;
    @XmlElement(name = "Dbtr", namespace = "http://univ.fr/sepa", required = true)
    protected DebtorType dbtr;
    @XmlElement(name = "DbtrAcct", namespace = "http://univ.fr/sepa", required = true)
    protected DAccountType dbtrAcct;
    @XmlElement(name = "RmtInf")
    protected List<String> rmtInf;

    /**
     * Obtient la valeur de la propriété pmtId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtId() {
        return pmtId;
    }

    /**
     * Définit la valeur de la propriété pmtId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtId(String value) {
        this.pmtId = value;
    }

    /**
     * Obtient la valeur de la propriété instdAmt.
     * 
     * @return
     *     possible object is
     *     {@link InstdAmtType }
     *     
     */
    public InstdAmtType getInstdAmt() {
        return instdAmt;
    }

    /**
     * Définit la valeur de la propriété instdAmt.
     * 
     * @param value
     *     allowed object is
     *     {@link InstdAmtType }
     *     
     */
    public void setInstdAmt(InstdAmtType value) {
        this.instdAmt = value;
    }

    /**
     * Obtient la valeur de la propriété drctDbtTx.
     * 
     * @return
     *     possible object is
     *     {@link DdtType }
     *     
     */
    public DdtType getDrctDbtTx() {
        return drctDbtTx;
    }

    /**
     * Définit la valeur de la propriété drctDbtTx.
     * 
     * @param value
     *     allowed object is
     *     {@link DdtType }
     *     
     */
    public void setDrctDbtTx(DdtType value) {
        this.drctDbtTx = value;
    }

    /**
     * Obtient la valeur de la propriété dbtrAgt.
     * 
     * @return
     *     possible object is
     *     {@link DAgentType }
     *     
     */
    public DAgentType getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * Définit la valeur de la propriété dbtrAgt.
     * 
     * @param value
     *     allowed object is
     *     {@link DAgentType }
     *     
     */
    public void setDbtrAgt(DAgentType value) {
        this.dbtrAgt = value;
    }

    /**
     * Obtient la valeur de la propriété dbtr.
     * 
     * @return
     *     possible object is
     *     {@link DebtorType }
     *     
     */
    public DebtorType getDbtr() {
        return dbtr;
    }

    /**
     * Définit la valeur de la propriété dbtr.
     * 
     * @param value
     *     allowed object is
     *     {@link DebtorType }
     *     
     */
    public void setDbtr(DebtorType value) {
        this.dbtr = value;
    }

    /**
     * Obtient la valeur de la propriété dbtrAcct.
     * 
     * @return
     *     possible object is
     *     {@link DAccountType }
     *     
     */
    public DAccountType getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * Définit la valeur de la propriété dbtrAcct.
     * 
     * @param value
     *     allowed object is
     *     {@link DAccountType }
     *     
     */
    public void setDbtrAcct(DAccountType value) {
        this.dbtrAcct = value;
    }

    /**
     * Gets the value of the rmtInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmtInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRmtInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getRmtInf() {
        if (rmtInf == null) {
            rmtInf = new ArrayList<String>();
        }
        return this.rmtInf;
    }

}
