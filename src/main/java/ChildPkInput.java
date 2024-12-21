import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChildPkInput extends JFrame implements ActionListener {
    private ChildPK pk;
    private JTextField nameField = new JTextField();
    private JTextField tabnoField = new JTextField();
    private JButton submitButton = new JButton("Отправить");

    public ChildPkInput() {
        this.setTitle("Ввод данных ребенка");
        this.setSize(320, 230); // Уменьшаем размер окна
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null); // Центрируем окно
        this.setLayout(new BorderLayout());

        // Основная панель
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Панель формы
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3 строки для данных и кнопки
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(new Color(116, 158, 200)); // Цвет фона формы

        formPanel.add(new JLabel("Имя ребенка:"));
        nameField.setPreferredSize(new Dimension(150, 25)); // Уменьшаем размер текстового поля
        formPanel.add(nameField);

        formPanel.add(new JLabel("Табельный номер:"));
        tabnoField.setPreferredSize(new Dimension(150, 25)); // Уменьшаем размер текстового поля
        formPanel.add(tabnoField);

        // Пустая строка для выравнивания кнопки по центру
        formPanel.add(new JLabel());
        submitButton.setPreferredSize(new Dimension(120, 30)); // Уменьшаем размер кнопки
        formPanel.add(submitButton); // Кнопка в последнюю ячейку

        // Стилизация кнопки
        submitButton.setBackground(new Color(0xFDFDFD)); // Стандартный цвет фона
        submitButton.setForeground(Color.BLACK); // Черный цвет текста
        submitButton.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // Уменьшаем шрифт кнопки

        // Добавляем панель с формой в основную панель
        mainPanel.add(formPanel, BorderLayout.CENTER);

        this.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void toChildPK(){
        this.pk = new ChildPK(nameField.getText(), tabnoField.getText());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitButton){
            toChildPK();
        }
    }
}
