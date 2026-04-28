import java.util.ArrayList;
import java.util.Random;

public class testArrayList {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000, 150000, 300000};
        
        System.out.println("N\t\tOp\t\tMyArrayList(ns)\tStdArrayList(ns)");
        System.out.println("------------------------------------------------------------");

        for (int n : sizes) {
            runBenchmark(n);
        }
    }

    private static void runBenchmark(int n) {
        // подготовка данных
        lab5ArrayList<Integer> my = new lab5ArrayList<>();
        ArrayList<Integer> std = new ArrayList<>();
        Random random = new Random();

        // тест ADD
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) my.add(i);
        long myAdd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) std.add(i);
        long stdAdd = System.nanoTime() - start;
        printRow(n, "Add", myAdd, stdAdd);

        // тест GET
        start = System.nanoTime();
        for (int i = 0; i < n; i++) my.get(random.nextInt(n));
        long myGet = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) std.get(random.nextInt(n));
        long stdGet = System.nanoTime() - start;
        printRow(n, "Get", myGet, stdGet);

        // тест REMOVE (удаление из середины/начала - самое долгое)
        // делаем копии, чтобы не испортить основные списки
        lab5ArrayList<Integer> myForRem = new lab5ArrayList<>();
        ArrayList<Integer> stdForRem = new ArrayList<>();
        for(int i=0; i<n; i++) { myForRem.add(i); stdForRem.add(i); }

        start = System.nanoTime();
        // Удаляем 1000 элементов (или меньше, если N мало), чтобы не ждать вечность на больших N
        int limit = Math.min(n, 1000); 
        for (int i = 0; i < limit; i++) myForRem.remove(0); 
        long myRem = (System.nanoTime() - start) / limit; // среднее на 1 операцию

        start = System.nanoTime();
        for (int i = 0; i < limit; i++) stdForRem.remove(0);
        long stdRem = (System.nanoTime() - start) / limit;
        printRow(n, "Rem(0)", myRem, stdRem);
        
        System.out.println("------------------------------------------------------------");
    }

    private static void printRow(int n, String op, long my, long std) {
        System.out.printf("%-8d\t%-8s\t%-15d\t%-15d\n", n, op, my, std);
    }
}