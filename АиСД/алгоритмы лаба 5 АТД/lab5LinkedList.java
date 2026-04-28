public class lab5LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    // добавление в конец
    public void add(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) first = newNode;
        else l.next = newNode;
        size++;
    }

    // получение по индексу
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> x = first;
        for (int i = 0; i < index; i++) x = x.next;
        return x.item;
    }

    public int size() { return size; }
}