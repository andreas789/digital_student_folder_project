package gr.aueb.mscis.educore.service.school;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.school.*;

import java.util.List;

public interface CourseService {
    Course saveCourse(Long teacherId, Course course);
    void deleteCourse(Long courseId);
    List<Course> searchCourses(SearchParameters params);

    Course findCourseById(Long courseId);
}
