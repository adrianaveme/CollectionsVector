package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Transcript {

    public static final int MIN_APPROVED_GRADE = 3;
    private List<TranscriptEntry> entries;

    public Transcript() {
        this.entries = new ArrayList<>();
    }

    public boolean addTranscriptEntry(Course courseTaken, int grade) {
        TranscriptEntry entry = new TranscriptEntry(courseTaken, grade);
        return this.entries.add(entry);
    }

    public boolean addTranscriptEntry(TranscriptEntry entry) {
        return this.entries.add(entry);
    }

    public boolean isApproved(Course course) {
        Optional<TranscriptEntry> entry = this.entries.stream()
                .filter(e -> e.getCourseTaken().equals(course) && e.getGrade() >= MIN_APPROVED_GRADE)
                .findFirst();
        return entry.isPresent();
    }

    public boolean isApproved(List<Course> courses) {
        return courses.stream()
                .map(c->isApproved(c))
                .allMatch(a->true);
    }

    public double getAverageGrade() {
        double average = 0;

        if (this.entries.size() > 0) {
            for (TranscriptEntry entry : this.entries) {
                average += entry.getGrade();
            }
            average = average / this.entries.size();
        }
        return average;
    }
}
