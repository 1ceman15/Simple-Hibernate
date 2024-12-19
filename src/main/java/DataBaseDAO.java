import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class DataBaseDAO {
    protected Configuration con;
    protected SessionFactory sf;
    protected Session session;

    public DataBaseDAO() {
        con = new Configuration().configure();
        sf = con.buildSessionFactory();
        session = sf.openSession();
    }

    public Object read(String Id, Class<?> clazz) {
        return session.get(clazz, Id);
    }

    public Object read(ChildPK Id, Class<?> clazz) {
        return session.get(clazz, Id);
    }
}
