public class DepartDAO extends DataBaseDAO{
    public DepartDAO() {
        super();
    }
    @Override
    public Object read(String departId, Class<?> clazz) {
        return super.read(departId, Depart.class);
    }
}
