import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Task1.Bed;
import Task2.*;
import Task2.Shape;
import Task3.Calculator;

public class MainForm extends JFrame {

    // Список для хранения созданных объектов кроватей
    private ArrayList<Bed> bedList = new ArrayList<>();
    
    // Элементы интерфейса для Вкладки 1 (Инкапсуляция)
    private JTextField txtMaterial;
    private JTextField txtWidth;
    private JTextField txtLength;
    private JTextField txtColor;
    private JCheckBox chkHasStorage;
    private DefaultListModel<String> listModel;
    private JList<String> listBox;

    // Элементы интерфейса для Вкладки 2 (Наследование)
    private ArrayList<Shape> shapeList = new ArrayList<>();
    private Canvas canvas;
    private JTextField txtSize;
    private JButton btnCircle;
    private JButton btnRectangle;
    private JButton btnDraw;

    // Элементы интерфейса для Вкладки 3 (Полиморфизм)
    private JTextField txtFirst;
    private JTextField txtSecond;
    private JComboBox<String> cmbType;
    private JLabel lblResult;

    public MainForm() {
        // настройка окна
        setTitle("Практическая работа №2 - ООП");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTabbedPane tabControl = new JTabbedPane();

        // 3 вкладки на форму
        tabControl.addTab("Задание 1 (Инкапсуляция)", createFirstTab());
        tabControl.addTab("Задание 2 (Наследование)", createSecondTab());
        tabControl.addTab("Задание 3 (Полиморфизм)", createThirdTab());

        add(tabControl);

        setVisible(true);
    }

    // Вкладка 1: Инкапсуляция
    private JPanel createFirstTab() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // панель для ввода данны
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        
        inputPanel.add(new JLabel("Материал:"));
        txtMaterial = new JTextField();
        inputPanel.add(txtMaterial);

        inputPanel.add(new JLabel("Ширина (см):"));
        txtWidth = new JTextField();
        inputPanel.add(txtWidth);

        inputPanel.add(new JLabel("Длина (см):"));
        txtLength = new JTextField();
        inputPanel.add(txtLength);

        inputPanel.add(new JLabel("Цвет:"));
        txtColor = new JTextField();
        inputPanel.add(txtColor);

        inputPanel.add(new JLabel("Двуспальная:"));
        chkHasStorage = new JCheckBox("");
        inputPanel.add(chkHasStorage);

        JButton btnCreate = new JButton("Создать объект");
        inputPanel.add(btnCreate);

        JButton btnShowList = new JButton("Вывести список");
        inputPanel.add(btnShowList);

        panel.add(inputPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        listBox = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listBox);
        panel.add(scrollPane, BorderLayout.CENTER);

        // "создать объект"
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(txtWidth.getText().trim().isEmpty() || txtLength.getText().trim().isEmpty()) {
                        throw new NumberFormatException();
                    }

                    // считываем данные из интерфейса
                    String material = txtMaterial.getText();
                    int width = Integer.parseInt(txtWidth.getText().trim());
                    int length = Integer.parseInt(txtLength.getText().trim());
                    String color = txtColor.getText();
                    boolean hasStorage = chkHasStorage.isSelected();

                    // создаем объект bed с введенными пользователем параметрами
                    Bed bed = new Bed(width, length, material, color, hasStorage);

                    // успешно добавляем в список
                    bedList.add(bed);
                    JOptionPane.showMessageDialog(MainForm.this, "Объект успешно добавлен в список!");

                    txtMaterial.setText("");
                    txtWidth.setText("");
                    txtLength.setText("");
                    txtColor.setText("");
                    chkHasStorage.setSelected(false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainForm.this, 
                            "Ошибка ввода: Поля 'Ширина' и 'Длина' должны содержать целые числа!", 
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(MainForm.this, 
                            ex.getMessage(), 
                            "Ошибка валидации", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Нажатие кнопки "Вывести список"
        btnShowList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
                
                if (bedList.isEmpty()) {
                    JOptionPane.showMessageDialog(MainForm.this, "Список объектов пуст!");
                    return;
                }

                // Заполняем ListBox текстовым представлением объектов через toString()
                for (Bed b : bedList) {
                    listModel.addElement(b.toString());
                }
            }
        });

        return panel;
    }

    // Вкладка 2: Наследование
    private JPanel createSecondTab() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Размер:"));

        txtSize = new JTextField(5);
        topPanel.add(txtSize);

        btnCircle = new JButton("Создать круг");
        btnRectangle = new JButton("Создать прямоугольник");
        btnDraw = new JButton("Нарисовать");

        topPanel.add(btnCircle);
        topPanel.add(btnRectangle);
        topPanel.add(btnDraw);

        panel.add(topPanel, BorderLayout.NORTH);

        canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for (Shape s : shapeList) {
                    int x = (int)(Math.random() * 300);
                    int y = (int)(Math.random() * 250);
                    s.draw(x, y, this);
                }
            }
        };

        canvas.setBackground(Color.WHITE);
        panel.add(canvas, BorderLayout.CENTER);

        btnCircle.addActionListener(e -> {
            try {
                int size = Integer.parseInt(txtSize.getText());
                shapeList.add(new Circle(size, Color.RED));
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Введите размер");
            }
        });

        btnRectangle.addActionListener(e -> {
            try {
                int size = Integer.parseInt(txtSize.getText());
                shapeList.add(new FilledRectangle(size, size, Color.BLUE));
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Введите размер");
            }
        });

        btnDraw.addActionListener(e -> {
            canvas.repaint();
        });

        return panel;
    }

    // Вкладка 3: Полиморфизм
    private JPanel createThirdTab() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        panel.add(new JLabel("Первое число:"));
        txtFirst = new JTextField();
        panel.add(txtFirst);

        panel.add(new JLabel("Второе число:"));
        txtSecond = new JTextField();
        panel.add(txtSecond);

        panel.add(new JLabel("Тип данных:"));

        cmbType = new JComboBox<>();
        cmbType.addItem("Integer");
        cmbType.addItem("Double");
        panel.add(cmbType);

        JButton btnCalc = new JButton("Разделить");
        panel.add(btnCalc);

        lblResult = new JLabel("Результат:");
        panel.add(lblResult);

        btnCalc.addActionListener(e -> {
            try {
                String type = (String) cmbType.getSelectedItem();

                if ("Integer".equals(type)) {
                    Calculator<Integer> calc = new Calculator<>();

                    int a = Integer.parseInt(txtFirst.getText());
                    int b = Integer.parseInt(txtSecond.getText());
                    double result = calc.divide(a, b);

                    lblResult.setText("Результат: " + result);

                } else {
                    Calculator<Double> calc = new Calculator<>();

                    double a = Double.parseDouble(txtFirst.getText());
                    double b = Double.parseDouble(txtSecond.getText());
                    double result = calc.divide(a, b);

                    lblResult.setText("Результат: " + result);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Некорректный ввод чисел!");
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        return panel;
    }
}