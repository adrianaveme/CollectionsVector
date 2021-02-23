import entities.Course;
import entities.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    @DisplayName("GIVEN a course WHEN register a student THEN should allow")
    void shouldAllowRegisterAStudent() {

        Student student = new Student(1, "Juan");
        Course course = new Course(1, "Programación Orientada a Objetos");

        boolean success = course.register(student);

        assertTrue(success, "The student was successfully registered");
    }

    @Test
    @DisplayName("GIVEN a course with quota WHEN register a student that is currently registered THEN should not allow")
    void shouldNotAllowRegisterARegisteredStudent() {

        Student student1 = new Student(1, "Juan");
        Student student2 = new Student(1, "Pedro");
        Course course = new Course(1, "Programación Orientada a Objetos");

        assertTrue(course.register(student1), "The student was successfully registered");
        assertFalse(course.register(student2), "The student was not successfully registered");
    }

    @Test
    @DisplayName("GIVEN a course without quota WHEN register a student THEN should not allow")
    void shouldNotAllowRegisterAStudent() {

        Course course = new Course(1, "Programación Orientada a Objetos");

        for (int i = 0; i < Course.MAXIMUM_QUOTA; i++) {
            int id = i + 1;
            boolean result = course.register(new Student(id, "Juan " + id));
            assertTrue(result, "The student " + id + " was successfully registered");
        }

        Student student = new Student(Course.MAXIMUM_QUOTA + 1, "Juan");

        assertFalse(course.register(student), "The student was not successfully registered");
    }

}
