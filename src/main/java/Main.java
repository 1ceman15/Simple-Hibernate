import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBaseDAO dao = new EmployerDAO();
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Employer emp = (Employer) dao.getById(sessionFactory.openSession(), "110");
        System.out.println(emp);
        List<Employer> employers = dao.getAll(sessionFactory.openSession());
        System.out.println(employers);
        dao = new ChildDAO();
        Child child = (Child) dao.getById(sessionFactory.openSession(), new ChildPK("Вадим", "988"));
        System.out.println(child);
    }
}