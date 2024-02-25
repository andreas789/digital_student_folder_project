package gr.aueb.mscis.educore.persistence.school.impl;

import gr.aueb.mscis.educore.model.school.Teacher;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import gr.aueb.mscis.educore.persistence.school.TeacherDao;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class TeacherDaoImpl extends AbstractDao<Teacher> implements TeacherDao {
    @Inject
    UserDaoImpl userDao;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        userDao.saveUser(teacher.getUser());
        return this.saveOrUpdate(teacher);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
