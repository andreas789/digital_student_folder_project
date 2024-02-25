package gr.aueb.mscis.educore.auth.util;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import java.lang.reflect.Method;

public class AuthUtil {
    public static final String AUTHORIZATION_PROPERTY = "Authorization";
    public static final String AUTHENTICATION_SCHEME_BASIC = "Basic";
    public static final String AUTHENTICATION_SCHEME_BEARER = "Bearer";

    public static boolean hasSecurityAnnotations(Method method) {
        return method.isAnnotationPresent(PermitAll.class) ||
                method.isAnnotationPresent(DenyAll.class) ||
                method.isAnnotationPresent(RolesAllowed.class);
    }

    public static boolean isPublic(Method method) {
        return method.isAnnotationPresent(PermitAll.class) ||
                !AuthUtil.hasSecurityAnnotations(method);
    }

    public static boolean hasBasicAuthHeader(String authHeaderValue) {
        return authHeaderValue!=null && authHeaderValue.startsWith(AUTHENTICATION_SCHEME_BASIC);
    }

    public static boolean hasBearerAuthHeader(String authHeaderValue) {
        return authHeaderValue!=null && authHeaderValue.startsWith(AUTHENTICATION_SCHEME_BEARER);
    }

    public static String getRawValue(String authHeaderValue) {
        return authHeaderValue.replaceAll(AUTHENTICATION_SCHEME_BASIC, "")
                .trim()
                .replaceAll(AUTHENTICATION_SCHEME_BEARER, "")
                .trim();
    }
}
