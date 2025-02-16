import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CRUDwindow extends JFrame implements ActionListener {
    private JButton insertButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;

    DataAccess dao;

    public CRUDwindow(DataAccess dao) {
        this.dao = dao;
        // Заголовок окна
        this.setTitle("CRUD Operations Window");

        // Размеры окна
        this.setSize(400, 250);
        this.setResizable(false); // Отключаем изменение размеров
        this.setLocationRelativeTo(null); // Центрирование окна

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
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH); // Надпись сверху
        this.add(buttonPanel, BorderLayout.CENTER); // Панель с кнопками
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setVisible(true);
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

        if(e.getSource() == deleteButton) {
            if(dao instanceof ChildDAO) {
                //TODO ОКНО ДЛЯ КЛЮЧА Child
            }else if(dao instanceof EmployerDAO) {
                IdInput window = new IdInput(this);
                String id =  window.getId();
                dao.deleteById(HibernateUtil.openSession(),id);
            }else {
                IdInput window = new IdInput(this);
            }
        }

        if(e.getSource() == insertButton || e.getSource() == updateButton){
            if(dao instanceof ChildDAO) {
                ChildInput window = new ChildInput(this);
            } else if (dao instanceof EmployerDAO) {
                EmployerInput window = new EmployerInput(this);
                Employer emp = window.getEmployer();
                dao.create(HibernateUtil.openSession(), emp);
            } else{
                DepartInput window = new DepartInput(this);
            }

        }

        if(e.getSource() == readButton) {
            if(dao instanceof ChildDAO) {
                //TODO ОКНО ДЛЯ КЛЮЧА Child
            }else if(dao instanceof EmployerDAO) {
                IdInput window = new IdInput(this);
                String id = window.getId();
                Employer employer = (Employer) dao.getById(HibernateUtil.openSession(), id);
                if(employer != null)
                    new EmployerDisplay(employer);
                else Errors.errorsFunction(new Exception("Такого сотрудника нет"));
            }else {
                IdInput window = new IdInput(this);
                int id = Integer.parseInt(window.getId());
                Depart department = (Depart) dao.getById(HibernateUtil.openSession(), id);
                if(department != null)
                    new DepartDisplay(department);
                else Errors.errorsFunction(new Exception("Такого департамента не существует"));
            }
        }

    }

}
