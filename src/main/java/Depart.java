import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "depart")
public class Depart {
    @Id
    @Column(name = "depno")
    int id;
    String name;
    @OneToMany(mappedBy = "department")
    List<Employer> employers;

    public Depart() {
        this.employers = new ArrayList<>();
    }

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employers=" + employers +
                '}';
    }
}
