package gr.aueb.mscis.educore.persistence.auth;

import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface UserDao extends GenericDao<User> {
    User findByUsernameAndPassword(String username, String password);
    User saveUser(User user);
}
