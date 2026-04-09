import java.util.Random;

// номер 8

public class task1 {
    public static void main(String[] args) {

        double[] points = new double[10];
        Random random = new Random();

        System.out.println("точки:");
        for (int i = 0; i < points.length; i++) {
            points[i] = Math.round(random.nextDouble() * 100.0 * 10.0) / 10.0;
            System.out.print(points[i] + " ");
        }
        
        System.out.println("\n\n");

        int n = points.length;
        double minSum = Double.MAX_VALUE;
        double bestPoint = points[0];

        for (int i = 0; i < n; i++) {
            double currentSum = 0;
            for (int j = 0; j < n; j++) {
                currentSum += Math.abs(points[i] - points[j]);
            }
            
            if (currentSum < minSum) {
                minSum = currentSum;
                bestPoint = points[i];
            }
        }

        System.out.println("Оптимальная точка из множества: " + bestPoint);
        System.out.println("Минимальная сумма расстояний: " + minSum);
    }
}