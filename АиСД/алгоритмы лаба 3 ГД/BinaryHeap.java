public class BinaryHeap { // max-heap - родитель > ребенка
    private Node[] heapArray; //  массив с вершинами
    private int maxSize; // размер массива
    private int currentSize; // количество узлов массива

    // создание пустой кучи
    public BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new Node[maxSize];
    }

    // вставка нового значения
    public boolean insertNode(int value) {
        // проверяем не выходим ли за рамки массива
        if (currentSize == maxSize) {
            return false;
        }
        
        Node newNode = new Node(value); // создаем вершин
        heapArray[currentSize] = newNode; // вершину задаем в самый низ дерева
        displaceUp(currentSize++); // поднимаем вершину
        return true;
    }

    // удалить элемент по индексу
    public Node removeNode(int index) {
        if (index > 0 && currentSize > index) {
            // узел который хотим удалить
            Node root = heapArray[index];
            heapArray[index] = heapArray[--currentSize];
            heapArray[currentSize] = null;
            // вызываем метод чтобы поставить все на свои места
            displaceDown(index);
            return root;
        }
        return null;
    }

    public boolean changeNode(int index, int newValue) {
        // проверяем существует ли вообще элемент по этому индексу
        if (index < 0 || currentSize <= index) {
            return false;
        }

        int oldValue = heapArray[index].getValue();
        heapArray[index].setValue(newValue);

        if (oldValue < newValue) {
            displaceUp(index);
        }
        else {
            displaceDown(index);
        }
        return true;
    }

    // смещение вверх
    private void displaceUp(int index) {
        int parentIndex = (index - 1) / 2; // индекс родителя
        Node bottom = heapArray[index]; // берем элемент
        // если родительский элемент меньше
        while (index > 0 && heapArray[parentIndex].getValue() < bottom.getValue()) {
            heapArray[index] = heapArray[parentIndex];
            index = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    // смещение вниз
    private void displaceDown(int index) {
        int largerChild;
        Node top = heapArray[index];

        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getValue() < heapArray[rightChild].getValue()) {
                largerChild = rightChild;
            }
            else {
                largerChild = leftChild;
            }

            if (top.getValue() >= heapArray[largerChild].getValue()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public void printHeap() {
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...................................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(' ');
                }
            }

            System.out.print(heapArray[j].getValue());

            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    
}
