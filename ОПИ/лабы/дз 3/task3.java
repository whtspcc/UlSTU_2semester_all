import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        System.out.println("исходная матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int size = rows * cols;
        int[] flatArray = new int[size];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[k++] = matrix[i][j];
            }
        }

        // bubble sort
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (flatArray[j] < flatArray[j + 1]) {
                    int temp = flatArray[j];
                    flatArray[j] = flatArray[j + 1];
                    flatArray[j + 1] = temp;
                }
            }
        }

        int index = 0;
        System.out.println("\nматрица после:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = flatArray[index++];
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}