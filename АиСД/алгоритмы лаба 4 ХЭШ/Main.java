public class Main {
    public static void main(String[] args) {

        // номер 1
        LinearProbingHashTable<String, Integer> map = new LinearProbingHashTable<>(4);

        // вставка и обновление
        map.put("Key1", 10);
        map.put("Key2", 20);
        map.put("Key1", 100);

        System.out.println("текущий размер: " + getField(map, "size"));

        // коллизия
        map.put("Key3", 30); 
        System.out.println("размер после 3-го элемента: " + getField(map, "size"));
        System.out.println("\n");

        // проверка resize
        System.out.println("емкость до вставки 4-го: " + getTableLength(map));
        map.put("Key4", 40);
        System.out.println("емкость после вставки 4-го: " + getTableLength(map));
        System.out.println("размер итоговый: " + getField(map, "size"));
        System.out.println("\n");

        // номер 2
        TreeChainHashTable<String, Integer> table = new TreeChainHashTable<>(3);
        System.out.println("\n");

        // добавление 
        table.put("Apple", 100);
        table.put("Banana", 200);
        
        System.out.println("Apple: " + table.get("Apple"));   // Ожидаем 100
        System.out.println("Banana: " + table.get("Banana")); // Ожидаем 200
        System.out.println("Cherry (не существует): " + table.get("Cherry")); // Ожидаем null
        System.out.println("\n");

        // Обновление значения
        table.put("Apple", 500);
        System.out.println("Apple (новое значение): " + table.get("Apple")); // Ожидаем 500
        System.out.println("\n");

        // коллизии
        // добавляем много элементов в маленькую таблицу (3 бакета).
        // многие из них гарантированно попадут в одно и то же дерево внутри бакета.
        String[] keys = {"Orange", "Grape", "Melon", "Peach", "Plum", "Kiwi"};
        for (String k : keys) {
            table.put(k, k.length()); // Сохраняем длину слова как значение
        }

        // проверяем, что все элементы доступны, несмотря на то что они в деревьях
        boolean allFound = true;
        for (String k : keys) {
            if (table.get(k) == null) {
                allFound = false;
                System.out.println("Ошибка: Ключ " + k + " потерян!");
            }
        }
        if (allFound) {
            System.out.println("Все " + keys.length + " элементов успешно найдены в деревьях");
        }
        System.out.println("\n");

        // номер 3
        BloomFilter<String> filter = new BloomFilter<>(100, 10);

        // добавление
        filter.add("Apple");
        filter.add("Banana");
        filter.add("Orange");

        System.out.println("Содержит Apple? " + filter.contains("Apple"));   // Ожидаем true
        System.out.println("Содержит Banana? " + filter.contains("Banana")); // Ожидаем true
        System.out.println("Содержит Orange? " + filter.contains("Orange")); // Ожидаем true
        System.out.println("\n");

        // элементы, которых нет
        // Эти элементы мы не добавляли. Фильтр должен вернуть false (если нет коллизий).
        System.out.println("Содержит Grape? " + filter.contains("Grape"));   // Скорее всего false
        System.out.println("Содержит Melon? " + filter.contains("Melon"));   // Скорее всего false
        System.out.println("\n");

        // демонстрация ложноположительного результата
        /* чтобы спровоцировать ошибку «False Positive», создадим очень маленький фильтр
           и забьем его данными. Когда почти все биты станут 1, фильтр начнет 
           утверждать, что содержит любой элемент.
        */
        BloomFilter<Integer> tinyFilter = new BloomFilter<>(20, 10);
        for (int i = 0; i < 15; i++) {
            tinyFilter.add(i);
        }

        System.out.println("Проверка числа 99 (мы его не добавляли): " + tinyFilter.contains(99));
        System.out.println("Если выше true — это ложноположительное срабатывание (коллизия битов).");
    }

    // Вспомогательные методы для тестов (через Reflection, чтобы не менять класс)
    private static Object getField(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) { return "ошибка"; }
    }

    private static int getTableLength(Object obj) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField("table");
            field.setAccessible(true);
            Object[] table = (Object[]) field.get(obj);
            return table.length;
        } catch (Exception e) { return -1; }
    }
}