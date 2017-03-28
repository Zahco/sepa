//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2017.03.28 à 05:04:30 PM CEST 
//


package model.sepa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model.sepa package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Dbtr_QNAME = new QName("http://univ.fr/sepa", "Dbtr");
    private final static QName _CstmrDrctDbtInitn_QNAME = new QName("http://univ.fr/sepa", "CstmrDrctDbtInitn");
    private final static QName _DrctDbtTxInf_QNAME = new QName("http://univ.fr/sepa", "DrctDbtTxInf");
    private final static QName _DbtrAgt_QNAME = new QName("http://univ.fr/sepa", "DbtrAgt");
    private final static QName _DbtrAcct_QNAME = new QName("http://univ.fr/sepa", "DbtrAcct");
    private final static QName _DrctDbtTx_QNAME = new QName("http://univ.fr/sepa", "DrctDbtTx");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model.sepa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DdtType }
     * 
     */
    public DdtType createDdtType() {
        return new DdtType();
    }

    /**
     * Create an instance of {@link DAccountType }
     * 
     */
    public DAccountType createDAccountType() {
        return new DAccountType();
    }

    /**
     * Create an instance of {@link DAgentType }
     * 
     */
    public DAgentType createDAgentType() {
        return new DAgentType();
    }

    /**
     * Create an instance of {@link DdtiType }
     * 
     */
    public DdtiType createDdtiType() {
        return new DdtiType();
    }

    /**
     * Create an instance of {@link DebtorType }
     * 
     */
    public DebtorType createDebtorType() {
        return new DebtorType();
    }

    /**
     * Create an instance of {@link RootType }
     * 
     */
    public RootType createRootType() {
        return new RootType();
    }

    /**
     * Create an instance of {@link InstdAmtType }
     * 
     */
    public InstdAmtType createInstdAmtType() {
        return new InstdAmtType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebtorType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://univ.fr/sepa", name = "Dbtr")
    public JAXBElement<DebtorType> createDbtr(DebtorType value) {
        return new JAXBElement<DebtorType>(_Dbtr_QNAME, DebtorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://univ.fr/sepa", name = "CstmrDrctDbtInitn")
    public JAXBElement<RootType> createCstmrDrctDbtInitn(RootType value) {
        return new JAXBElement<RootType>(_CstmrDrctDbtInitn_QNAME, RootType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DdtiType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://univ.fr/sepa", name = "DrctDbtTxInf")
    public JAXBElement<DdtiType> createDrctDbtTxInf(DdtiType value) {
        return new JAXBElement<DdtiType>(_DrctDbtTxInf_QNAME, DdtiType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAgentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://univ.fr/sepa", name = "DbtrAgt")
    public JAXBElement<DAgentType> createDbtrAgt(DAgentType value) {
        return new JAXBElement<DAgentType>(_DbtrAgt_QNAME, DAgentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAccountType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://univ.fr/sepa", name = "DbtrAcct")
    public JAXBElement<DAccountType> createDbtrAcct(DAccountType value) {
        return new JAXBElement<DAccountType>(_DbtrAcct_QNAME, DAccountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DdtType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://univ.fr/sepa", name = "DrctDbtTx")
    public JAXBElement<DdtType> createDrctDbtTx(DdtType value) {
        return new JAXBElement<DdtType>(_DrctDbtTx_QNAME, DdtType.class, null, value);
    }

}
