import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IdInput extends JDialog implements ActionListener {
    String id;
    private JTextField idField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public IdInput(Frame owner) {
        super(owner, "Ввод id", true);
        this.setSize(320, 180); // Уменьшаем размер окна
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 строки для данных и кнопки
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        formPanel.add(new JLabel("ID:"));
        idField.setPreferredSize(new Dimension(150, 25)); // Уменьшаем размер текстового поля
        formPanel.add(idField);

        // Пустая строка для выравнивания кнопки по центру
        formPanel.add(new JLabel());
        submitButton.setPreferredSize(new Dimension(120, 30)); // Уменьшаем размер кнопки
        formPanel.add(submitButton); // Кнопка в последнюю ячейку

        // Стилизация кнопки
        submitButton.setBackground(new Color(0xFDFDFD)); // Стандартный цвет фона
        submitButton.setForeground(Color.BLACK); // Черный цвет текста
        submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Уменьшаем шрифт кнопки
        submitButton.addActionListener(this);

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public String getId() {
        return id;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            this.id = idField.getText();
            this.dispose();
        }
    }
}
