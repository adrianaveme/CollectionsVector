package entities;

import java.util.Objects;

/**
 * Represents a entities.Student. <br><br>
 * Invariants:
 * 1. MAXIMUM_QUOTA > 0
 * 2. MAXIMUM_QUOTA >= number of registered students. <br><br>
 *
 * @author ADRIANA VELASQUEZ: adrianaveme@unisabana.edu.co
 */



public class Student {

    private int id;
    private String name;
    private PlanStudy planStudy;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of entities.Student or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Student)) {
            return false;
        }

        // typecast o to entities.Student so that we can compare data members
        Student s = (Student) o;

        // Compare the data members and return accordingly
        return this.id == s.getId();
    }
}
