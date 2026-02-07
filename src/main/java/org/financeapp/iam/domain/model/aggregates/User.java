package org.financeapp.iam.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.financeapp.iam.domain.model.entities.Role;
import org.financeapp.shared.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(min = 4, max = 20)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 8, max = 20)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
        this.roles = new HashSet<>();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public User(String username, String password, List<Role> roles) {
        this(username, password);
        addRoles(roles);
    }

    public User addRole(Role role){
        this.roles.add(role);
        return this;
    }

    public User addRoles(List<Role> roles){
        var validatedRoles = Role.validateRoleSet(roles);
        this.roles.addAll(validatedRoles);
        return this;
    }

}
