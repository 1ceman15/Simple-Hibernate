import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartInput extends JFrame implements ActionListener {
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public DepartInput() {
        this.setTitle("Ввод данных департамента");
        this.setSize(420, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 строки для данных и кнопки
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        formPanel.add(new JLabel("ID департамента:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Название департамента:"));
        formPanel.add(nameField);

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
        // Логика обработки данных и сохранения
        String id = idField.getText();
        String name = nameField.getText();

        // Пример: вывод в консоль данных
        System.out.println("ID департамента: " + id);
        System.out.println("Название департамента: " + name);
    }

}
