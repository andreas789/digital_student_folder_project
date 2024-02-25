package gr.aueb.mscis.educore.persistence.school.impl;

import gr.aueb.mscis.educore.model.school.Owner;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import gr.aueb.mscis.educore.persistence.school.OwnerDao;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class OwnerDaoImpl extends AbstractDao<Owner> implements OwnerDao {
    @Inject
    UserDaoImpl userDao;

    @Override
    public Owner saveOwner(Owner owner) {
        userDao.saveUser(owner.getUser());
        return this.saveOrUpdate(owner);
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
