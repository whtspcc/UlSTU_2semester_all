import java.util.ArrayDeque;

public class testStack {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000, 100000};
        
        System.out.println("N\t\tOp\t\tMyStack(ns)\tArrayDeque(ns)");
        System.out.println("-------------------------------------------------------");

        for (int n : sizes) {
            // Тест PUSH
            long start = System.nanoTime();
            lab5Stack<Integer> myStack = new lab5Stack<>();
            for (int i = 0; i < n; i++) myStack.push(i);
            long myPush = System.nanoTime() - start;

            start = System.nanoTime();
            ArrayDeque<Integer> stdStack = new ArrayDeque<>();
            for (int i = 0; i < n; i++) stdStack.push(i);
            long stdPush = System.nanoTime() - start;

            System.out.printf("%-8d\tPush\t%-15d\t%-15d\n", n, myPush, stdPush);

            // Тест POP
            start = System.nanoTime();
            while (!myStack.isEmpty()) myStack.pop();
            long myPop = System.nanoTime() - start;

            start = System.nanoTime();
            while (!stdStack.isEmpty()) stdStack.pop();
            long stdPop = System.nanoTime() - start;

            System.out.printf("%-8d\tPop \t%-15d\t%-15d\n", n, myPop, stdPop);
            System.out.println("-------------------------------------------------------");
        }
    }
}