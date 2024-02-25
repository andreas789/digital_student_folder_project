package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface CourseDao extends GenericDao<Course> {

    Course saveCourse(Course course);
}
