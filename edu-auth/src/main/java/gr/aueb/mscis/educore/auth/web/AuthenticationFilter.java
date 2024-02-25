package gr.aueb.mscis.educore.auth.web;

import gr.aueb.mscis.educore.auth.service.impl.DefaultAuthenticationService;
import gr.aueb.mscis.educore.auth.util.AuthUtil;
import gr.aueb.mscis.educore.model.auth.User;

import java.lang.reflect.Method;
import java.util.Objects;

import javax.annotation.security.DenyAll;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * This filter verify the access permissions for a user
 */
@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter {

    @Inject
    DefaultAuthenticationService authenticationService;
    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        Method method = resourceInfo.getResourceMethod();
        if(isLocalHost(requestContext))return;

        User user = User.GUEST;

        //Access allowed for all or nothing is Specified
        if (!AuthUtil.isPublic(method)) {
            //Access denied for all
            if (method.isAnnotationPresent(DenyAll.class)) {
                deny(requestContext, Response.Status.FORBIDDEN, "Access blocked for all users !!");
                return;
            }

            String authHeaderValue = requestContext.getHeaderString(AuthUtil.AUTHORIZATION_PROPERTY);
            //If no authorization information present; block access
            if (authHeaderValue == null || authHeaderValue.isEmpty()) {
                deny(requestContext, Response.Status.UNAUTHORIZED, "You cannot access this resource");
                return;
            }
            else if (AuthUtil.hasBasicAuthHeader(authHeaderValue)) {
                user = authenticationService.getUserFromBasicAuthFlow(authHeaderValue);
                if (Objects.isNull(user)){
                    deny(requestContext, Response.Status.UNAUTHORIZED, "You cannot access this resource");
                    return;
                }
            }
            else if (AuthUtil.hasBearerAuthHeader(authHeaderValue)) {
                user = authenticationService.getUserFromBearerAuthFlow(authHeaderValue);
                if (Objects.isNull(user)){
                    deny(requestContext, Response.Status.UNAUTHORIZED, "You cannot access this resource");
                    return;
                }
            }

            //TODO: check the role
            //authenticationService.ensureRole();
        }
    }

    private boolean isLocalHost(ContainerRequestContext requestContext) {
        return "localhost".equalsIgnoreCase(requestContext.getUriInfo().getBaseUri().getHost()) ||
                "127.0.0.1".equals(requestContext.getUriInfo().getBaseUri().getHost());
    }

    private void deny(ContainerRequestContext requestContext, Response.Status status, String message) {
        requestContext.abortWith(Response
                .status(status)
                .entity(message)
                .build()
        );
    }

}