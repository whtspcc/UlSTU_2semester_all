package tasks;

public class Task4 {
    public static final String Description = 
    "24\n" +
    "Дан целочисленный одномерный массив размера N. Серия – это\r\n" +
    "последовательность элементов массива, идущих друг за другом.\r\n" +
    "Значения элементов серии либо все четные, либо все нечетные. Серия\r\n" +
    "должна содержать минимум 2 элемента. Длина серии – количество\r\n" +
    "элементов в серии. Удалить из массива самую короткую серию. ";

    public static String execute(int[] array) {
        if (array == null || array.length < 2)
            return "Недостаточно данных";

        StringBuilder message = new StringBuilder();

        message.append("Исходный массив:\n");
        message.append(arrayToString(array));
        message.append("\n\n");

        int minStart = -1;
        int minLen = Integer.MAX_VALUE;

        int start = 0;
        int len = 1;

        for (int i = 1; i < array.length; i++) {
            boolean sameParity = array[i] % 2 == array[i - 1] % 2;

            if (sameParity) {
                len++;
            } else {
                if (len >= 2 && len < minLen) {
                    minLen = len;
                    minStart = start;
                }
                
                start = i;
                len = 1;
            }
        }

        if (len >= 2 && len < minLen) {
            minLen = len;
            minStart = start;
        }

        if (minStart == -1)
            return "Подходящих серий нет";

        message.append("Удаляемая серия:\n");
        for (int i = minStart; i < minStart + minLen; i++) {
            message.append(array[i]).append(" ");
        }
        
        message.append("\n\n");

        // удаление серии сдвигом
        for (int i = minStart + minLen; i < array.length; i++) {
            array[i - minLen] = array[i];
        }

        // освобождение конца массива
        for (int i = array.length - minLen; i < array.length; i++) {
            array[i] = 0;
        }
        
message.append("не работает:\n");
        message.append("Результат:\n");
        message.append(arrayToString(array));

        return message.toString();
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();

        for (int value : array) {
            sb.append(value).append(" ");
        }

        return sb.toString();
    }
}
