package tasks;

public class Task1 {
    public static final String Description =
    "24\n" +
    "Дан целочисленный одномерный массив размера N.\n" +
    "Серия – это последовательность элементов массива, идущих друг за другом.\n" +
    "Каждый элемент серии меньше предыдущего. Серия должна содержать минимум 2 элемента.\n" +
    "Длина серии – количество элементов в серии.\n" +
    "Найти серии с максимальной и минимальной длинами. Вывести элементы из каждой серии.";

    public static String execute(int[] array) {
        if (array == null || array.length < 2) 
            return "Недостаточно данных";

        int maxStartIdx = -1;
        int maxLen = 0;

        int minStartIdx = -1;
        int minLen = Integer.MAX_VALUE;

        int startIdx = 0;
        int len = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                len++;
            } else {
                if (len >= 2) {
                    if (len > maxLen) {
                        maxLen = len;
                        maxStartIdx = startIdx;
                    }

                    if (len < minLen) {
                        minLen = len;
                        minStartIdx = startIdx;
                    }
                }
                startIdx = i;
                len = 1;
            }
        }

        if (len >= 2) {
            if (len > maxLen) {
                maxLen = len;
                maxStartIdx = startIdx;
            }

            if (len < minLen) {
                minLen = len;
                minStartIdx = startIdx;
            }
        }

        if (maxStartIdx == -1)
            return "Серии отсутствуют";

        StringBuilder sb = new StringBuilder();

        sb.append("Самая длинная серия:\n");
        for (int i = maxStartIdx; i < maxStartIdx + maxLen; i++) {
            sb.append(array[i]).append(" ");
        }

        sb.append("\nСамая короткая серия:\n");
        for (int i = minStartIdx; i < minStartIdx + minLen; i++) {
            sb.append(array[i]).append(" ");
        }

        return sb.toString();
    }
}