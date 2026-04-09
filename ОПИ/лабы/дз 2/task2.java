import java.util.Random;

// номер 9

public class task2 {
    public static void main(String[] args) {
		int n = 10;
        int[] arr = new int[n];
        Random random = new Random();

        System.out.println("Исходный массив:");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(20) + 1; 
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n\n");

        if (n >= 2) {
            int lastElement = arr[n - 1];

            for (int i = 1; i < n - 1; i++) {
                if (arr[i] % 2 == 0) {
                    arr[i] += lastElement;
                }
            }
        }

        System.out.println("Преобразованный массив:");
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}