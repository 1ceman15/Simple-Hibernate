import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class DataBaseDAO<T, ID> {
    private Class<T> clazz;

    public DataBaseDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getById(Session session,ID id) {
        return session.get(clazz, id);
    }

    public List<T> getAll(Session session) {
        return  session.createQuery("from " + clazz.getName(), clazz).list();
    }

    public T create(Session session, T entity) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(entity);
            tx.commit();
        }catch (Exception e) {
            if (tx != null) tx.rollback();
            Errors.errorsFunction(e);
        }
        return entity;
    }

    public T update(Session session, T entity) {
        Transaction tx = null;
        try {
            session.merge(entity);
        }catch (Exception e) {
            if (tx != null) tx.rollback();
            Errors.errorsFunction(e);
        }
        return entity;
    }

    public void deleteById(Session session, T id) {
        Transaction tx = null;
        try {
            Object entity = session.get(clazz, id);
            session.delete(entity);
            tx.commit();
        }catch (Exception e) {
            if (tx != null) tx.rollback();
            Errors.errorsFunction(e);
        }
    }

}
