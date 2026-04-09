import java.util.BitSet;

public class BloomFilter<T> {
    private BitSet bitSet;      // массив битов
    private int bitSetSize;     // размер массива
    private int numHashFunctions; // количество хэш-функций

    public BloomFilter(int capacity, int expectedElements) {
        // оптимальный размер фильтра
        this.bitSetSize = capacity;
        this.bitSet = new BitSet(bitSetSize);
        // обычно берут от 3 до 7 функций
        this.numHashFunctions = 3; 
    }

    // добавление элемента
    public void add(T element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = getHash(element, i);
            bitSet.set(hash); // ставим 1 в нужную позицию
        }
    }

    // Проверка наличия
    public boolean contains(T element) {
        for (int i = 0; i < numHashFunctions; i++) {
            int hash = getHash(element, i);
            if (!bitSet.get(hash)) {
                return false; // если хотя бы один бит равен 0 — элемента ТОЧНО нет
            }
        }
        return true; // все биты 1? Значит, ВОЗМОЖНО есть
    }

    // Генерация разных хэшей для одного элемента
    private int getHash(T element, int seed) {
        // Используем стандартный hashCode + seed (соль), чтобы получить разные числа
        int hash = element.hashCode() + (seed * 31);
        return Math.abs(hash) % bitSetSize;
    }
}