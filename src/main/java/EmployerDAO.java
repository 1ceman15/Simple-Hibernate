public class EmployerDAO extends DataBaseDAO {
    public EmployerDAO() {
        super();
    }
    @Override
    public Object read(String employerId, Class<?> clazz) {
        return super.read(employerId, Employer.class);
    }
}
