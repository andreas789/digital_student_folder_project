package gr.aueb.mscis.educore.auth.service;

import gr.aueb.mscis.educore.model.auth.User;

public interface AuthenticationService {
    User getUserFromBasicAuthFlow(String authHeaderValue);

    User getUserFromBearerAuthFlow(String authHeaderValue);
}
