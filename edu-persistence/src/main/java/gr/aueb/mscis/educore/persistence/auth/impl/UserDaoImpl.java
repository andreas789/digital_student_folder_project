package gr.aueb.mscis.educore.persistence.auth.impl;

import gr.aueb.mscis.educore.core.exceptions.ExceptionMessages;
import gr.aueb.mscis.educore.core.exceptions.ValidationException;
import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.auth.UserDao;
import org.jvnet.hk2.annotations.Service;

import java.util.Objects;

@Service
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return (User) entityManager.createQuery("select u from User u where u.username=?1 and u.password=?2")
                .setParameter(1, username)
                .setParameter(2, password)
                .getResultList().stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public User saveUser(User user) {
        if (Objects.isNull(user)) {
            throw new ValidationException(ExceptionMessages.USER_IS_NULL);
        }
        if (!user.isValidForPersistence()){
            throw  new ValidationException(ExceptionMessages.INVALID_DATA);
        }
        return this.saveOrUpdate(user);
    }

}
