package tasks;

public class Task5 {
    public static final String Description =
        "24.Дан целочисленный двумерный массив размера N*N. Добавить строку,\r\n" + //
        "содержащий сумму между строками с минимальным и максимальным\r\n" + //
        "элементом после каждой строки, в которой четное количество\r\n" + //
        "отрицательных элементов.";

    public static String execute(int[][] array, int rows, int cols) {
        if (array == null || rows <= 0 || cols <= 0) {
            return "Недостаточно данных";
        }

        StringBuilder message = new StringBuilder();

        message.append("Исходный массив:\n");
        message.append(matrixToString(array, rows, cols));

        // поиск строк с минимальным и максимальным элементом

        int min = array[0][0];
        int max = array[0][0];

        int minRow = 0;
        int maxRow = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    minRow = i;
                }

                if (array[i][j] > max) {
                    max = array[i][j];
                    maxRow = i;
                }
            }
        }

        message.append("\nСтрока с минимальным элементом: ").append(minRow + 1);
        message.append("\nСтрока с максимальным элементом: ").append(maxRow + 1);
        message.append("\n");

        int currentRows = rows;

        // обработка строк
        for (int i = 0; i < currentRows; i++) {
            int negative = 0;

            for (int j = 0; j < cols; j++) {
                if (array[i][j] < 0) {
                    negative++;
                }
            }

            if (negative > 0 && negative % 2 == 0) {
                if (currentRows >= array.length) {
                    return "Недостаточно свободных строк";
                }

                // сдвиг строк вниз
                for (int r = currentRows; r > i+1; r--) {
                    for (int c = 0; c < cols; c++) {
                        array[r][c] = array[r-1][c];
                    }
                }

                // если строка с min/max была ниже места вставки
                // после сдвига их индексы увеличиваются

                if (minRow > i) {
                    minRow++;
                }

                if (maxRow > i) {
                    maxRow++;
                }

                // заполняем вставленную строку
                for (int c = 0; c < cols; c++) {
                    array[i+1][c] = array[minRow][c] + array[maxRow][c];
                }

                currentRows++;
                i++;
            }
        }
        message.append("\nРезультат:\n");
        message.append(matrixToString(array, currentRows, cols));

        return message.toString();
    }

    private static String matrixToString(int[][] array, int rows, int cols) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%5d", array[i][j]));
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}