import javax.swing.*;
import java.awt.*;

public class EmployerDisplay extends JFrame {
    private JTextField tabnoField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField postField = new JTextField();
    private JTextField salaryField = new JTextField();
    private JTextField bornField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField departmentField = new JTextField();

    public EmployerDisplay(Employer employer) {
        this.setTitle("Информация о сотруднике");
        this.setSize(420, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10)); // 8 строк для отображения информации
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        // Шрифт, который используется для меток
        Font labelFont = new JLabel().getFont();

        formPanel.add(new JLabel("Табельный номер:"));
        tabnoField.setText(employer.getTabno());
        tabnoField.setFocusable(false); // Убираем возможность выделять текст
        tabnoField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(tabnoField);

        formPanel.add(new JLabel("Имя:"));
        nameField.setText(employer.getName());
        nameField.setFocusable(false); // Убираем возможность выделять текст
        nameField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(nameField);

        formPanel.add(new JLabel("Должность:"));
        postField.setText(employer.getPost());
        postField.setFocusable(false); // Убираем возможность выделять текст
        postField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(postField);

        formPanel.add(new JLabel("Зарплата:"));
        salaryField.setText(String.valueOf(employer.getSalary()));
        salaryField.setFocusable(false); // Убираем возможность выделять текст
        salaryField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(salaryField);

        formPanel.add(new JLabel("Дата рождения (YYYY-MM-DD):"));
        bornField.setText(employer.getBorn().toString());
        bornField.setFocusable(false); // Убираем возможность выделять текст
        bornField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(bornField);

        formPanel.add(new JLabel("Телефон:"));
        phoneField.setText(employer.getPhone());
        phoneField.setFocusable(false); // Убираем возможность выделять текст
        phoneField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(phoneField);

        formPanel.add(new JLabel("Код департамента:"));
        departmentField.setText(employer.getDepartment().getName());
        departmentField.setFocusable(false); // Убираем возможность выделять текст
        departmentField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(departmentField);

        // Устанавливаем поля только для чтения
        tabnoField.setEditable(false);
        nameField.setEditable(false);
        postField.setEditable(false);
        salaryField.setEditable(false);
        bornField.setEditable(false);
        phoneField.setEditable(false);
        departmentField.setEditable(false);

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
