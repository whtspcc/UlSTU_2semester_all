import java.util.Random;

// номер 10

public class task3 {
    public static void main(String[] args) {
        int[] a = new int[11];
        Random random = new Random();

        System.out.println("Исходный массив (11 элементов):");
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(50) + 1;
            System.out.print(a[i] + " ");
        }
        
        System.out.println("\n\n");
        System.out.println("Условие: " + a[0] + " < A[i] < " + a[10]);

        int first = a[0];
        int last = a[10];
        int resultIndex = 0;

        for (int i = 1; i < 10; i++) {
            if (a[i] > first && a[i] < last) {
                resultIndex = i + 1;
                break;
            }
        }

        if (resultIndex != 0) {
            System.out.println("Номер первого подходящего элемента: " + resultIndex);
            System.out.println("Сам элемент: " + a[resultIndex - 1]);
        } else {
            System.out.println("Таких элементов нет: " + resultIndex);
        }
    }
}