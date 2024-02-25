package gr.aueb.mscis.educore.service.school.impl;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.school.impl.CourseDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.TeacherDaoImpl;
import gr.aueb.mscis.educore.service.school.CourseService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Inject
    CourseDaoImpl courseDao;

    @Inject
    TeacherDaoImpl teacherDao;

    @Override
    public Course saveCourse(Long teacherId, Course course) {
        Teacher teacher = teacherDao.findOne(teacherId);
        course.setTeacher(teacher);
        return courseDao.saveOrUpdate(course);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseDao.deleteById(courseId);

    }

    @Override
    public List<Course> searchCourses(SearchParameters params) {
        return courseDao.search(params);
    }

    @Override
    public Course findCourseById(Long courseId) {
        return courseDao.findOne(courseId);
    }

    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }

    public void setTeacherDao(TeacherDaoImpl teacherDao) {
        this.teacherDao = teacherDao;
    }
}

