import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "emp")
public class Employer {
    @Id
    String tabno;
    String name;
    String post;
    float salary;
    Date born;
    String phone;
    int depno;
    @ManyToOne
    Depart department;
    @OneToMany(mappedBy = "parent")
    List<Child> children;


    public Employer(String tabno, String name, String post, float salary, Date born, String phone, int depno) {
        this.children = new ArrayList<>();
        this.tabno = tabno;
        this.name = name;
        this.post = post;
        this.salary = salary;
        this.born = born;
        this.phone = phone;
        this.depno = depno;
    }

    public Employer() {
        this.children = new ArrayList<>();
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Depart getDepartment() {
        return department;
    }

    public void setDepartment(Depart department) {
        this.department = department;
    }

    public String getTabno() {
        return tabno;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getPost() {
        return post;
    }

    public Date getBorn() {
        return born;
    }

    public String getPhone() {
        return phone;
    }

    public int getDepno() {
        return depno;
    }

    public void setTabno(String tabno) {
        this.tabno = tabno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepno(int depno) {
        this.depno = depno;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "tabno='" + tabno + '\'' +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", born=" + born +
                ", phone='" + phone + '\'' +
                ", depno=" + depno +
                ", department=" + department +
                ", children=" + children +
                '}';
    }
}