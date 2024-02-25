package gr.aueb.mscis.educore.persistence.school;

import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface TeacherDao extends GenericDao<Teacher> {

    Teacher saveTeacher(Teacher teacher);
}
