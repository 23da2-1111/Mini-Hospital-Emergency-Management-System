public class VisitLinkedList {

    private class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private Node head;

    // Add new visit
    public void addVisit(Visit visit) {

        Node newNode = new Node(visit);

        if (head == null) {
            head = newNode;
        }
        else {

            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Search visit
    public Visit searchVisit(String visitId) {

        Node current = head;

        while (current != null) {

            if (current.visit.getVisitId().equalsIgnoreCase(visitId)) {
                return current.visit;
            }

            current = current.next;
        }

        return null;
    }

    // Remove visit
    public boolean removeVisit(String visitId) {

        if (head == null) {
            return false;
        }

        // If first node is the required visit
        if (head.visit.getVisitId().equalsIgnoreCase(visitId)) {

            head = head.next;

            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId()
                    .equalsIgnoreCase(visitId)) {

                current.next = current.next.next;

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display visit history
    public void displayVisits() {

        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("\n--- Patient Visit History ---");

        Node current = head;

        while (current != null) {

            System.out.println(current.visit);

            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}