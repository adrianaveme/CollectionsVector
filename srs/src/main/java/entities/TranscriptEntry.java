package entities;

public class TranscriptEntry {

    private Course courseTaken;
    private int grade;

    public TranscriptEntry(Course courseTaken, int grade) {
        this.courseTaken = courseTaken;
        this.grade = grade;
    }

    public Course getCourseTaken() {
        return courseTaken;
    }

    public int getGrade() {
        return grade;
    }
}
