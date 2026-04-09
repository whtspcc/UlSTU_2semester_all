#include "Student.h"
// реализация методов

Student::Student(string name, string surname, int studentID, string group) :
    name(name), surname(surname), studentID(studentID), group(group) {}

string Student::getName() const {
    return name;
}
string Student::getSurname() const {
    return surname;
}
int Student::getStudentID() const {
    return studentID;
}
string Student::getGroup() const {
    return group;
}

void Student::setName(const string& name) {
    this->name = name;
}
void Student::setSurname(const string& surname) {
    this->surname = surname;
}
void Student::setStudentID(const int& id) {
    this->studentID = id;
}
void Student::setGroup(const string& group) {
    this->group = group;
}

void Student::display() const {
    cout << "Студент: " << name << " " << surname << endl;
    cout << "ID: " << studentID << endl;
    cout << "Группа: " << group << endl; 
}