package tp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.LinkedList;

@XmlRootElement
public class Cage {
    /**
     * The name of this cage
     */
    private String name;
    /**
     * The visitor entrance location
     */
    private Position position;
    /**
     * The maximum number of animals in this cage
     */
    private Integer capacity;
    /**
     * The animals in this cage.
     */
    private Collection<Animal> residents;

    public Cage() {
    }

    public Cage(String name, Position position, Integer capacity) {
        this(name, position, capacity, new LinkedList<Animal>());
    }

    public Cage(String name, Position position, Integer capacity, Collection<Animal> residents) {
        this.name = name;
        this.position = position;
        this.capacity = capacity;
        this.residents = residents;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Position getPosition() {
        return position;
    }

    public Collection<Animal> getResidents() {
        return residents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setResidents(Collection<Animal> residents) {
        this.residents = residents;
    }
}
