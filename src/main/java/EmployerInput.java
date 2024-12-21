import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployerInput extends JFrame implements ActionListener {
    private JTextField tabnoField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField postField = new JTextField();
    private JTextField salaryField = new JTextField();
    private JTextField bornField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField departmentField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public EmployerInput() {
        this.setTitle("Ввод данных сотрудника");
        this.setSize(420, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
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
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }



}
