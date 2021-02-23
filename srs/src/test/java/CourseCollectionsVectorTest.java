
import collections.CourseVector;
import collections.CourseCollectionsExample;
import entities.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseCollectionsVectorTest {

    @Test
    @DisplayName("GIVEN student WHEN add student THEN should allow")
    void shouldAddAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);
    }

    @Test
    @DisplayName("GIVEN student WHEN add student THEN should not allow")
    void shouldNotAddAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(1, "Pedro");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertFalse(course.addStudent(student2), "The student was not successfully registered");
        assertEquals(course.numRegisteredStudents(), 1);
    }

    @Test
    @DisplayName("GIVEN add student WHEN no quota THEN should not allow")
    void shouldNotAddAStudentWhenNoQuota() {

        Student student1 = new Student(1, "Juan");
        CourseCollectionsExample course = new CourseVector();

        for (int i = 0; i < course.numMaxStudents(); i++)
            course.addStudent(new Student(i, "Juan " + i));

        assertFalse(course.addStudent(student1), "The student was not successfully registered");
        assertEquals(course.numRegisteredStudents(), course.numMaxStudents());
    }

    @Test
    @DisplayName("GIVEN student WHEN remove student THEN should allow")
    void shouldRemoveAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertTrue(course.removeStudent(student1), "The student was successfully removed");
        assertEquals(course.numRegisteredStudents(), 1);
    }

    @Test
    @DisplayName("GIVEN student WHEN remove student THEN should not allow")
    void shouldNotRemoveAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        Student student3 = new Student(3, "Maria");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertFalse(course.removeStudent(student3), "The student was not successfully removed");
        assertEquals(course.numRegisteredStudents(), 2);
    }

    @Test
    @DisplayName("GIVEN student WHEN get student THEN should allow")
    void shouldGetAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertEquals(course.getStudent(student1), student1, "get the right student");
    }

    @Test
    @DisplayName("GIVEN student WHEN get student THEN should not allow")
    void shouldNotGetAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        Student student3 = new Student(3, "Maria");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertNull(course.getStudent(student3), "the student does not exists");
    }


    @Test
    @DisplayName("GIVEN student WHEN update a student THEN should allow")
    void shouldUpdateAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        Student student3 = new Student(1, "Maria");
        assertNotNull(course.updateStudent(student3), "get the right student");
        assertEquals(course.getStudent(student1).getName(), student3.getName(), "The student was updated");
    }

    @Test
    @DisplayName("GIVEN student WHEN update a student THEN should not allow")
    void shouldNotUpdateAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        Student student3 = new Student(3, "Maria");
        CourseCollectionsExample course = new CourseVector();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertNull(course.updateStudent(student3), "the student does not exists");
    }
}
