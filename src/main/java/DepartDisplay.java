import javax.swing.*;
import java.awt.*;

public class DepartDisplay extends JFrame {
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();

    public DepartDisplay(Depart department) {
        this.setTitle("Информация о департаменте");
        this.setSize(420, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 строки для отображения информации
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        // Шрифт, который используется для меток
        Font labelFont = new JLabel().getFont();

        formPanel.add(new JLabel("ID департамента:"));
        idField.setText(String.valueOf(department.getId()));
        idField.setFocusable(false); // Убираем возможность выделять текст
        idField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(idField);

        formPanel.add(new JLabel("Название департамента:"));
        nameField.setText(department.getName());
        nameField.setFocusable(false); // Убираем возможность выделять текст
        nameField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(nameField);

        // Устанавливаем поля только для чтения
        idField.setEditable(false);
        nameField.setEditable(false);

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }


}
