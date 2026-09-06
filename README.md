# Mini Hospital Emergency Management System

## Student Information

**Name:** MIFLA BANU MM
**Student ID:** 23Da2-1111
**Module:** CIT300 - Data Structures and Algorithms
**Assignment:** Individual Mid Assignment
**GitHub Repository:** [Paste your GitHub repository link here]

---

## Introduction

The Mini Hospital Emergency Management System is a Java-based application developed to manage patient records, emergency patients, treatment history, and patient visit history using different data structures.

The system demonstrates the practical application of Binary Search Tree, Queue, Stack, and Singly Linked List.

---

## Data Structures Used

### 1. Binary Search Tree (BST)

The Binary Search Tree is used to manage patient records based on Patient ID.

Operations:

* Insert patient
* Search patient by Patient ID
* Delete patient
* Display patients using In-order traversal

### 2. Queue

The Queue is used to manage emergency patients using the FIFO (First In, First Out) principle.

Operations:

* Enqueue patient
* Dequeue patient
* Display waiting patients
* Handle empty queue

### 3. Stack

The Stack is used to manage treatment history using the LIFO (Last In, First Out) principle.

Operations:

* Push treatment record
* Pop latest treatment record
* Display treatment history
* Handle empty stack

### 4. Singly Linked List

The Singly Linked List is used to maintain each patient's visit history.

Operations:

* Add visit
* Remove visit
* Search visit
* Display visit history

---

## Technologies Used

* Java
* Visual Studio Code
* Git
* GitHub

---

## Project Structure

```text
MiniHospitalEmergencyManagementSystem
│
├── src
│   ├── Main.java
│   ├── Patient.java
│   ├── PatientBST.java
│   ├── EmergencyQueue.java
│   ├── TreatmentStack.java
│   ├── Visit.java
│   └── VisitLinkedList.java
│
└── README.md
```

---

## Main Features

* Register new patients
* Search patients by Patient ID
* Delete patient records
* Display patients in ascending Patient ID order
* Manage emergency patient queue
* Manage treatment history
* Manage patient visit history
* Search and remove patient visits
* Handle empty Queue and Stack conditions

---

## How to Run

Open the project folder in Visual Studio Code.

Navigate to the `src` folder:

```bash
cd src
```

Compile the Java files:

```bash
javac *.java
```

Run the program:

```bash
java Main
```

---

## Data Structure Principles

**BST:** Used for efficient patient record searching and ordered display.

**Queue:** Uses FIFO (First In, First Out) for emergency patient management.

**Stack:** Uses LIFO (Last In, First Out) for treatment history.

**Singly Linked List:** Used to store and manage multiple visits for each patient.

---

## Development History

The project was developed progressively using Git and GitHub.

Example meaningful commits:

* Created project structure
* Implemented patient BST
* Added BST search and deletion
* Implemented emergency queue
* Implemented treatment stack
* Implemented patient linked list
* Added testing
* Updated README

---

## Conclusion

This project demonstrates how different data structures can be applied to solve a real-world hospital emergency management problem. It provides practical experience in implementing BST, Queue, Stack, and Singly Linked List using Java.
