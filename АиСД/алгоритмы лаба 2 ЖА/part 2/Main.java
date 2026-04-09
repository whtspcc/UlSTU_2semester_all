import java.util.Random;

// дана последовательность матриц 
// и требуется минимизировать количество скалярных операций 
// для вычисления их произведения.

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Runtime runtime = Runtime.getRuntime();

        // менять количество матриц
        int n = 5000; 

        int[] p = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            p[i] = random.nextInt(100) + 1;
        }

        System.out.println("Тестирование алгоритма динамического алгоритма");
        System.out.println("Количество матриц: " + n);

        // подготовка памяти
        runtime.gc();
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        
        // замер времени
        long startTime = System.nanoTime();

        int result = MatrixChain.matrixChainOrder(p);

        long endTime = System.nanoTime();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();

        // расчеты
        double durationMs = (endTime - startTime) / 1_000_000.0;
        double memoryUsedKb = (memAfter - memBefore) / 1024.0;

        System.out.println("Минимальная стоимость: " + result);
        System.out.printf("Время выполнения: %.4f мс\n", durationMs);
        System.out.printf("Использовано памяти: %.2f КБ\n", (memoryUsedKb > 0 ? memoryUsedKb : 0.0));
    }
}