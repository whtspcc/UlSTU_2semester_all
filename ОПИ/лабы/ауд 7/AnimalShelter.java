import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalShelter {
    private ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(int index) {
        animals.remove(index);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public List<Animal> filterOlderThanFive() {
        return animals.stream().filter(a -> a.getAge() > 5).collect(Collectors.toList());
    }
}
