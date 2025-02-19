import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartInput extends JDialog implements ActionListener {
    private Depart depart = new Depart();
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public DepartInput(Frame owner) {
        super(owner,"Ввод данных департамента",true);
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
        submitButton.addActionListener(this);
        setVisible(true);
    }

    private void toDepart() {
        int id = Integer.parseInt(idField.getText());  // Преобразуем ID в int
        String name = nameField.getText();  // Получаем название департамента
        this.depart = new Depart(id, name);
    }

    public Depart getDepart() {
        return depart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton) {
            toDepart();
            this.dispose();
        }
    }

}
