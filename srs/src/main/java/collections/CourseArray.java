package collections;

import entities.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.Vector;

public class CourseArray implements CourseCollectionsExample {

    public static final int MAXIMUM_QUOTA = 30;

    //ARRAY OF STUDENTS
    private Student[] students;

    public CourseArray() {
        this.students = new Student[MAXIMUM_QUOTA];
    }

    @Override
    public int numMaxStudents() {
        return MAXIMUM_QUOTA;
    }

    @Override
    public int numRegisteredStudents() {
        int count = 0;
        for (int i = 0; i < MAXIMUM_QUOTA; i++) {
            if (students[i] != null)
                count++;
        }
        return count;
    }

    @Override
    public boolean addStudent(Student s) {
        int i = 0;
        boolean result = false;
        boolean exists = false;

        while (i < MAXIMUM_QUOTA && students[i] != null && !exists) {
            exists = students[i].equals(s);
            i++;
        }

        if (i < MAXIMUM_QUOTA && !exists) {
            students[i] = s;
            result = true;
        }

        return result;
    }

    @Override
    public boolean removeStudent(Student s) {
        boolean result = false;
        int index = getStudentIndex(s);

        if (index != Integer.MIN_VALUE) {
            students[index] = null;
            for (int i = index; i < MAXIMUM_QUOTA - 1; i++) {
                students[i] = students[i + 1];
            }
            result = true;
        }

        return result;
    }

    @Override
    public Student getStudent(Student s) {

        Student result = null;
        int index = getStudentIndex(s);

        if (index != Integer.MIN_VALUE) {
            result = students[index];
        }

        return result;
    }

    @Override
    public Student updateStudent(Student s) {

        Student result = null;
        int index = getStudentIndex(s);

        if (index != Integer.MIN_VALUE) {
            students[index] = s;
            result = students[index];
        }

        return result;
    }

    private int getStudentIndex(Student s) {
        int i = 0;
        boolean exists = false;

        while (i < MAXIMUM_QUOTA && students[i] != null && !exists) {
            exists = students[i].equals(s);
            i++;
        }

        if (exists)
            return i - 1;
        else
            return Integer.MIN_VALUE;
    }
}
