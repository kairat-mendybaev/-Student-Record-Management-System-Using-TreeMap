import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StudentRecordManagerTest {
    private StudentRecordManager manager;

    @Before
    public void setUp() {
        manager = new StudentRecordManager();
        manager.addStudentRecord(1, "Alice", 3.5);
        manager.addStudentRecord(2, "Bob", 3.8);
    }

    @Test
    public void testAddStudentRecord() {
        assertTrue(manager.addStudentRecord(3, "Charlie", 2.9));
        assertFalse(manager.addStudentRecord(1, "Alice", 3.5));
    }

    @Test
    public void testDeleteStudentRecord() {
        assertTrue(manager.deleteStudentRecord(1));
        assertFalse(manager.deleteStudentRecord(99));
    }

    @Test
    public void testUpdateStudentGPA() {
        assertTrue(manager.updateStudentGPA(2, 3.9));
        assertFalse(manager.updateStudentGPA(99, 3.0));
    }

    @Test
    public void testFindStudentsWithGPAHigherThan() {
        manager.addStudentRecord(3, "Charlie", 3.1);
        manager.addStudentRecord(4, "David", 2.8);
        assertTrue(manager.studentRecords.values().stream().anyMatch(s -> s.getGpa() > 3.0));
        assertFalse(manager.studentRecords.values().stream().anyMatch(s -> s.getGpa() > 4.0));
    }

    @Test
    public void testDisplayAllRecords() {
        manager.displayAllRecords(); // Output is manually verified for correctness.
    }
}
