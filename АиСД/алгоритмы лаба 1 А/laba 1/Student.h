#ifndef STUDENT_H
#define STUDENT_H

#include <string>
#include <iostream>
using namespace std;

class Student {
private:
    // поле
    string name;
    string surname;
    int studentID;
    string group;

public:
    // конструктор
    Student(string name = "undefined",
            string surname = "undefined", 
            int studentID = 0,
            string group = "undefined-000");

    // геттеры
    string getName() const;
    string getSurname() const;
    int getStudentID() const;
    string getGroup() const;

    // сеттеры
    void setName(const string& name);
    void setSurname(const string& surname);
    void setStudentID(const int& studentID);
    void setGroup(const string& group);

    // метод для вывода информации
    void display() const;
};

#endif