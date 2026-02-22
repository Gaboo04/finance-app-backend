package org.financeapp.iam.interfaces.acl;

import java.util.Optional;

import org.financeapp.iam.domain.model.aggregates.User;
import org.financeapp.iam.domain.model.commands.SignUpCommand;
import org.financeapp.iam.domain.model.queries.GetUserByIdQuery;
import org.financeapp.iam.domain.model.queries.GetUserByUsernameQuery;
import org.financeapp.iam.domain.services.UserCommandService;
import org.financeapp.iam.domain.services.UserQueryService;

/**
 * Facade para el contexto IAM.
 * Expone métodos orientados al negocio para otros bounded contexts.
 */
public class IamContextFacade {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService,
                            UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    /**
     * Registra un nuevo usuario.
     * El rol por defecto es asignado automáticamente en el agregado.
     */
    public Optional<Long> registerUser(String username, String password) {
        var command = new SignUpCommand(username, password);
        var result = userCommandService.handle(command);
        return result.map(User::getId);
    }

    /**
     * Obtiene el id del usuario dado su username.
     */
    public Optional<Long> getUserIdByUsername(String username) {
        var query = new GetUserByUsernameQuery(username);
        var result = userQueryService.handle(query);
        return result.map(User::getId);
    }

    /**
     * Obtiene el username dado su id.
     */
    public Optional<String> getUsernameByUserId(Long userId) {
        var query = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(query);
        return result.map(User::getUsername);
    }
}
