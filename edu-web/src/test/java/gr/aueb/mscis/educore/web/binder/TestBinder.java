package gr.aueb.mscis.educore.web.binder;

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
import gr.aueb.mscis.educore.service.evaluation.impl.EvaluationServiceImpl;
import gr.aueb.mscis.educore.service.factory.ServiceFactory;
import gr.aueb.mscis.educore.service.school.impl.CourseServiceImpl;
import gr.aueb.mscis.educore.service.school.impl.RegistrationServiceImpl;
import gr.aueb.mscis.educore.service.school.impl.SchoolManagementServiceImpl;
import gr.aueb.mscis.educore.web.mapper.DtoToDomainMapper;
import gr.aueb.mscis.educore.web.mapper.DtoToDomainMapperImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class TestBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ServiceFactory.getEvaluationService()).to(EvaluationServiceImpl.class);
        bind(ServiceFactory.getCourseService()).to(CourseServiceImpl.class);
        bind(ServiceFactory.getRegistrationService()).to(RegistrationServiceImpl.class);
        bind(ServiceFactory.getSchoolManagementService()).to(SchoolManagementServiceImpl.class);
        bind(DaoFactory.getCourseDao()).to(CourseDaoImpl.class);
        bind(DaoFactory.getOwnerDao()).to(OwnerDaoImpl.class);
        bind(DaoFactory.getGuardianDao()).to(GuardianDaoImpl.class);
        bind(DaoFactory.getStudentDao()).to(StudentDaoImpl.class);
        bind(DaoFactory.getTeacherDao()).to(TeacherDaoImpl.class);
        bind(DaoFactory.getEnrolmentDao()).to(EnrolmentDaoImpl.class);
        bind(DaoFactory.getEvaluationDao()).to(EvaluationDaoImpl.class);
        bind(DaoFactory.getSessionDao()).to(SessionDaoImpl.class);
        bind(DaoFactory.getUserDao()).to(UserDaoImpl.class);
        bind(new DtoToDomainMapperImpl()).to(DtoToDomainMapper.class);
    }
}
