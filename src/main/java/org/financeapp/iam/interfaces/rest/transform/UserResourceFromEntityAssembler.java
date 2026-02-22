package org.financeapp.iam.interfaces.rest.transform;

import org.financeapp.iam.domain.model.aggregates.User;
import org.financeapp.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {

    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(
                user.getId(),
                user.getUsername()
        );
    }
}
