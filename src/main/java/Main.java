public class Main {
    public static void main(String[] args) {
            DataBaseDAO dao = new EmployerDAO();
            Employer emp = (Employer) dao.getById(HibernateUtil.openSession(), "110");
            EmployerDisplay empDisplay = new EmployerDisplay(emp);

    }
}