package ua.pp.kaha.filters;

import org.springframework.beans.factory.annotation.Autowired;
import ua.pp.kaha.anotations.Secured;
import ua.pp.kaha.utils.TokenUtil;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kaha on 16.02.2017.
 */

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Autowired
    Key key;

    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader =
                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Check if the HTTP Authorization header is present and formatted correctly
//        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
//            requestContext.abortWith(Response
//                    .status(Response.Status.UNAUTHORIZED)
//                    .entity("User cannot access the resource.")
//                    .build());
//            return;
//        }
//
//        // Extract the token from the HTTP Authorization header
//        String token = authorizationHeader.substring("Bearer".length()).trim();
//
//        try {
//
//            // Validate the token
//            if (!TokenUtil.isValid(token, key))
//                throw new Exception("Token is invalid");
//
//            SecurityContext originalContext = requestContext.getSecurityContext();
//            Set<String> roles = new HashSet<>();
//            roles.add("ADMIN");
//            Authorizer authorizer = new Authorizer(roles, TokenUtil.getName(token, key),
//                    originalContext.isSecure());
//            requestContext.setSecurityContext(authorizer);
//
//        } catch (Exception e) {
//            requestContext.abortWith(
//                    Response.status(Response.Status.UNAUTHORIZED).entity("wrong username or password").build()
//            );
//        }

    }

    public static class Authorizer implements SecurityContext {

        Set<String> roles;
        String username;
        boolean isSecure;
        public Authorizer(Set<String> roles, final String username,
                          boolean isSecure) {
            this.roles = roles;
            this.username = username;
            this.isSecure = isSecure;
        }

        @Override
        public Principal getUserPrincipal() {
            return new User(username);
        }

        @Override
        public boolean isUserInRole(String role) {
            return roles.contains(role);
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return "Your Scheme";
        }
    }

    public static class User implements Principal {
        String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() { return name; }
    }


}