import org.hibernate.Session;

public class Main {
    public static void main(String[] args){
        Session session = HibernateUtil.openSession();
        session.close();
        new TableWindow();
    }
}