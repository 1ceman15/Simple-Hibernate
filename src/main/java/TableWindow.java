import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableWindow extends JFrame implements ActionListener {

    // Создаем кнопки
    JButton employerButton = new JButton("Employer");
    JButton departmentButton = new JButton("Department");
    JButton childButton = new JButton("Child");

    public TableWindow() {
        // Устанавливаем заголовок окна
        setTitle("Выбор таблицы для взаимодействия");
        setSize(500, 250); // размеры окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // центрируем окно на экране

        // Основная панель с layout-ом
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10)); // отступы

        // Добавляем надпись с красивым шрифтом
        JLabel titleLabel = new JLabel("С какой таблицей вы хотите взаимодействовать?", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(50, 50, 150)); // Цвет текста

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 20, 0)); // 1 строка, 3 столбца, отступ 20px между кнопками
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); // Пустая граница вокруг панели кнопок

        // Стилизация кнопок
        styleButton(employerButton);
        styleButton(departmentButton);
        styleButton(childButton);

        // Добавляем кнопки на панель
        buttonPanel.add(employerButton);
        buttonPanel.add(departmentButton);
        buttonPanel.add(childButton);

        // Добавляем компоненты на основную панель
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Добавляем основную панель на окно
        add(mainPanel);
        this.setResizable(false);
        this.setVisible(true);
    }

    // Метод для стилизации кнопок
    private void styleButton(JButton button) {
        button.addActionListener(this);
        button.setFocusPainted(false); // Убирает рамку фокуса
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(new Color(70, 130, 180)); // Цвет фона кнопки
        button.setForeground(Color.WHITE); // Цвет текста
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Внутренние отступы кнопки
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Курсор при наведении
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == employerButton) {
            new CRUDwindow(new EmployerDAO());
        }
        if(e.getSource() == departmentButton) {
            new CRUDwindow(new DepartDAO());
        }
        if(e.getSource() == childButton) {
            new CRUDwindow(new ChildDAO());
        }
    }

    public static void main(String[] args) {
        new TableWindow();

    }

}
