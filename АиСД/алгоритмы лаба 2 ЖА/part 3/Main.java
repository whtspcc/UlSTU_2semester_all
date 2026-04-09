import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Runtime runtime = Runtime.getRuntime();

        // test bubble sort
        System.out.println("Bubble Sort (Сортировка пузырьком)");
        int nSort = 300; 
        int[] arrSort = new int[nSort];
        for (int i = 0; i < nSort; i++)  arrSort[i] = random.nextInt(10000);

        measurePerformance(() -> BubbleSort.bubbleSort(arrSort), runtime);
        System.out.println("Массив отсортирован: " + isSorted(arrSort));
        System.out.println();


        // test binary search
        System.out.println("Binary Search (Бинарный поиск)");
        int nSearch = 1000; 
        int[] arrSearch = new int[nSearch];
        for (int i = 0; i < nSearch; i++) arrSearch[i] = random.nextInt(2_000_000);
        Arrays.sort(arrSearch); // бинарный поиск работает только на отсортированном массиве
        int target = arrSearch[random.nextInt(nSearch)];

        measurePerformance(() -> {
            BinarySearch.binarySearch(arrSearch, target);
        }, runtime);
        System.out.println("Искомое число: " + target);
        System.out.println();


        // test fibonacci (recursion)
        System.out.println("Fibonacci (Рекурсивный метод)");
        int nFib = 10; 
        
        measurePerformance(() -> {
            int result = Fibonacci.fibonacci(nFib);
            System.out.println("Число Фибоначчи #" + nFib + " = " + result);
        }, runtime);
        System.out.println("\n\n");
    }

    private static void measurePerformance(Runnable task, Runtime runtime) {
        runtime.gc(); 
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        task.run();

        long endTime = System.nanoTime();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();

        double durationMs = (endTime - startTime) / 1_000_000.0;
        double memUsedKb = (memAfter - memBefore) / 1024.0;

        System.out.printf("Время выполнения: %.4f мс\n", durationMs);
        System.out.printf("Использовано памяти: %.2f КБ\n", (memUsedKb > 0 ? memUsedKb : 0.0));
    }

    // вспомогательный метод для проверки сортировки
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}