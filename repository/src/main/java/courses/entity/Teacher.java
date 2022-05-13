package courses.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Class Teacher
 */
@Getter
@Setter
@Entity(name = "Teacher")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "TEACHER")
public class Teacher extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Connection with table "Course"
     */
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "teacher_courses",
            joinColumns = {@JoinColumn(name = "id_teacher")},
            inverseJoinColumns = {@JoinColumn(name = "id_course")}
    )
    @ToString.Exclude
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                '}';
    }
}
