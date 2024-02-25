package gr.aueb.mscis.educore.persistence.util;

import gr.aueb.mscis.educore.model.auth.Session;
import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.model.auth.UserRole;
import gr.aueb.mscis.educore.model.core.CoreEntity;
import gr.aueb.mscis.educore.model.core.Person;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.model.school.*;
import gr.aueb.mscis.educore.persistence.GenericDao;
import gr.aueb.mscis.educore.persistence.auth.impl.SessionDaoImpl;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import gr.aueb.mscis.educore.persistence.evaluation.impl.EvaluationDaoImpl;
import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.persistence.school.impl.CourseDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.EnrolmentDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.GuardianDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.OwnerDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.StudentDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.TeacherDaoImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.UUID;

public class DataFactory {

    public static Owner getValidOwner(){
        return getValidOwner(false);
    }

    public static Owner getValidOwner(boolean persistedUser){
        Owner owner = new Owner();
        owner.setUser(getValidUser(UserRole.OWNER, true));
        setPersonData(owner);
        return persistedUser?DaoFactory.getOwnerDao().saveOrUpdate(owner):owner;
    }

    public static Teacher getValidTeacher(){
        return getValidTeacher(false);
    }

    public static Teacher getValidTeacher(boolean persistedUser){
        Teacher teacher = new Teacher();
        teacher.setUser(getValidUser(UserRole.TEACHER, true));
        setPersonData(teacher);
        return persistedUser?DaoFactory.getTeacherDao().saveOrUpdate(teacher):teacher;
    }

    public static Guardian getValidGuardian(){
        return getValidGuardian(false);
    }

    public static Guardian getValidGuardian(boolean persistedUser){
        Guardian guardian = new Guardian();
        guardian.setUser(getValidUser(UserRole.GUARDIAN, true));
        setPersonData(guardian);
        return persistedUser?DaoFactory.getGuardianDao().saveOrUpdate(guardian):guardian;
    }

    private static void setPersonData(Person person) {
        person.setAddress("Odos 123");
        person.setBirthdate(LocalDate.of(1980, Month.JANUARY,1));
        person.setEmail("test@test.gr");
        person.setName("Nikos");
        person.setSurname("Papadopoulos");
        person.setPhone("2102121999");
    }

    private static User getValidUser(UserRole role, boolean persistedUser) {
        User user = new User();
        user.setUserRole(role);
        user.setUsername("admin");
        user.setPassword("Pass1234");
        user.setNickname("npapadopoulos");
        return persistedUser?DaoFactory.getUserDao().saveOrUpdate(user) : user;
    }

    public static Course getValidCourse() {
        return getValidCourse(false);
    }

    public static Course getValidCourse(boolean persisted) {
        Course course = new Course();
        course.setCode("code1");
        course.setDescription("description");
        course.setMaxParticipants(10);
        course.setName("course_Name");
        course.setTeacher(DataFactory.getValidTeacher(true));
        return persisted ? DaoFactory.getCourseDao().saveCourse(course) : course;
    }

    public static Student getValidStudent() {
        return getValidStudent(false);
    }

    public static Student getValidStudent(boolean persisted) {
        Student student = new Student();
        student.setCondition("asperger");
        setPersonData(student);
        return persisted ? DaoFactory.getStudentDao().saveOrUpdate(student) : student;
    }

    public static Evaluation getValidEvaluation() {
        return getValidEvaluation(false);
    }

    public static Evaluation getValidEvaluation(boolean persisted) {
        Evaluation evaluation = new Evaluation();
        evaluation.setStudent(DataFactory.getValidStudent(true));
        evaluation.setCourse(DataFactory.getValidCourse(true));
        evaluation.setBehavior(1);
        evaluation.setCommunication(2);
        evaluation.setCooperation(3);
        evaluation.setHomework(4);
        evaluation.setParticipationInClass(5);

        return persisted?DaoFactory.getEvaluationDao().saveOrUpdate(evaluation) : evaluation;
    }

    public static CoreEntity getValidEnrollment() {
        Enrolment enrolment = new Enrolment();
        enrolment.setStudent(getValidStudent(true));
        enrolment.setCourse(getValidCourse(true));
        enrolment.setRegistrationDate(LocalDate.now());
        enrolment.setRegistrationNumber(UUID.randomUUID().toString());
        return enrolment;
    }

    public static Session getValidSession() {
        Session session = new Session();
        session.setCreation(new Date());
        session.setExpiration(new Date());
        session.setToken(UUID.randomUUID().toString());
        session.setUser(getValidUser(UserRole.OWNER, true));
        return session;
    }

    public static CoreEntity getProperValidEntity(GenericDao dao) {
        if (dao instanceof StudentDaoImpl) {
            return getValidStudent();
        }
        else if (dao instanceof EvaluationDaoImpl) {
            return getValidEvaluation();
        }
        else if (dao instanceof CourseDaoImpl) {
            return getValidCourse();
        }
        else if (dao instanceof GuardianDaoImpl) {
            return getValidGuardian(true);
        }
        else if (dao instanceof OwnerDaoImpl) {
            return getValidOwner(true);
        }
        else if (dao instanceof TeacherDaoImpl) {
            return getValidTeacher(true);
        }
        else if (dao instanceof EnrolmentDaoImpl) {
            return getValidEnrollment();
        }
        else if (dao instanceof UserDaoImpl) {
            return getValidUser(UserRole.OWNER,false);
        }
        else if (dao instanceof SessionDaoImpl) {
            return getValidSession();
        }
        else {
            throw new UnsupportedOperationException("Cannot get proper valid entity for this class:" + dao.getClass());
        }
    }

}
