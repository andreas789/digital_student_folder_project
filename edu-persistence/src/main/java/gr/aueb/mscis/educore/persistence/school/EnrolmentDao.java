package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Enrolment;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface EnrolmentDao extends GenericDao<Enrolment> {

    Enrolment enroll(Student student, Course course);

    boolean hasReachedMaxParticipants(Course course);

    boolean enrolmentExists(Student student, Course course);
}
