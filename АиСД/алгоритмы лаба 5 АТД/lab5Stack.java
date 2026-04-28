public class lab5Stack<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public lab5Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // положить элемент на вершину (LIFO)
    public void push(E item) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
    }

    // забрать элемент с вершины
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) throw new RuntimeException("stack is empty");
        E item = (E) elements[--size];
        elements[size] = null; // очищаем ссылку
        return item;
    }

    // посмотреть на вершину, не забирая
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) throw new RuntimeException("stack is empty");
        return (E) elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}