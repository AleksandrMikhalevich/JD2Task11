package courses.dao;

import courses.entity.Course;
import courses.entity.Student;
import courses.entity.Task;
import courses.util.HibernateUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.Set;

public class EntityDaoImplStudent extends EntityDaoImpl<Student> {

    private static EntityManager em;

    public EntityDaoImplStudent() {
        super(Student.class);
    }

    public void enrollInCourse(Student student, Course course) {
        em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            student.setCourses(Set.of(course));
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Task searchInTasks(int id) {
        em = HibernateUtil.getEntityManager();
        Task taskToFind = null;
        try {
            em.getTransaction().begin();
            taskToFind = em.find(Task.class, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return taskToFind;
    }
}
