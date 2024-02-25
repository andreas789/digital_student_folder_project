package gr.aueb.mscis.educore.persistence.school.impl;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.school.CourseDao;
import org.jvnet.hk2.annotations.Service;

@Service
public class CourseDaoImpl extends AbstractDao<Course> implements CourseDao {

    @Override
    public Course saveCourse(Course course) {
        if(!course.isValidForPersistence()){
            throw new ValidationException(ExceptionMessages.INVALID_DATA);
        }
        return saveOrUpdate(course);
    }

}
