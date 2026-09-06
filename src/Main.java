import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();

    // Each patient has their own visit linked list
    static Map<Integer, VisitLinkedList> patientVisits = new HashMap<>();

    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    treatNextEmergencyPatient();
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    addTreatmentRecord();
                    break;

                case 9:
                    removeLatestTreatment();
                    break;

                case 10:
                    treatmentStack.displayStack();
                    break;

                case 11:
                    addPatientVisit();
                    break;

                case 12:
                    removePatientVisit();
                    break;

                case 13:
                    searchPatientVisit();
                    break;

                case 14:
                    displayPatientVisits();
                    break;

                case 0:
                    System.out.println("\nThank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ==============================
    // MAIN MENU
    // ==============================

    public static void displayMenu() {

        System.out.println("\n==============================================");
        System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        System.out.println("1.  Register New Patient");
        System.out.println("2.  Search Patient");
        System.out.println("3.  Delete Patient");
        System.out.println("4.  Display All Patients");

        System.out.println("5.  Add Patient to Emergency Queue");
        System.out.println("6.  Treat Next Emergency Patient");
        System.out.println("7.  Display Emergency Queue");

        System.out.println("8.  Add Treatment Record");
        System.out.println("9.  Remove Latest Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Patient Visit History");

        System.out.println("0.  Exit");

        System.out.println("==============================================");
    }

    // ==============================
    // PATIENT BST
    // ==============================

    public static void registerPatient() {

        System.out.println("\n--- Register New Patient ---");

        int id = readInt("Enter Patient ID: ");

        if (patientBST.search(id) != null) {
            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = readInt("Enter Age: ");

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);

        // Create an empty visit linked list for the patient
        patientVisits.put(id, new VisitLinkedList());

        System.out.println("Patient registered successfully.");
    }

    public static void searchPatient() {

        System.out.println("\n--- Search Patient ---");

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient != null) {
            System.out.println("\nPatient Found:");
            System.out.println(patient);
        }
        else {
            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {

        System.out.println("\n--- Delete Patient ---");

        int id = readInt("Enter Patient ID: ");

        if (patientBST.search(id) == null) {
            System.out.println("Patient not found.");
            return;
        }

        patientBST.delete(id);

        patientVisits.remove(id);
    }

    // ==============================
    // EMERGENCY QUEUE
    // ==============================

    public static void addEmergencyPatient() {

        System.out.println("\n--- Add Patient to Emergency Queue ---");

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found. Please register patient first.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    public static void treatNextEmergencyPatient() {

        System.out.println("\n--- Treat Next Emergency Patient ---");

        Patient patient = emergencyQueue.dequeue();

        if (patient != null) {

            System.out.println("\nNow treating:");
            System.out.println(patient);

            System.out.println(
                    "Treatment completed for Patient ID: "
                            + patient.getPatientId()
            );
        }
    }

    // ==============================
    // TREATMENT STACK
    // ==============================

    public static void addTreatmentRecord() {

        System.out.println("\n--- Add Treatment Record ---");

        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        String record =
                "Patient ID: " + patientId +
                " | Doctor: " + doctor +
                " | Treatment: " + treatment;

        treatmentStack.push(record);
    }

    public static void removeLatestTreatment() {

        System.out.println("\n--- Remove Latest Treatment ---");

        String record = treatmentStack.pop();

        if (record != null) {
            System.out.println("\nRemoved Record:");
            System.out.println(record);
        }
    }

    // ==============================
    // PATIENT VISIT LINKED LIST
    // ==============================

    public static void addPatientVisit() {

        System.out.println("\n--- Add Patient Visit ---");

        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history = patientVisits.get(patientId);

        if (history == null) {
            history = new VisitLinkedList();
            patientVisits.put(patientId, history);
        }

        System.out.print("Enter Visit ID: ");
        String visitId = scanner.nextLine();

        if (history.searchVisit(visitId) != null) {
            System.out.println("Visit ID already exists.");
            return;
        }

        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        history.addVisit(visit);
    }

    public static void removePatientVisit() {

        System.out.println("\n--- Remove Patient Visit ---");

        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history = patientVisits.get(patientId);

        if (history == null || history.isEmpty()) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.print("Enter Visit ID to remove: ");
        String visitId = scanner.nextLine();

        if (history.removeVisit(visitId)) {
            System.out.println("Visit removed successfully.");
        }
        else {
            System.out.println("Visit not found.");
        }
    }

    public static void searchPatientVisit() {

        System.out.println("\n--- Search Patient Visit ---");

        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history = patientVisits.get(patientId);

        if (history == null || history.isEmpty()) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.print("Enter Visit ID to search: ");
        String visitId = scanner.nextLine();

        Visit visit = history.searchVisit(visitId);

        if (visit != null) {
            System.out.println("\nVisit Found:");
            System.out.println(visit);
        }
        else {
            System.out.println("Visit not found.");
        }
    }

    public static void displayPatientVisits() {

        System.out.println("\n--- Display Patient Visit History ---");

        int patientId = readInt("Enter Patient ID: ");

        if (patientBST.search(patientId) == null) {
            System.out.println("Patient not found.");
            return;
        }

        VisitLinkedList history = patientVisits.get(patientId);

        if (history == null) {
            System.out.println("No visit history available.");
            return;
        }

        history.displayVisits();
    }

    // ==============================
    // INPUT HELPER
    // ==============================

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                int value = Integer.parseInt(scanner.nextLine());

                return value;

            }
            catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }
}