package tasks;

public class Task2 {
    public static final String Description =
    "24\n"+
    "Дан целочисленный одномерный массив размера N.\n" +
    "Серия – это последовательность элементов массива, идущих друг за другом.\n" +
    "Каждый элемент серии больше предыдущего. Серия должна содержать минимум 2 элемента.\n" +
    "Длина серии – количество элементов в серии.\n" +
    "Перенести после первого положительного по значению элемента массива серию с наименьшей длиной\n" +
    "(если достаточно места в массиве после первого положительного).";

    public static String execute(int[] array) {
        StringBuilder message = new StringBuilder();

        if (array == null || array.length < 2)
            return "Недостаточно данных";

        String originalArray = arrayToString(array);

        message.append("Исходный массив: \n" + originalArray);

        // поиск первого положительного

        int positiveIdx = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positiveIdx = i;
                break;
            }
        }

        if (positiveIdx == -1)
            return "Положительного числа нет";

        message.append("\nПервый положительный элемент: " + array[positiveIdx] + "\n");

        // поиск минимальной  возрастающей серии

        int minStartIdx = -1;
        int minLen = Integer.MAX_VALUE;

        int startIdx = 0;
        int len = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                len++;
            } else {
                if (len >= 2 && len < minLen) {
                    minLen = len;
                    minStartIdx = startIdx;
                }

                startIdx = i;
                len = 1;
            }
        }

        if (len >= 2 && len < minLen) {
            minLen = len;
            minStartIdx = startIdx;
        }

        if (minStartIdx == -1) 
            return "Возрастающие серии отсутствуют";

        if (minStartIdx == positiveIdx + 1)
            return "Серия находится уже после первого положительного\n\n" + arrayToString(array);

        message.append("Минимальная возрастающая серия:\n ");

        for (int i = minStartIdx ; i < minStartIdx + minLen; i++) {
            message.append(array[i]).append(" ");
        }
        message.append("\n");

        // перенос серии

        // если серия находится после положительного
        if (minStartIdx > positiveIdx) {

            for (int k = 0; k < minLen; k++) {
                for (int i = minStartIdx + k; i > positiveIdx + 1 + k; i--) {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }

        // если серия находится до положительного
        } else {

            for (int k = minLen -1; k >= 0; k--) {
                for (int i = minStartIdx + k; i < positiveIdx; i++) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }

        message.append("\nРезультат:\n");
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
