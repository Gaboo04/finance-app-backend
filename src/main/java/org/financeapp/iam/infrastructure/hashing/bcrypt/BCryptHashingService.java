package org.financeapp.iam.infrastructure.hashing.bcrypt;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
