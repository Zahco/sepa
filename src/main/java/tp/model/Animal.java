package tp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
public class Animal {
    /**
     * Name of the animal
     */
    private String name;

    /**
     * The place where it currently live in.
     */
    private String cage;
    /**
     * The animal's species
     */
    private String species;
    /**
     * The animal unique identifier.
     */
    private UUID id;

    public Animal() {
    }

    public Animal(String name, String cage, String species) {
        this(name, cage, species, UUID.randomUUID());
    }


    public Animal(String name, String cage, String species, UUID id) {
        this.name = name;
        this.cage = cage;
        this.species = species;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("<%s : %s ( %s ) is a %s currently in %s>", this.getClass().getName(), name, id, species, cage);
    }

    public UUID getId() {
        return id;
    }

    public String getCage() {
        return cage;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void change(Animal animal) {
        setId(animal.getId());
        setName(animal.getName());
        setCage(animal.getCage());
        setSpecies(animal.getSpecies());
    }
}
