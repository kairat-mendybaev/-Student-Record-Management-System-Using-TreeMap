import java.util.TreeMap;

public class StudentRecordManager {
    TreeMap<Integer, Student> studentRecords;

    public StudentRecordManager() {
        studentRecords = new TreeMap<>();
    }

    public boolean addStudentRecord(int id, String name, double gpa) {
        if (!studentRecords.containsKey(id)) {
            studentRecords.put(id, new Student(id, name, gpa));
            return true;
        }
        return false;
    }

    public boolean deleteStudentRecord(int id) {
        if (studentRecords.containsKey(id)) {
            studentRecords.remove(id);
            return true;
        }
        return false;
    }

    public boolean updateStudentGPA(int id, double newGpa) {
        if (studentRecords.containsKey(id)) {
            Student student = studentRecords.get(id);
            student.setGpa(newGpa);
            return true;
        }
        return false;
    }

    public void displayAllRecords() {
        studentRecords.values().forEach(System.out::println);
    }

    public void findStudentsWithGPAHigherThan(double gpa) {
        studentRecords.values().stream()
                .filter(student -> student.getGpa() > gpa)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();
        manager.addStudentRecord(1, "Alice", 3.5);
        manager.addStudentRecord(2, "Bob", 3.8);
        manager.addStudentRecord(3, "Charlie", 2.9);
        manager.addStudentRecord(4, "David", 3.6);
        manager.addStudentRecord(5, "Eva", 3.9);

        System.out.println("All Records:");
        manager.displayAllRecords();

        System.out.println("\nUpdating GPA for ID 3:");
        manager.updateStudentGPA(3, 3.2);
        manager.displayAllRecords();

        System.out.println("\nDeleting Record for ID 5:");
        manager.deleteStudentRecord(5);
        manager.displayAllRecords();

        System.out.println("\nStudents with GPA higher than 3.0:");
        manager.findStudentsWithGPAHigherThan(3.0);
    }
}

class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
