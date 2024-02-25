package gr.aueb.mscis.educore.auth.service.impl;

import gr.aueb.mscis.educore.auth.service.AuthenticationService;
import gr.aueb.mscis.educore.auth.util.AuthUtil;
import gr.aueb.mscis.educore.core.service.AbstractService;
import gr.aueb.mscis.educore.model.auth.User;
import gr.aueb.mscis.educore.persistence.auth.impl.SessionDaoImpl;
import gr.aueb.mscis.educore.persistence.auth.impl.UserDaoImpl;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.Base64;

@Service
public class DefaultAuthenticationService extends AbstractService implements AuthenticationService {

    @Inject
    UserDaoImpl userDao;

    @Inject
    SessionDaoImpl tokenDao;

    @Override
    public User getUserFromBasicAuthFlow(String authHeaderValue) {
        String rawValue = AuthUtil.getRawValue(authHeaderValue);
        String decodedValue = new String(Base64.getDecoder().decode(rawValue));
        String username = decodedValue.split(":")[0];
        String password = decodedValue.split(":")[1];
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserFromBearerAuthFlow(String authHeaderValue) {
        String rawValue = AuthUtil.getRawValue(authHeaderValue);
        return tokenDao.findByTokenKey(rawValue);
    }
}
