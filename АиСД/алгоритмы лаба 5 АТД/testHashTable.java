import java.util.HashMap;
import java.util.UUID;

public class testHashTable {
    public static void main(String[] args) {
        int capacity = 10000;
        lab5HashTable<String, Integer> myTable = new lab5HashTable<>(capacity);
        HashMap<String, Integer> stdMap = new HashMap<>(capacity);

        System.out.println("LoadFactor(OX)\tMyTime(ns)\tStdTime(ns)");
        
        // массив ключей для тестов поиска
        String[] testKeys = new String[capacity];
        for(int i=0; i<capacity; i++) testKeys[i] = UUID.randomUUID().toString();

        // постепенно заполняем таблицу и замеряем скорость поиска
        for (int i = 0; i < capacity; i++) {
            myTable.put(testKeys[i], i);
            stdMap.put(testKeys[i], i);

            // снимаем замеры каждые 10% заполнения (0.1, 0.2 ... 0.9)
            if (i % (capacity / 10) == 0 && i > 0) {
                String searchKey = testKeys[i]; // ключ, который точно есть

                long startMy = System.nanoTime();
                myTable.get(searchKey);
                long endMy = System.nanoTime() - startMy;

                long startStd = System.nanoTime();
                stdMap.get(searchKey);
                long endStd = System.nanoTime() - startStd;

                System.out.printf("%.1f\t\t%d\t\t%d\n", 
                                  myTable.getLoadFactor(), endMy, endStd);
            }
        }
    }
}