import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws Exception{
        DataAccess dao = new EmployerDAO();
        DataAccess dataAccess = new DepartDAO();
        Depart department = new Depart();
        department.setId(2);
        Session session = HibernateUtil.openSession();

        //department = (Depart) dataAccess.getById(session,"2");
        department = (Depart) dataAccess.getById(session,department.id);
        System.out.println(session.contains(department));
        System.out.println(department);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Создание emp");
        Employer emp = new Employer("555", "Имя", "Должность", 45000.0,
                LocalDate.parse("11-02-1990", formatter), "111111111",department);

        System.out.println("Создан");
        emp.setDepartment(department);
        System.out.println(emp);
        System.out.println(department);

        System.out.println(session.contains(department));


        dao.create(session, emp);
        dao.deleteById(session, emp.tabno);
        //System.out.println(dao.getById(session, "23"));






    }
}