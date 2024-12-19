import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
        session.saveOrUpdate(entity);
        return entity;
    }

    public T update(Session session, T entity) {
        session.merge(entity);
        return entity;
    }

    public void deletebyId(Session session, T entity) {
        session.delete(entity);
    }
}
