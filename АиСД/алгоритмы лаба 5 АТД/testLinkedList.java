import java.util.LinkedList;

public class testLinkedList {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000};
        
        System.out.println("N\t\tOp\t\tMyLinkedList(ns)\tStdLinkedList(ns)");
        System.out.println("------------------------------------------------------------");

        for (int n : sizes) {
            // Тест ADD 
            long start = System.nanoTime();
            lab5LinkedList<Integer> my = new lab5LinkedList<>();
            for (int i = 0; i < n; i++) my.add(i);
            long myAdd = System.nanoTime() - start;

            start = System.nanoTime();
            LinkedList<Integer> std = new LinkedList<>();
            for (int i = 0; i < n; i++) std.add(i);
            long stdAdd = System.nanoTime() - start;
            System.out.printf("%-8d\tAdd\t%-15d\t%-15d\n", n, myAdd, stdAdd);

            // Тест GET
            start = System.nanoTime();
            my.get(n / 2);
            long myGet = System.nanoTime() - start;

            start = System.nanoTime();
            std.get(n / 2);
            long stdGet = System.nanoTime() - start;
            System.out.printf("%-8d\tGetMid\t%-15d\t%-15d\n", n, myGet, stdGet);
            System.out.println("------------------------------------------------------------");
        }
    }
}