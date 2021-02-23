import collections.CourseArrayList;
import collections.CourseCollectionsExample;
import entities.Course;
import entities.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseCollectionsTest {

    @Test
    void shouldAddAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);
    }

    @Test
    void shouldNotAddAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(1, "Pedro");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertFalse(course.addStudent(student2), "The student was not successfully registered");
        assertEquals(course.numRegisteredStudents(), 1);
    }

    @Test
    void shouldNotAddAStudentWhenNoQuota() {

        Student student1 = new Student(1, "Juan");
        CourseCollectionsExample course = new CourseArrayList();

        for (int i = 0; i < course.numMaxStudents(); i++)
            course.addStudent(new Student(i, "Juan " + i));

        assertFalse(course.addStudent(student1), "The student was not successfully registered");
        assertEquals(course.numRegisteredStudents(), course.numMaxStudents());
    }

    @Test
    void shouldRemoveAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertTrue(course.removeStudent(student1), "The student was successfully removed");
        assertEquals(course.numRegisteredStudents(), 1);
    }

    @Test
    void shouldNotRemoveAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        Student student3 = new Student(3, "Maria");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertFalse(course.removeStudent(student3), "The student was not successfully removed");
        assertEquals(course.numRegisteredStudents(), 2);
    }

    @Test
    void shouldGetAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertEquals(course.getStudent(student1), student1, "get the right student");
    }

    @Test
    void shouldNotGetAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        Student student3 = new Student(3, "Maria");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertNull(course.getStudent(student3), "the student does not exists");
    }


    @Test
    void shouldUpdateAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        Student student3 = new Student(1, "Maria");
        assertNotNull(course.updateStudent(student3), "get the right student");
        assertEquals(course.getStudent(student1).getName(), student3.getName(), "The student was updated");
    }

    @Test
    void shouldNotUpdateAStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(2, "Pedro");
        Student student3 = new Student(3, "Maria");
        CourseCollectionsExample course = new CourseArrayList();

        assertTrue(course.addStudent(student1), "The student was successfully registered");
        assertTrue(course.addStudent(student2), "The student was successfully registered");
        assertEquals(course.numRegisteredStudents(), 2);

        assertNull(course.updateStudent(student3), "the student does not exists");
    }
}
