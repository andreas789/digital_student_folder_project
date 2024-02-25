package gr.aueb.mscis.educore.persistence.auth;

import gr.aueb.mscis.educore.model.auth.Session;
import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.persistence.GenericDao;

public interface SessionDao extends GenericDao<Session> {
    User findByTokenKey(String token);
}
