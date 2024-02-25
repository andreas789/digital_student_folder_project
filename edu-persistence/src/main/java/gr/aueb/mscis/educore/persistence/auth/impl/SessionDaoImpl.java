package gr.aueb.mscis.educore.persistence.auth.impl;

import gr.aueb.mscis.educore.model.auth.Session;
import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.persistence.AbstractDao;
import gr.aueb.mscis.educore.persistence.auth.SessionDao;
import org.jvnet.hk2.annotations.Service;

@Service
public class SessionDaoImpl extends AbstractDao<Session> implements SessionDao {
    @Override
    public User findByTokenKey(String token) {
        return (User) entityManager.createQuery("select t.user from Session t where t.token=?1")
                .setParameter(1, token)
                .getResultList().stream()
                .findFirst()
                .orElse(null);
    }
}
