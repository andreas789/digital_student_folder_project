package gr.aueb.mscis.educore.service.factory;

import gr.aueb.mscis.educore.persistence.factory.DaoFactory;
import gr.aueb.mscis.educore.service.evaluation.EvaluationService;
import gr.aueb.mscis.educore.service.evaluation.impl.EvaluationServiceImpl;
import gr.aueb.mscis.educore.service.school.CourseService;
import gr.aueb.mscis.educore.service.school.RegistrationService;
import gr.aueb.mscis.educore.service.school.SchoolManagementService;
import gr.aueb.mscis.educore.service.school.impl.CourseServiceImpl;
import gr.aueb.mscis.educore.service.school.impl.RegistrationServiceImpl;
import gr.aueb.mscis.educore.service.school.impl.SchoolManagementServiceImpl;

public class ServiceFactory {

    private static EvaluationServiceImpl evaluationService;
    private static RegistrationServiceImpl registrationService;
    private static SchoolManagementServiceImpl schoolManagementService;
    private static CourseServiceImpl courseService;

    public static EvaluationServiceImpl getEvaluationService() {
        if (evaluationService == null) {
            evaluationService = new EvaluationServiceImpl();
            evaluationService.setEvaluationDao(DaoFactory.getEvaluationDao());
            evaluationService.setCourseDao(DaoFactory.getCourseDao());
            evaluationService.setStudentDao(DaoFactory.getStudentDao());
        }
        return evaluationService;
    }

    public static RegistrationServiceImpl getRegistrationService() {
        if (registrationService == null) {
            registrationService = new RegistrationServiceImpl();
            registrationService.setGuardianDao(DaoFactory.getGuardianDao());
            registrationService.setOwnerDao(DaoFactory.getOwnerDao());
            registrationService.setTeacherDao(DaoFactory.getTeacherDao());
        }
        return registrationService;
    }

    public static SchoolManagementServiceImpl getSchoolManagementService() {
        if (schoolManagementService == null) {
            schoolManagementService = new SchoolManagementServiceImpl();
            schoolManagementService.setGuardianDao(DaoFactory.getGuardianDao());
            schoolManagementService.setOwnerDao(DaoFactory.getOwnerDao());
            schoolManagementService.setTeacherDao(DaoFactory.getTeacherDao());
            schoolManagementService.setStudentDao(DaoFactory.getStudentDao());
        }
        return schoolManagementService;
    }
    public static CourseServiceImpl getCourseService() {
        if (courseService == null) {
            courseService = new CourseServiceImpl();
            courseService.setCourseDao(DaoFactory.getCourseDao());
            courseService.setTeacherDao(DaoFactory.getTeacherDao());
        }
        return courseService;
    }
}
