#ifndef STUDENTSTACK_H
#define STUDENTSTACK_H

#include "Node.h"

class StudentStack {
private:
    Node* head;
    int size;

public:
    StudentStack();
    ~StudentStack();

    void push(Student student);
    Student pop();
    Student peek() const;
    int getSize() const;
    bool isEmpty() const;
    void print() const;

    void clear();

    void shakerSortByID();
};

#endif