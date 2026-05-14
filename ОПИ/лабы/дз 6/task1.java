import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class task1 {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Выберите текстовый файл");
        
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File inputFile = fileChooser.getSelectedFile();
            
            try {

                String content = Files.readString(inputFile.toPath());
                
                String normalizedText = content.trim().replaceAll("\\s+", " ");

                JTextArea textArea = new JTextArea(15, 50);
                textArea.setText(normalizedText);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                
                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane, "результат", JOptionPane.PLAIN_MESSAGE);
                
                String outputFileName = "new " + inputFile.getName();
                File outputFile = new File(inputFile.getParent(), outputFileName);
                
                try (FileWriter writer = new FileWriter(outputFile)) {
                    writer.write(normalizedText);
                }
                
                JOptionPane.showMessageDialog(null, "результат сохранен в файл:\n" + outputFile.getAbsolutePath());
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ошибка: " + e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}