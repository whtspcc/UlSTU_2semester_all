package tasks;

public class Task3 {
    public static final String Description =
    "24\n" +
    "Дан целочисленный одномерный массив размера N. Серия – это\r\n" +
    "последовательность элементов массива, идущих друг за другом.\r\n" +
    "Каждый элемент серии делился нацело на предыдущий. Серия должна\r\n" + 
    "содержать минимум 2 элемента. Длина серии – количество элементов в\r\n" + 
    "серии. Добавить в конец каждой его серии еще один элемент\r\n" + 
    "(добавляется последний элемент в серии).";

    public static String execute(int[] array) {
        if (array == null || array.length < 2)
            return "Недостаточно данных";

        int count = array.length;

        // определяем количество заполненных элементов

        while (count > 0 && array[count-1] == 0) {
            count--;
        }

        StringBuilder message = new StringBuilder();

        message.append("Исходный массив: \n");
        for (int i = 0; i < array.length; i++) {
            message.append(array[i]).append(" ");
        }

        message.append("\n\n");

        int start = 0;
        int len = 1;

        for (int i = 1; i <= count; i++) {
            boolean inSeries = false;

            if (i < count && array[i-1] != 0 && array[i] % array[i-1] == 0) {
                inSeries = true;
            }

            if (inSeries) {
                len++;
            } else {
                if (len >= 2) {
                    int end = start + len - 1;
                    int value = array[end];

                    message.append("\nСерия:\n");
                    for (int k = start; k <= end; k++) {
                        message.append(array[k]).append(" ");
                    }
                    message.append("\n");
                    
                    // проверяем наличие свободного места
                    if (count >= array.length)
                        return "недостаточно свободного места";

                    // сдвиг вправо
                    for (int j = count; j > end; j--) {
                        array[j] = array[j - 1];
                    }

                    // вставляем копию последнего элемента
                    array[end + 1] = value;
                    count++;

                    // пропускаем только что вставленный элемент
                    i++;
                }

                start = i;
                len = 1;
            }
        }

        message.append("Результат: \n");

        for (int i = 0; i < count; i++) {
            message.append(array[i]).append(" ");
        }

        return message.toString();
    }
}
