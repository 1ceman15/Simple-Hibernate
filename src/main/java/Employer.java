import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "emp")
public class Employer {
    @Id
    String tabno;
    String name;
    String post;
    float salary;
    LocalDate born;
    String phone;
    @ManyToOne()
    @JoinColumn(name = "depno")
    Depart department;
    @OneToMany(mappedBy = "parent")
    List<Child> children;


    public Employer(String tabno, String name, String post, float salary, LocalDate born, String phone) {
        this.children = new ArrayList<>();
        this.tabno = tabno;
        this.name = name;
        this.post = post;
        this.salary = salary;
        this.born = born;
        this.phone = phone;
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

    public LocalDate getBorn() {
        return born;
    }

    public String getPhone() {
        return phone;
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

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static String getTableName() {
        return "emp";
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
                ", department=" + department.name +
                ", children=" + children +
                '}';
    }
}