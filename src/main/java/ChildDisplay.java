import javax.swing.*;
import java.awt.*;

public class ChildDisplay extends JFrame {
    private JTextField nameField = new JTextField();
    private JTextField tabnoField = new JTextField();
    private JTextField sexField = new JTextField();
    private JTextField bornField = new JTextField();
    private JTextField parentNameField = new JTextField();

    public ChildDisplay(Child child) {
        this.setTitle("Информация о ребенке");
        this.setSize(420, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 строк для отображения информации
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        // Шрифт, который используется для меток
        Font labelFont = new JLabel().getFont();

        formPanel.add(new JLabel("Имя ребенка:"));
        nameField.setText(child.getName());
        nameField.setFocusable(false); // Убираем возможность выделять текст
        nameField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(nameField);

        formPanel.add(new JLabel("Табельный номер:"));
        tabnoField.setText(child.getTabno());
        tabnoField.setFocusable(false); // Убираем возможность выделять текст
        tabnoField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(tabnoField);

        formPanel.add(new JLabel("Пол:"));
        sexField.setText(String.valueOf(child.getSex()));
        sexField.setFocusable(false); // Убираем возможность выделять текст
        sexField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(sexField);

        formPanel.add(new JLabel("Дата рождения (YYYY-MM-DD):"));
        bornField.setText(child.getBorn().toString());
        bornField.setFocusable(false); // Убираем возможность выделять текст
        bornField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(bornField);

        formPanel.add(new JLabel("Родитель (Имя):"));
        parentNameField.setText(child.getParent().getName());
        parentNameField.setFocusable(false); // Убираем возможность выделять текст
        parentNameField.setFont(labelFont); // Устанавливаем тот же шрифт
        formPanel.add(parentNameField);

        // Устанавливаем поля только для чтения
        nameField.setEditable(false);
        tabnoField.setEditable(false);
        sexField.setEditable(false);
        bornField.setEditable(false);
        parentNameField.setEditable(false);

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }


}
