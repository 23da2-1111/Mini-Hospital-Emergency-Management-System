public class PatientBST {

    // Node for the Binary Search Tree
    private class Node {
        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node current, Patient patient) {

        if (current == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < current.patient.getPatientId()) {
            current.left = insertRecursive(current.left, patient);
        }
        else if (patient.getPatientId() > current.patient.getPatientId()) {
            current.right = insertRecursive(current.right, patient);
        }
        else {
            System.out.println("Patient ID already exists.");
        }

        return current;
    }

    // Search patient by ID
    public Patient search(int patientId) {

        Node result = searchRecursive(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId == current.patient.getPatientId()) {
            return current;
        }

        if (patientId < current.patient.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }

        return searchRecursive(current.right, patientId);
    }

    // Delete patient
    public void delete(int patientId) {

        if (search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        root = deleteRecursive(root, patientId);
        System.out.println("Patient deleted successfully.");
    }

    private Node deleteRecursive(Node current, int patientId) {

        if (current == null) {
            return null;
        }

        if (patientId < current.patient.getPatientId()) {
            current.left = deleteRecursive(current.left, patientId);
        }
        else if (patientId > current.patient.getPatientId()) {
            current.right = deleteRecursive(current.right, patientId);
        }
        else {

            // Case 1: No child
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (current.left == null) {
                return current.right;
            }

            // Case 3: Only left child
            if (current.right == null) {
                return current.left;
            }

            // Case 4: Two children
            Node successor = findMinimum(current.right);
            current.patient = successor.patient;

            current.right = deleteRecursive(
                    current.right,
                    successor.patient.getPatientId()
            );
        }

        return current;
    }

    // Find minimum node
    private Node findMinimum(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // In-order traversal
    public void displayInOrder() {

        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }

        System.out.println("\n--- Patients in Ascending Patient ID ---");
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node current) {

        if (current != null) {

            inOrderRecursive(current.left);

            System.out.println(current.patient);

            inOrderRecursive(current.right);
        }
    }
}