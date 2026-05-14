import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Stack;

public class task3 {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите файл для проверки скобок");
        
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File inputFile = fileChooser.getSelectedFile();
            
            try {
                String content = Files.readString(inputFile.toPath());

                String resultValue = checkBrackets(content);

                String displayMessage = "Исходный текст:\n" + content + "\n\nРезультат: " + resultValue;
                JTextArea textArea = new JTextArea(10, 40);
                textArea.setText(displayMessage);
                textArea.setEditable(false);
                
                JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Проверка скобок", JOptionPane.INFORMATION_MESSAGE);

                File outputFile = new File(inputFile.getParent(), "bracket_result.txt");
                try (FileWriter writer = new FileWriter(outputFile)) {
                    writer.write("Текст: " + content + "\r\n");
                    writer.write("Результат: " + resultValue);
                }
                
                JOptionPane.showMessageDialog(null, "Результат сохранен в:\n" + outputFile.getName());
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ошибка чтения: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String checkBrackets(String input) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == '(') {
                stack.push(i + 1);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return String.valueOf(i + 1);
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return "-1";
        }

        return "0";
    }
}