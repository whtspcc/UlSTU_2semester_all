public class Lesson {
    // каждый экземпляр класса Lesson имеет start и end
    private int start;
    private int end;

    // конструктор
    public Lesson(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // геттеры
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }
}