import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private AnimalShelter shelter = new AnimalShelter();

    private DefaultListModel<Animal> listModel = new DefaultListModel<>();
    private JList<Animal> animalJList = new JList<>(listModel);

    private JTextField nameField = new JTextField(15);
    private JTextField speciesField = new JTextField(15);
    private JTextField ageField = new JTextField(5);

    public MainFrame() {
        setTitle("Животные");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(new JScrollPane(animalJList), BorderLayout.WEST);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        panel.add(new JLabel("Имя"));
        panel.add(nameField);

        panel.add(new JLabel("Вид"));
        panel.add(speciesField);

        panel.add(new JLabel("Возраст"));
        panel.add(ageField);

        JButton addButton = new JButton("Добавить");
        JButton deleteButton = new JButton("Удалить");
        JButton editButton = new JButton("Редактировать");
        JButton filterButton = new JButton("Старше 5 лет");

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(editButton);
        panel.add(filterButton);

        add(panel, BorderLayout.CENTER);

        addButton.addActionListener(e -> addAnimal());

        deleteButton.addActionListener(e -> deleteAnimal());

        editButton.addActionListener(e -> editAnimal());

        filterButton.addActionListener(e -> filterAnimals());

        animalJList.addListSelectionListener(e -> showSelectedAnimal());

        setVisible(true);
    }

    private void addAnimal() {
        try {
            String name = nameField.getText();
            String species = speciesField.getText();
            int age = Integer.parseInt(ageField.getText());

            Animal animal = new Animal(name, species, age);

            shelter.addAnimal(animal);
            listModel.addElement(animal);

            clearFields();

        } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Возраст должен быть числом!");
    }
    }

    private void deleteAnimal() {
        int index = animalJList.getSelectedIndex();

        if (index >= 0) {
            shelter.removeAnimal(index);
            listModel.remove(index);
        } else {
            JOptionPane.showMessageDialog(this,"Выберите объект!");
        }
    }

    private void editAnimal() {
        int index = animalJList.getSelectedIndex();

        if (index >= 0) {
            try {
                Animal animal = shelter.getAnimals().get(index);

                animal.setName(nameField.getText());
                animal.setSpecies(speciesField.getText());
                animal.setAge(Integer.parseInt(ageField.getText()));

                animalJList.repaint();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Возраст должен быть числом!");
            }
        }
    }

    private void showSelectedAnimal() {
        Animal animal = animalJList.getSelectedValue();

        if (animal != null) {
            nameField.setText(animal.getName());
            speciesField.setText(animal.getSpecies());
            ageField.setText(String.valueOf(animal.getAge()));
        }
    }

    private void filterAnimals() {
        List<Animal> filtered = shelter.filterOlderThanFive();

        StringBuilder builder = new StringBuilder();

        for (Animal a : filtered) {
            builder.append(a.getName()).append(" - ").append(a.getAge()).append(" лет\n");
        }

        JOptionPane.showMessageDialog(this, builder.length() == 0 ? "Нет животных старше 5 лет" : builder.toString());
    }

    private void clearFields() {
        nameField.setText("");
        speciesField.setText("");
        ageField.setText("");
    }
}
