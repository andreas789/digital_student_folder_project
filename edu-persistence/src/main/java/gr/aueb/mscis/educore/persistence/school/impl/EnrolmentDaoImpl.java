package gr.aueb.mscis.educore.persistence.school.impl;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Enrolment;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.school.EnrolmentDao;
import org.jvnet.hk2.annotations.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class EnrolmentDaoImpl extends AbstractDao<Enrolment> implements EnrolmentDao {

    @Override
    public Enrolment enroll(Student student,Course course) {
        if(enrolmentExists (student, course)){
            throw new ValidationException(ExceptionMessages.ENROLMENT_EXISTS);
        }
        if(hasReachedMaxParticipants(course)){
            throw new ValidationException(ExceptionMessages.MAX_PARTICIPANTS_REACHED);
        }
        Enrolment enrolment = new Enrolment();
        enrolment.setStudent(student);
        enrolment.setCourse(course);
        enrolment.setRegistrationDate(LocalDate.now());
        enrolment.setRegistrationNumber(UUID.randomUUID().toString());

        Enrolment createdEnrolment = saveOrUpdate(enrolment);
        return createdEnrolment;
    }

    @Override
    public boolean hasReachedMaxParticipants(Course course) {
        return ((Long)entityManager.createQuery("select count(e) from Enrolment e where e.course=?1")
                .setParameter(1, course)
                .getSingleResult())
                .intValue()==course.getMaxParticipants();
    }

    @Override
    public boolean enrolmentExists(Student student, Course course) {
        return ((Long)entityManager.createQuery("select count(e) from Enrolment e where e.course=?1 and e.student=?2")
                .setParameter(1, course)
                .setParameter(2, student)
                .getSingleResult())
                .intValue()>0;
    }

}
