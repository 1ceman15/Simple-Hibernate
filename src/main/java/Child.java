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
    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name =  "tabno", insertable = false, updatable = false) // Внешний ключ на Employer
    Employer parent;

    public Child() {
    }

    public Child(String name, String tabno, char sex, LocalDate born, Employer parent) {
        this.name = name;
        this.tabno = tabno;
        this.sex = sex;
        this.born = born;
        this.parent = parent;
    }

    public Child(String name, String tabno, char sex, LocalDate born) {
        this.name = name;
        this.tabno = tabno;
        this.sex = sex;
        this.born = born;
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

    public Employer getParent() {
        return parent;
    }

    public void setParent(Employer parent) {
        this.parent = parent;
    }

    public static String getTableName() {
        return "children";
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
