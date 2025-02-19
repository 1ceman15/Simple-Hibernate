import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChildInput extends JDialog implements ActionListener {
    private Child child;
    private JTextField nameField = new JTextField();
    private JTextField tabnoField = new JTextField();
    private JTextField sexField = new JTextField();
    private JTextField bornField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public ChildInput(Frame owner) {
        super(owner, "Ввод данных ребенка", true);
        this.setSize(420, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // 5 строк для данных и кнопки
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        formPanel.add(new JLabel("Имя ребенка:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Табельный номер:"));
        formPanel.add(tabnoField);

        formPanel.add(new JLabel("Пол (м/ж):"));
        formPanel.add(sexField);

        formPanel.add(new JLabel("Дата рождения (YYYY-MM-DD):"));
        formPanel.add(bornField);

        // Пустая строка для выравнивания кнопки по центру
        formPanel.add(new JLabel());
        formPanel.add(submitButton); // Кнопка в последнюю ячейку

        // Стилизация кнопки
        submitButton.setBackground(new Color(0xFDFDFD)); // Стандартный цвет фона
        submitButton.setForeground(Color.BLACK); // Черный цвет текста
        submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        submitButton.addActionListener(this);

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void toChild() {
        // Извлекаем значения из полей формы
        String name = nameField.getText();
        String tabno = tabnoField.getText();
        char sex = sexField.getText().toLowerCase().charAt(0); // Преобразуем в верхний регистр
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate born = LocalDate.parse(bornField.getText(), formatter); // Преобразуем строку в LocalDate


        this.child = new Child(name, tabno, sex, born);

    }

    public Child getChild() {
        return child;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            toChild();
            this.dispose();
        }
    }
}
