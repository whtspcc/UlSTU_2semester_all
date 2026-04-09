import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // размеры входных данных для тестов
        // int[] sizes = {100, 500, 1000, 5000, 10000};

        // System.out.println("тестирование алгоритмов\n");

        // for (int n : sizes) {
            // System.out.println("размер данных (N): " + n);
            // testBinaryHeap(n);
            // testBFS(n);
            // testDijkstra(n);

            // BinaryHeap heap = new BinaryHeap(10);
            // Graph graph = new Graph(10);

            // направленный граф
            int[][] graph2 = {
            //   0  1  2  3  4  5
                {0, 4, 2, 0, 0, 0}, // 0
                {0, 0, 5, 10, 0, 0}, // 1
                {0, 0, 0, 0, 8, 1}, // 2
                {0, 0, 0, 0, 2, 6}, // 3
                {5, 0, 0, 0, 0, 3}, // 4
                {0, 0, 0, 0, 0, 0} // 5
            };

            // ненаправленный граф
            int[][] graph3 = {
            //   0  1  2  3  4  5
                {0, 4, 2, 0, 0, 0}, // 0
                {4, 0, 5, 10, 0, 0}, // 1
                {2, 5, 0, 0, 8, 1}, // 2
                {0, 10, 0, 0, 2, 6}, // 3 
                {0, 0, 8, 2, 0, 3}, // 4
                {0, 0, 1, 6, 3, 0} // 5
            };
            // heap.insertNode(12);
            // heap.insertNode(13);
            // heap.insertNode(14);
            // heap.insertNode(11);
            // heap.insertNode(43);
            // heap.insertNode(564);
            // heap.insertNode(32);
            // heap.insertNode(15);
            // heap.insertNode(95);

            // heap.changeNode(1, 3);

            // heap.printHeap();


            // graph.addEdge(0, 1);
            // graph.addEdge(0, 2);
            // graph.addEdge(1, 3);
            // graph.addEdge(1, 5);
            // graph.addEdge(2, 3);
            // graph.addEdge(2, 4);
            // graph.addEdge(3, 5);
            // graph.addEdge(3, 1);
            // graph.addEdge(1, 2);

            // graph.bfs(0);

            DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();

            dijkstra.dijkstra(graph2, 0);
        // }
    }

    // private static void testBinaryHeap(int n) {
    //     BinaryHeap heap = new BinaryHeap(n);
    //     Random random = new Random();

    //     long startTime = System.nanoTime();
    //     long startMemory = getUsedMemory();

    //     for (int i = 0; i < n; i++) {
    //         heap.insertNode(random.nextInt(n * 10));
    //     }

    //     long endTime = System.nanoTime();
    //     long endMemory = getUsedMemory();

    //     printResults("BinaryHeap (Insert)", n, startTime, endTime, startMemory, endMemory);
    // }

    // private static void testBFS(int n) {
    //     Graph graph = new Graph(n);
    //     Random random = new Random();

    //     // создаем случайные ребра (примерно по 2 на вершину)
    //     for (int i = 0; i < n; i++) {
    //         graph.addEdge(i, random.nextInt(n));
    //         graph.addEdge(i, random.nextInt(n));
    //     }

    //     long startTime = System.nanoTime();
    //     long startMemory = getUsedMemory();

    //     // запускаем BFS от 0 вершины 
    //     graph.bfs(0); 

    //     long endTime = System.nanoTime();
    //     long endMemory = getUsedMemory();

    //     printResults("BFS Graph Traversal", n, startTime, endTime, startMemory, endMemory);
    // }

    // private static void testDijkstra(int n) {
    //     // для дейкстры используем матрицу смежности (ограничим N, т.к. N^2 память)
    //     int limit = Math.min(n, 5000); 
    //     int[][] matrix = new int[limit][limit];
    //     Random random = new Random();

    //     for (int i = 0; i < limit; i++) {
    //         for (int j = 0; j < limit; j++) {
    //             if (i != j && random.nextInt(10) > 7) { // 30% шанс ребра
    //                 matrix[i][j] = random.nextInt(100) + 1;
    //             }
    //         }
    //     }

    //     DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        
    //     long startTime = System.nanoTime();
    //     long startMemory = getUsedMemory();

    //     dijkstra.dijkstra(matrix, 0);

    //     long endTime = System.nanoTime();
    //     long endMemory = getUsedMemory();

    //     printResults("Dijkstra (Matrix)", limit, startTime, endTime, startMemory, endMemory);
    // }

    // // Вспомогательные методы
    // private static void printResults(String name, int n, long startT, long endT, long startM, long endM) {
    //     double durationMs = (endT - startT) / 1_000_000.0;
    //     long memoryUsed = (endM - startM) / 1024; // в КБ
    //     if (memoryUsed < 0) memoryUsed = 0; // погрешность GC

    //     System.out.printf("%-20s | Время: %8.2f ms | Память: ~%6d KB%n", name, durationMs, memoryUsed);
    // }

    // private static long getUsedMemory() {
    //     Runtime runtime = Runtime.getRuntime();
    //     return runtime.totalMemory() - runtime.freeMemory();
    // }
}