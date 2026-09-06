public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    // Enqueue - Add patient
    public void enqueue(Patient patient) {

        Node newNode = new Node(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Patient added to emergency queue.");
    }

    // Dequeue - Remove first patient
    public Patient dequeue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println("Patient removed from emergency queue.");

        return patient;
    }

    // Display queue
    public void displayQueue() {

        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n--- Emergency Waiting Queue ---");

        Node current = front;

        while (current != null) {

            System.out.println(current.patient);

            current = current.next;
        }
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}