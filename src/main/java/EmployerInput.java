import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployerInput extends JDialog implements ActionListener {
    private Employer emp;
    private JTextField tabnoField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField postField = new JTextField();
    private JTextField salaryField = new JTextField();
    private JTextField bornField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField departmentField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public EmployerInput(Frame owner) {
        super(owner, "Ввод данных сотрудника", true); // true делает окно модальным
        this.setSize(420, 400);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(owner); // Центрируем окно относительно родительского окна
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(9, 2, 10, 10)); // Увеличено на 1 строку для кнопки
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        formPanel.add(new JLabel("Табельный номер:"));
        formPanel.add(tabnoField);

        formPanel.add(new JLabel("Имя:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Должность:"));
        formPanel.add(postField);

        formPanel.add(new JLabel("Зарплата:"));
        formPanel.add(salaryField);

        formPanel.add(new JLabel("Дата рождения (YYYY-MM-DD):"));
        formPanel.add(bornField);

        formPanel.add(new JLabel("Телефон:"));
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Код департамента:"));
        formPanel.add(departmentField);

        // Пустая строка для выравнивания кнопки по центру
        formPanel.add(new JLabel());
        formPanel.add(submitButton); // Кнопка в последнюю ячейку

        // Стилизация кнопки
        submitButton.setBackground(new Color(0xFDFDFD)); // Стандартный цвет фона
        submitButton.setForeground(Color.BLACK); // Черный цвет текста
        submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);

        submitButton.addActionListener(this);
        setVisible(true);
    }

    private void toEmployer() {
        // Извлекаем значения из полей формы
        String tabno = tabnoField.getText();
        String name = nameField.getText();
        String post = postField.getText();
        double salary = Double.parseDouble(salaryField.getText()); // Преобразуем строку в число
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate born = LocalDate.parse(bornField.getText(),formatter); // Здесь может быть преобразование в LocalDate, если нужно
        String phone = phoneField.getText();
        int departId = Integer.parseInt(departmentField.getText());

        DataAccess dao = new DepartDAO();

        Depart department = (Depart) dao.getById(HibernateUtil.openSession(),departId);
        if(department == null){
            throw new IllegalStateException("Такого номера депортамента нет");
        }

        // Создаем объект Employer, передавая значения
        emp = new Employer(tabno, name, post, salary, born, phone, department);
    }

    public Employer getEmployer() {
        return emp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            toEmployer();
            this.dispose(); // Закрываем окно после отправки данных
        }
    }

    // Метод для использования модального окна и получения данных от пользователя
    public static Employer getEmployerFromUser(JFrame parent) {
        EmployerInput inputDialog = new EmployerInput(parent); // Создаем модальное окно
        return inputDialog.getEmployer(); // Получаем введенные данные
    }
}
