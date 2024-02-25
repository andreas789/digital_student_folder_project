package gr.aueb.mscis.educore.service.evaluation.impl;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.evaluation.Evaluation;
import gr.aueb.mscis.educore.model.school.Course;
import gr.aueb.mscis.educore.model.school.Student;
import gr.aueb.mscis.educore.persistence.evaluation.impl.EvaluationDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.CourseDaoImpl;
import gr.aueb.mscis.educore.persistence.school.impl.StudentDaoImpl;
import gr.aueb.mscis.educore.service.evaluation.EvaluationService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Inject
    EvaluationDaoImpl evaluationDao;

    @Inject
    StudentDaoImpl studentDao;

    @Inject
    CourseDaoImpl courseDao;

    @Override
    public Evaluation evaluateStudent(Long studentId, Long courseId, Evaluation evaluation) {
        Student student = studentDao.findOne(studentId);
        Course course = courseDao.findOne(courseId);

        evaluation.setCourse(course);
        evaluation.setStudent(student);

        return evaluationDao.saveEvaluation(evaluation);
    }

    @Override
    public void deleteEvaluation(Long evaluationId) {
        evaluationDao.deleteById(evaluationId);
    }

    @Override
    public List<Evaluation> searchEvaluations(SearchParameters params) {
        return evaluationDao.search(params);
    }

    @Override
    public Evaluation findEvaluationById(long id){
        return evaluationDao.findOne(id);
    }

    public void setEvaluationDao(EvaluationDaoImpl evaluationDao) {
        this.evaluationDao = evaluationDao;
    }

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }
}
