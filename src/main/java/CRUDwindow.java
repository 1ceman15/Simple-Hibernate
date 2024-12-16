import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CRUDwindow extends JFrame implements ActionListener {
    private JButton insertButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    EmployerDAO dao;

    public CRUDwindow() {
        // Заголовок окна
        setTitle("CRUD Operations Window");
        dao = new EmployerDAO();

        // Размеры окна
        setSize(400, 250);
        setResizable(false); // Отключаем изменение размеров
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Центрирование окна

        // Создание надписи
        JLabel titleLabel = new JLabel("Выберите операцию", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(50, 50, 50));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Создание кнопок
        insertButton = new JButton("Insert");
        readButton = new JButton("Read");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        // Настройка кнопок
        styleButton(insertButton);
        styleButton(readButton);
        styleButton(updateButton);
        styleButton(deleteButton);

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10)); // 2x2 сетка с отступами
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Внешние отступы

        // Добавление кнопок на панель
        buttonPanel.add(insertButton);
        buttonPanel.add(readButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Добавление компонентов в окно
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH); // Надпись сверху
        add(buttonPanel, BorderLayout.CENTER); // Панель с кнопками

        setVisible(true);
    }

    // Метод для стилизации кнопок
    private void styleButton(JButton button) {
        button.addActionListener(this);
        button.setFocusPainted(false); // Убирает рамку фокуса
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(new Color(70, 130, 180)); // Цвет фона кнопки
        button.setForeground(Color.WHITE); // Цвет текста
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Внутренние отступы
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Курсор при наведении
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == readButton) {
            System.out.println(dao.read("110"));
        }
    }


}
