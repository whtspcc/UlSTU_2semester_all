import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices; // количество вершин
    private LinkedList<Integer>[] adjacencyList; // массив списков см   ежности

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        // список, где для каждой вершины хранится список ее соседей
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // добавление ребра (ориентированный граф)
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    // алгоритм обхода в ширину (BFS)
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // массив посещенных вершин
        Queue<Integer> queue = new LinkedList<>(); // очередь для BFS (кого нужно навестить)

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS обход: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // проходим по всем соседям текущей вершины
            for (int neighbor : adjacencyList[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
