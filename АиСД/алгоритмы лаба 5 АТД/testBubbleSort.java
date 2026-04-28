import java.util.Arrays;
import java.util.Random;

public class testBubbleSort {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000};
        Random random = new Random();

        System.out.println("N\t\tBubbleSort(ms)\tArrays.sort(ms)");
        System.out.println("-------------------------------------------------");

        for (int n : sizes) {
            // генерируем два одинаковых случайных массива
            int[] baseArray = new int[n];
            for (int i = 0; i < n; i++) baseArray[i] = random.nextInt(100000);

            int[] arrayForBubble = Arrays.copyOf(baseArray, n);
            int[] arrayForStd = Arrays.copyOf(baseArray, n);

            // тест Bubble Sort
            long start = System.currentTimeMillis();
            lab5BubbleSort.bubbleSort(arrayForBubble);
            long bubbleTime = System.currentTimeMillis() - start;

            // тест Arrays.sort
            start = System.currentTimeMillis();
            Arrays.sort(arrayForStd);
            long stdTime = System.currentTimeMillis() - start;

            System.out.println(n + "\t\t" + bubbleTime + "\t\t" + stdTime);
        }
    }
}