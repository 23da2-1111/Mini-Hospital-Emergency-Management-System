public class TreatmentStack {

    private class Node {
        String treatmentRecord;
        Node next;

        Node(String treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            this.next = null;
        }
    }

    private Node top;

    // Push treatment record
    public void push(String treatmentRecord) {

        Node newNode = new Node(treatmentRecord);

        newNode.next = top;
        top = newNode;

        System.out.println("Treatment record added to stack.");
    }

    // Pop latest treatment
    public String pop() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        String record = top.treatmentRecord;

        top = top.next;

        System.out.println("Latest treatment record removed.");

        return record;
    }

    // Display treatment history
    public void displayStack() {

        if (top == null) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\n--- Treatment History ---");

        Node current = top;

        while (current != null) {

            System.out.println(current.treatmentRecord);

            current = current.next;
        }
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}