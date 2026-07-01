import java.util.Random;

public class ArrayGenerator {

    public static int[] generate1D(int size, int min, int max) {

        Random random = new Random();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }


    public static int[][] generate2D(int rows, int cols, int min, int max) {

        Random random = new Random();

        // + запас строк для 5 задания
        int[][] array = new int[rows * 2][cols * 2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = random.nextInt(max - min + 1) + min;
            }
        }

        return array;
    }
}