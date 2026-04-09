#include <iostream>
#include "StudentStack.h"
using namespace std;

int main() {
    StudentStack stack;

    // добавление студентов
    stack.push(Student("Иван", "Пупкин", 101, "A-1"));
    stack.push(Student("Арарат", "Универкин", 13, "A-2"));
    stack.push(Student("Саня", "Жуев", 112, "A-2"));
    stack.push(Student("Леха", "Иксигрекзэтов", 104, "A-2"));
    stack.push(Student("Артем", "Зэтигрекиксов", 95, "A-2"));
    stack.push(Student("Алёна", "Камбоджо", 94, "A-2"));

    cout << "=== Исходный стек ===" << endl;
    stack.print();

    // Тестируем сортировки
    cout << "\n=== После шейкерной сортировки ===" << endl;
    stack.print();

    return 0;
}