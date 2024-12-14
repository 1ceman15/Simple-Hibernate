import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Employer emp = (Employer) session.get(Employer.class,  "23");
        System.out.println(emp);
        Depart dep = (Depart) session.get(Depart.class,  1);
        System.out.println(dep);
        Child child = (Child) session.get(Child.class, new ChildPK("Вадим" ,"988"));
        System.out.println(child);
    }
}