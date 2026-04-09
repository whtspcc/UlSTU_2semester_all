import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        Random random = new Random();
        
        int rows = 4;
        int cols = 4;
        int[][] matrix = new int[rows][cols];

        System.out.println("исходная матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(101) - 50; 
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        double sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int x : row) {
                if (x > 0) { 
                    sum += x; 
                    count++; 
                }
            }
        }
        
        double avg = count > 0 ? sum / count : 0;
        System.out.printf("среднее полож. элементов: %.2f\n", avg);
		System.out.printf("\n\n");

        boolean[] needZeroAfter = new boolean[matrix[0].length];
        int newColsCount = matrix[0].length;

        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (Math.abs(matrix[i][j]) > avg) {
                    needZeroAfter[j] = true;
                    newColsCount++;
                    break; 
                }
            }
        }

        int[][] result = new int[matrix.length][newColsCount];
        for (int i = 0; i < matrix.length; i++) {
            int targetCol = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][targetCol++] = matrix[i][j];
                if (needZeroAfter[j]) {
                    result[i][targetCol++] = 0;
                }
            }
        }

        System.out.println("результат (с добавленными столбцами нулей):");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}