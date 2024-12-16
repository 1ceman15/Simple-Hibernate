import jakarta.persistence.*;

import java.time.LocalDate;


@IdClass(ChildPK.class)
@Entity(name = "children")
public class Child {
    @Id
    String name;
    @Id
    String tabno;
    char sex;
    LocalDate born;
    @ManyToOne
    @JoinColumn(name = "tabno")
    Employer parent;

    public Child() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTabno() {
        return tabno;
    }

    public void setTabno(String tabno) {
        this.tabno = tabno;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", tabno=" + tabno +
                ", sex=" + sex +
                ", born=" + born +
                '}';
    }
}
