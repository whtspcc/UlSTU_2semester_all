public class LinearProbingHashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table; // массив с Entry
    private int size; 
    private static final double LOAD_FACTOR = 0.75; // порог проходимости

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int capacity) {
        table = new Entry[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value) {
        // проверка заполненности
        if ((double) size / table.length >= LOAD_FACTOR) {
            resize();
        }

        // ЛИНЕЙНОЕ ПРОБИРОВАНИЕ
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                table[index].value = value;
                return;
            }
            // коллизия - шагаем в следующую ячейку
            index = (index + 1) % table.length;
        }
        
        // вписываем в пустое место
        table[index] = new Entry<>(key, value);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value); // перехэширование
            }
        }
    }
}