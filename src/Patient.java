public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String contactNumber;
    private String medicalCondition;

    public Patient(int patientId, String patientName, int age,
                   String contactNumber, String medicalCondition) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                ", Name: " + patientName +
                ", Age: " + age +
                ", Contact: " + contactNumber +
                ", Condition: " + medicalCondition;
    }
}