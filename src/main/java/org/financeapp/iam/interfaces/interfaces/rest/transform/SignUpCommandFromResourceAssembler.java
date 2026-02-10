package org.financeapp.iam.interfaces.interfaces.rest.transform;



import org.financeapp.iam.domain.model.commands.SignUpCommand;
import org.financeapp.iam.domain.model.entities.Role;
import org.financeapp.iam.interfaces.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
