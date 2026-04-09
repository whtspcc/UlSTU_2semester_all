import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Algorithm {
    // lessons - все введенные занятия
    // selected - все выбранные непересекающиеся занятия
    // arraylist выбран потому что мы не знаем сколько занятий будет в принципе

    private List<Lesson> lessons = new ArrayList<>();
    private List<Lesson> selected = new ArrayList<>();

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    // сам жадный алгоритм
    // следуя ему, мы выбираем занятие, которое заканчивается раньше всего
    public void selectLessons() {

        if (lessons.isEmpty()) {
            return;
        }

        // сортировка по времени окончания
        Collections.sort(lessons, Comparator.comparingInt(Lesson::getEnd));

        // берем самое раннее по окончанию
        selected.add(lessons.get(0));
        int lastEnd = lessons.get(0).getEnd();

        // проходимся по каждому занятию
        for (int i = 1; i < lessons.size(); i++) {

            // если занятие начинается сразу после или позже, чем закончилось предыдущее,
            // то мы его берем
            if (lessons.get(i).getStart() >= lastEnd) {
                selected.add(lessons.get(i));
                lastEnd = lessons.get(i).getEnd();
            }
        }
    }

    public List<Lesson> getSelectedLessons() {
        return selected;
    }
}