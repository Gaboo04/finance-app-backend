package org.financeapp.iam.domain.model.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.financeapp.iam.domain.model.valueobjects.Roles;
import org.financeapp.shared.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(min = 4, max = 20)
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @Size(min = 8, max = 100)
    @Column(nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<Roles> roles = new HashSet<>();

    protected User() {
        // Required by JPA
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.roles.add(Roles.ROLE_USER);
    }

    public Set<Roles> getRoles() {
        return Set.copyOf(roles); // Inmutabilidad externa
    }
}

