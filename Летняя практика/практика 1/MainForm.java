import tasks.*;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    private int currentTask = 1;

    // Левая панель
    private JButton btnTask1;
    private JButton btnTask2;
    private JButton btnTask3;
    private JButton btnTask4;
    private JButton btnTask5;
    private JButton btnTask6;

    // Верхняя правая панель
    private JTextArea inputArea;

    private JTextField tfRows;
    private JTextField tfCols;
    private JTextField tfMin;
    private JTextField tfMax;

    private JButton btnGenerate1D;
    private JButton btnGenerate2D;

    // Средняя панель
    private JTextArea taskArea;

    // Нижняя панель
    private JTextArea resultArea;
    private JButton btnExecute;

    public MainForm() {

        setTitle("Практическая работа");
        setSize(1100,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {

        setLayout(new BorderLayout());

        // Левая панель

        JPanel leftPanel = new JPanel();

        leftPanel.setLayout(new GridLayout(6,1,5,5));
        leftPanel.setPreferredSize(new Dimension(180,0));

        btnTask1 = new JButton("Задание 1");
        btnTask2 = new JButton("Задание 2");
        btnTask3 = new JButton("Задание 3");
        btnTask4 = new JButton("Задание 4");
        btnTask5 = new JButton("Задание 5");
        btnTask6 = new JButton("Задание 6");

        leftPanel.add(btnTask1);
        leftPanel.add(btnTask2);
        leftPanel.add(btnTask3);
        leftPanel.add(btnTask4);
        leftPanel.add(btnTask5);
        leftPanel.add(btnTask6);

        add(leftPanel,BorderLayout.WEST);

        // Правая часть

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());

        add(rightPanel,BorderLayout.CENTER);

        // Верхняя панель

        JPanel topPanel = new JPanel(new BorderLayout());

        inputArea = new JTextArea(6,40);

        topPanel.add(new JScrollPane(inputArea),BorderLayout.CENTER);

        JPanel settings = new JPanel(new GridLayout(3,4));

        settings.add(new JLabel("Строк"));
        tfRows = new JTextField("10");
        settings.add(tfRows);

        settings.add(new JLabel("Столбцов"));
        tfCols = new JTextField("10");
        settings.add(tfCols);

        settings.add(new JLabel("Мин"));
        tfMin = new JTextField("-10");
        settings.add(tfMin);

        settings.add(new JLabel("Макс"));
        tfMax = new JTextField("10");
        settings.add(tfMax);

        btnGenerate1D = new JButton("1D");
        btnGenerate2D = new JButton("2D");

        settings.add(btnGenerate1D);
        settings.add(btnGenerate2D);

        topPanel.add(settings,BorderLayout.SOUTH);

        rightPanel.add(topPanel,BorderLayout.NORTH);

        // Центральная панель

        taskArea = new JTextArea();

        taskArea.setEditable(false);

        rightPanel.add(new JScrollPane(taskArea),BorderLayout.CENTER);

        // Нижняя панель

        JPanel bottomPanel = new JPanel(new BorderLayout());

        resultArea = new JTextArea(8,40);
        resultArea.setEditable(false);

        btnExecute = new JButton("Выполнить");

        bottomPanel.add(new JScrollPane(resultArea),BorderLayout.CENTER);
        bottomPanel.add(btnExecute,BorderLayout.SOUTH);

        rightPanel.add(bottomPanel,BorderLayout.SOUTH);

        // Обработчики

        btnTask1.addActionListener(e -> {
                currentTask = 1;
                taskArea.setText(Task1.Description);
                btnGenerate1D.setEnabled(true);
                btnGenerate2D.setEnabled(false);
        });

        btnTask2.addActionListener(e -> {
                currentTask = 2;
                taskArea.setText(Task2.Description);
                btnGenerate1D.setEnabled(true);
                btnGenerate2D.setEnabled(false);
        });

        btnTask3.addActionListener(e -> {
                currentTask = 3;
                taskArea.setText(Task3.Description); 
                btnGenerate1D.setEnabled(true);
                btnGenerate2D.setEnabled(false);
        });

        btnTask4.addActionListener(e -> {
                currentTask = 4;
                taskArea.setText(Task4.Description); 
                btnGenerate1D.setEnabled(true);
                btnGenerate2D.setEnabled(false);
        });

        btnTask5.addActionListener(e -> {
                currentTask = 5;
                taskArea.setText(Task5.Description); 
                btnGenerate1D.setEnabled(false);
                btnGenerate2D.setEnabled(true);
        });

        btnTask6.addActionListener(e -> {
                currentTask = 6;
                taskArea.setText(Task6.Description); 
                btnGenerate1D.setEnabled(false);
                btnGenerate2D.setEnabled(true);
        });

        btnGenerate1D.addActionListener(e -> {

            int size = Integer.parseInt(tfRows.getText());
            int min = Integer.parseInt(tfMin.getText());
            int max = Integer.parseInt(tfMax.getText());

            int[] array = ArrayGenerator.generate1D(size, min, max);

            StringBuilder sb = new StringBuilder();

            for (int value : array) {
                sb.append(value).append(" ");
            }

            inputArea.setText(sb.toString());

        });

        btnGenerate2D.addActionListener(e -> {

            int rows = Integer.parseInt(tfRows.getText());
            int cols = Integer.parseInt(tfCols.getText());

            int min = Integer.parseInt(tfMin.getText());
            int max = Integer.parseInt(tfMax.getText());

            int[][] array = ArrayGenerator.generate2D(rows, cols, min, max);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < cols; j++) {
                    sb.append(array[i][j]).append(" ");
                }

                sb.append("\n");
            }

            inputArea.setText(sb.toString());

        });
        
        btnExecute.addActionListener(e -> {
            String result;

            switch (currentTask) {
                case 1: 
                    result = Task1.execute(ArrayParser.parse1D(inputArea.getText()));
                    break;
                
                case 2:
                    result = Task2.execute(ArrayParser.parse1D(inputArea.getText()));
                    break;

                case 3:
                    result = Task3.execute(ArrayParser.parse1D(inputArea.getText()));
                    break;

                case 4:
                    result = Task4.execute(ArrayParser.parse1D(inputArea.getText()));
                    break;

                case 5:
                    int[][] matrix5 = ArrayParser.parse2D(inputArea.getText());

                    int rows5 = Integer.parseInt(tfRows.getText());
                    int cols5 = Integer.parseInt(tfCols.getText());

                    result = Task5.execute(matrix5, rows5, cols5);
                    break;

                case 6:
                    int[][] matrix6 = ArrayParser.parse2D(inputArea.getText());

                    int rows6 = Integer.parseInt(tfRows.getText());
                    int cols6 = Integer.parseInt(tfCols.getText());

                    result = Task6.execute(matrix6, rows6, cols6);
                    break;

                default:
                    result = "Выберите задание";
            }
            
            resultArea.setText(result);
        });
    }
}