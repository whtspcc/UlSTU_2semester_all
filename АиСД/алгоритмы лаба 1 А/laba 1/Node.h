#ifndef NODE_H
#define NODE_H

#include "Student.h"

struct Node {
    Student data;
    Node* next;

    Node(Student student);
};

#endif