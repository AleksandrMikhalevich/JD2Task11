package managment.implementation;

import courses.dao.EntityDaoImplStudent;
import courses.entity.Course;
import courses.entity.Student;
import courses.entity.Task;
import managment.interfaces.StudentService;

/**
 * @author Alex Mikhalevich
 * @version 1.0
 * @created 2022-04-27 12:39
 */
public class StudentServiceImpl implements StudentService {

    private final EntityDaoImplStudent studentDao = new EntityDaoImplStudent();

    @Override
    public Student register(String name, String surname) {
        Student student = Student.builder()
                .name(name)
                .surname(surname)
                .build();
        studentDao.insert(student);
        return student;
    }

    @Override
    public void enrollInCourse(Student student, Course course) {
        System.out.println("Вы успешно записаны на курс:");
        studentDao.enrollInCourse(student, course);
        System.out.println(course.getDescription());
        System.out.println(student);
    }

    @Override
    public Task searchInTasks(int id) {
        return studentDao.searchInTasks(id);
    }
}
