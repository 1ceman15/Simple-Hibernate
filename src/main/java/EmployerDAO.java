import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployerDAO {
    private Employer employer;
    private Configuration con;
    private SessionFactory sf;
    private Session session;

    public EmployerDAO() {

        con = new Configuration().configure();
        sf = con.buildSessionFactory();
        session = sf.openSession();
    }

    public Employer read(String employerId) {
        return session.get(Employer.class, employerId);
    }
}
