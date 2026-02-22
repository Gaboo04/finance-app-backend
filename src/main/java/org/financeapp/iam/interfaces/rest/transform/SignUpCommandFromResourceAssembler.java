package org.financeapp.iam.interfaces.rest.transform;

import org.financeapp.iam.domain.model.commands.SignUpCommand;
import org.financeapp.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(
                resource.username(),
                resource.password()
        );
    }
}
