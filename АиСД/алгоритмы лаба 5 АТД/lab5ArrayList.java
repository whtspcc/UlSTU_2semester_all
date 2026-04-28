import java.util.Arrays;

public class lab5ArrayList<E> {
    // начальная емкость по умолчанию
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public lab5ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    // добавлениие
    public void add(E element) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = element;
    }

    // получение по индексу
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E) elements[index];
    }

    // удаление по индексу
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // копируем элементы влево, перетирая удаленный
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    // логика расширения массива
    private void grow() {
        // увеличиваем размер в 1.5 раза
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity / 2);  // либо битовый сдвиг ( деление на 2 )
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int size() {
        return size;
    }
}