package gr.aueb.mscis.educore.persistence.school.impl;

import gr.aueb.mscis.educore.model.school.Guardian;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import gr.aueb.mscis.educore.persistence.school.GuardianDao;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class GuardianDaoImpl extends AbstractDao<Guardian> implements GuardianDao {
    @Inject
    UserDaoImpl userDao;

    @Override
    public Guardian saveGuardian(Guardian guardian) {
        userDao.saveUser(guardian.getUser());
        return this.saveOrUpdate(guardian);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
