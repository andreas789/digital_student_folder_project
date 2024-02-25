package gr.aueb.mscis.educore.persistence.factory;

import gr.aueb.mscis.educore.persistence.auth.impl.SessionDaoImpl;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import gr.aueb.mscis.educore.persistence.evaluation.impl.EvaluationDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.CourseDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.EnrolmentDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.GuardianDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.OwnerDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.StudentDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.TeacherDaoImpl;
import org.jvnet.hk2.annotations.Service;

@Service
public class DaoFactory {
    static EvaluationDaoImpl evaluationDao;
    static CourseDaoImpl courseDao;
    static EnrolmentDaoImpl enrolmentDao;
    static GuardianDaoImpl guardianDao;
    static OwnerDaoImpl ownerDao;
    static StudentDaoImpl studentDao;
    static TeacherDaoImpl teacherDao;
    static SessionDaoImpl sessionDao;
    static UserDaoImpl userDao;

    public static EvaluationDaoImpl getEvaluationDao() {
        if (evaluationDao == null) {
            evaluationDao = new EvaluationDaoImpl();
        }
        return evaluationDao;
    }

    public static CourseDaoImpl getCourseDao() {
        if (courseDao == null) {
            courseDao = new CourseDaoImpl();
        }
        return courseDao;
    }

    public static EnrolmentDaoImpl getEnrolmentDao() {
        if (enrolmentDao == null) {
            enrolmentDao = new EnrolmentDaoImpl();
        }
        return enrolmentDao;
    }

    public static GuardianDaoImpl getGuardianDao() {
        if (guardianDao == null) {
            guardianDao = new GuardianDaoImpl();
            guardianDao.setUserDao(DaoFactory.getUserDao());
        }
        return guardianDao;
    }

    public static OwnerDaoImpl getOwnerDao() {
        if (ownerDao == null) {
            ownerDao = new OwnerDaoImpl();
            ownerDao.setUserDao(DaoFactory.getUserDao());
        }
        return ownerDao;
    }

    public static StudentDaoImpl getStudentDao() {
        if (studentDao == null) {
            studentDao = new StudentDaoImpl();
        }
        return studentDao;
    }

    public static TeacherDaoImpl getTeacherDao() {
        if (teacherDao == null) {
            teacherDao = new TeacherDaoImpl();
            teacherDao.setUserDao(DaoFactory.getUserDao());
        }
        return teacherDao;
    }

    public static SessionDaoImpl getSessionDao() {
        if (sessionDao == null) {
            sessionDao = new SessionDaoImpl();
        }
        return sessionDao;
    }

    public static UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}
