#include "StudentStack.h"
#include <iostream>
using namespace std;

// конструктор
StudentStack::StudentStack() : head(nullptr), size(0) {}

// деструктор
StudentStack::~StudentStack() {
    clear();
}

// очистка стека
void StudentStack::clear() {
    while(head != nullptr) {
        Node* temp = head;
        head = head -> next;
        delete temp;
    }
    size = 0;
}

// добавление элемента
void StudentStack::push(Student student) {
    Node* newNode = new Node(student);
    newNode->next = head;
    head = newNode;
    size++;
}

// удаление элемента
Student StudentStack::pop() {
    if (head == nullptr) return Student();

    Node* temp = head;
    Student poppedStudent = head->data;
    head = head->next;
    delete temp;
    size--;

    return poppedStudent;
}

// просмотр вершины
Student StudentStack::peek() const {
    if (head == nullptr) return Student();
    return head->data;
}

// получение размера
int StudentStack::getSize() const {
    return size;
}

// проверка на пустоту
bool StudentStack::isEmpty() const {
    return head == nullptr;
}

// вывод в консоль
void StudentStack::print() const {
    if (head == nullptr) {
        cout << "Стек пуст" << endl;
        return;
    }

    Node* temp = head;
    int counter = 1;
    while (temp != nullptr) {
        cout << "Элемент " << counter++ << ":" << endl;
        temp->data.display();
        temp = temp->next;
    }
    cout << "nullptr" << endl;
}

// сортировки

// shaker sort
void StudentStack::shakerSortByID() {
    if (size < 2) return;

    bool swapped = true;
    int left = 0;
    int right = size - 1;

    while (left < right && swapped) {
        swapped = false;

        // Проход слева направо (пузырек)
        Node* curr = head;
        // Доходим до нужной позиции
        for (int i = 0; i < left; i++) curr = curr->next;

        for (int i = left; i < right; i++) {
            if (curr->data.getStudentID() > curr->next->data.getStudentID()) {
                // Меняем данные местами
                Student temp = curr->data;
                curr->data = curr->next->data;
                curr->next->data = temp;
                swapped = true;
            }
            curr = curr->next;
        }
        right--;

        if (!swapped) break;
        swapped = false;

        // Проход справа налево 
        // В односвязном списке приходится каждый раз начинать с начала, 
        // чтобы имитировать движение "назад"
        curr = head;
        for (int i = 0; i < left; i++) curr = curr->next;

        for (int i = left; i < right; i++) {
            if (curr->data.getStudentID() > curr->next->data.getStudentID()) {
                Student temp = curr->data;
                curr->data = curr->next->data;
                curr->next->data = temp;
                swapped = true;
            }
            curr = curr->next;
        }
        left++;
    }
}
