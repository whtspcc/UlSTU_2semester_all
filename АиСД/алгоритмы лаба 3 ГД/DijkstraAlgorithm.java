import java.util.Arrays;

public class DijkstraAlgorithm {
    // метод для поиска вершины с минимальным расстоянием из еще не посещенных
    private int findMinDistance(int[] distances, boolean[] visited, int vertices) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }   
        }
        return minIndex;
    }

    public void dijkstra(int[][] graph, int startVertex) {
        // graph[][] матрица смежности  
        int vertices = graph.length;
        int[] distances = new int[vertices]; // итоговые кратчайшие расстояния
        boolean[] visited = new boolean[vertices]; // массив посещенных вершин

        // все расстояния бесконечны, кроме стартовой вершины
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startVertex] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            // выбираем вершину с минимальным расстоянием из не посещенных
            int u = findMinDistance(distances, visited, vertices);
            
            if (u == -1) break; // все оставшиеся вершины недосягаемы

            visited[u] = true;

            // обновляем расстояния до соседей выбранной вершины
            for (int v = 0; v < vertices; v++) {
                // вершина v не посещена
                // ребро u -> v существует (graph[u][v] != 0)
                // путь через u короче, чем текущий известный путь до v
                if (!visited[v] && graph[u][v] != 0 && 
                    distances[u] != Integer.MAX_VALUE &&
                    distances[u] + graph[u][v] < distances[v]) {
                    
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }

        printSolution(distances, startVertex);
    }

    private void printSolution(int[] distances, int start) {
        System.out.println("Расстояния от вершины " + start + ":");
        for (int i = 0; i < distances.length; i++) {
            String dist = (distances[i] == Integer.MAX_VALUE) ? "INF" : String.valueOf(distances[i]);
            System.out.println("До " + i + " -> " + dist);
        }
    }
}
