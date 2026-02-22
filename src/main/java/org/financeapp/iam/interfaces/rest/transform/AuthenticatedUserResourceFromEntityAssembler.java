package org.financeapp.iam.interfaces.rest.transform;


import org.financeapp.iam.domain.model.aggregates.User;
import org.financeapp.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
