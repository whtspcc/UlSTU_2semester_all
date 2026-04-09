import java.util.List;
import java.util.Random;

// Пусть даны n заявок на проведение занятий в одной и той же аудитории. 
// Два различных занятия не могут перекрываться по времени. 
// В каждой заявке указаны начало и конец занятия. 
// Разные заявки могут пересекаться, и тогда можно удовлетворить только одну из них. 
// Необходимо набрать максимальное количество совместимых друг с другом заявок.

public class Main {

    public static void main(String[] args) {

        Algorithm alg = new Algorithm();
        Random random = new Random();

        int n = 10000; // количество заявок для теста

        // генерация случайных заявок
        for (int i = 0; i < n; i++) {
            int start = random.nextInt(100);
            int duration = random.nextInt(100) + 1;
            int end = start + duration;

            alg.addLesson(new Lesson(start, end));
        }

        // замер памяти ДО 
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // очистка мусора
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // замер времени
        long startTime = System.nanoTime();

        alg.selectLessons();

        long endTime = System.nanoTime();

        // замер памяти после
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        // результаты
        List<Lesson> selected = alg.getSelectedLessons();

        System.out.println("Количество заявок: " + n);
        System.out.println("Выбрано занятий: " + selected.size());

        System.out.println("Время выполнения (мс): "  + (endTime - startTime) / 1_000_000.0);

        System.out.println("Использовано памяти (КБ): " + (memoryAfter - memoryBefore) / 1024.0);

        // вывести список selected
    }
}