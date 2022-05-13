package managment.interfaces;

import courses.entity.Course;
import courses.entity.Student;
import courses.entity.Task;

/**
 * @author Alex Mikhalevich
 * @version 1.0
 * @created 2022-04-27 21:57
 */
public interface StudentService {

    Student register(String name, String surname);

    void enrollInCourse(Student student, Course course);

    Task searchInTasks(int id);

}
