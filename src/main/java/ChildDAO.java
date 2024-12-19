public class ChildDAO extends DataBaseDAO{
    public ChildDAO() {
        super();
    }
    @Override
    public Object read(ChildPK childId, Class<?> clazz) {
        return session.get(Child.class, childId);
    }
}
