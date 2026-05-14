import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class task2 {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("выберите файл для шифрования");
        
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File inputFile = fileChooser.getSelectedFile();
            
            try {
                String content = Files.readString(inputFile.toPath());

                String encryptedText = encrypt(content);

                JTextArea textArea = new JTextArea(15, 50);
                textArea.setText(encryptedText);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                
                JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "результат шифрования", JOptionPane.PLAIN_MESSAGE);
                
                String outputFileName = "encrypted " + inputFile.getName();
                File outputFile = new File(inputFile.getParent(), outputFileName);
                
                try (FileWriter writer = new FileWriter(outputFile)) {
                    writer.write(encryptedText);
                }
                
                JOptionPane.showMessageDialog(null, "файл сохранен:\n" + outputFileName);
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ошибка: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        String up = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String low = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        
        for (char c : text.toCharArray()) {
            if (up.indexOf(c) != -1) {
                int nextIdx = (up.indexOf(c) + 1) % up.length();
                result.append(up.charAt(nextIdx));
            } else if (low.indexOf(c) != -1) {
                int nextIdx = (low.indexOf(c) + 1) % low.length();
                result.append(low.charAt(nextIdx));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}