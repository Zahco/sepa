package tp.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private static final String NAMESPACE_URI = "m1GIL:rest:tp";

    private static final String CENTER  = "Center";
    private static final String CAGE    = "Cage";
    private static final String ANIMAL  = "Animal";
    private static final String POSITION= "Position";

    private final static QName QNAME_CENTER  = new QName(NAMESPACE_URI, CENTER  );
    private final static QName QNAME_CAGE    = new QName(NAMESPACE_URI, CAGE    );
    private final static QName QNAME_ANIMAL  = new QName(NAMESPACE_URI, ANIMAL  );
    private final static QName QNAME_POSITION= new QName(NAMESPACE_URI, POSITION);

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for this package
     */
    public ObjectFactory() {}

    public Center    createCenter   () {return new Center   ();}
    public Cage      createCage     () {return new Cage     ();}
    public Animal    createAnimal   () {return new Animal   ();}
    public Position  createPosition () {return new Position ();}

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Center }{@code >}}
     */
    @SuppressWarnings("unused")
    @XmlElementDecl(namespace = NAMESPACE_URI, name = CENTER)
    public JAXBElement<Center> createCenter(Center value) {
        return new JAXBElement<>(QNAME_CENTER, Center.class, null, value);
    }

    @SuppressWarnings("unused")
    @XmlElementDecl(namespace = NAMESPACE_URI, name = POSITION)
    public JAXBElement<Position> createPosition(Position value) {
        return new JAXBElement<>(QNAME_POSITION, Position.class, null, value);
    }

    @SuppressWarnings("unused")
    @XmlElementDecl(namespace = NAMESPACE_URI, name = CAGE)
    public JAXBElement<Cage> createCityManager(Cage value) {
        return new JAXBElement<>(QNAME_CAGE, Cage.class, null, value);
    }

    @SuppressWarnings("unused")
    @XmlElementDecl(namespace = NAMESPACE_URI, name = ANIMAL)
    public JAXBElement<Animal> createCityManager(Animal value) {
        return new JAXBElement<>(QNAME_ANIMAL, Animal.class, null, value);
    }
}
