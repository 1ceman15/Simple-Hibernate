import jakarta.persistence.*;

import java.util.Date;


@IdClass(ChildPK.class)
@Entity(name = "children")
public class Child {
    @Id
    String name;
    @Id
    String tabno;
    char sex;
    Date born;
    @ManyToOne
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

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
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
