package collections;

import entities.Student;

public interface CourseCollectionsExample {

    int numMaxStudents();

    int numRegisteredStudents();

    //CRUD
    boolean addStudent(Student s);

    boolean removeStudent(Student s);

    Student getStudent(Student s);

    Student updateStudent(Student s);

}
