package tasks;

public class Task6 {
    public static final String Description = 
    "24\n" +
    "Дан целочисленный двумерный массив размера N*N. Отсортировать\r\n" +
    "матрицу по возрастанию выше побочной диагонали. Направление: слева\r\n" + 
    "направо, сверху вниз.";

    public static String execute(int[][] array, int rows, int cols) {
        if (array == null || rows == 0 || cols == 0) 
            return "Недостаточно данных";

        if (rows != cols)
            return "Матрица должна быть квадратной";

        StringBuilder message = new StringBuilder();

        message.append("Исходная матрица: \n");
        message.append(matrixToString(array, rows, cols));

        int n = rows;

        // сортировка обменами

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {

                if (i1+j1 >= n-1) {
                    continue;
                }
                // находим первый НАИМЕНЬШИЙ элемент
                for (int i2 = i1; i2 < n; i2++) {
                    int startCol = (i2 == i1) ? j1 + 1 : 0;

                    for (int j2 = startCol; j2 < n; j2++) {
                        if (i2 + j2 >= n - 1) {
                            continue;
                        }

                        if (array[i1][j1] > array[i2][j2]) {
                            int temp = array[i1][j1];
                            array[i1][j1] = array[i2][j2];
                            array[i2][j2] = temp;
                        }
                    }
                }
            }
        }

        message.append("Результат: \n");
        message.append(matrixToString(array, rows, cols));

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
