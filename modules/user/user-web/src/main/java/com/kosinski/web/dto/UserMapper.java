package com.kosinski.web.dto;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.Role;
import com.kosinski.user.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserMapper {

    private final PasswordEncoder encoder;

    public UserMapper(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public User toEntity(UserCommandDTO userCommandDTO) {
        return User.create()
                .withRole(userCommandDTO.getRole() != null ? mapRole(userCommandDTO.getRole()) : null)
                .withEmail(Email.create(userCommandDTO.getEmail()))
                .withPassword(encoder.encode(userCommandDTO.getPassword()));

    }

    private Role mapRole(String role) {
        return Arrays.stream(Role.values())
                .filter(enumRole -> enumRole.name().equals(role))
                .findFirst()
                .orElseThrow(() -> new RoleNotFound(role));
    }

    public UserQueryDTO toDTO(User user) {
        UserQueryDTO queryDTO = new UserQueryDTO();
/*        queryDTO.setUsername(user.getUsername());
        queryDTO.setRole(user.getRole().name());
        queryDTO.setEmail(user.getEmail().getValue());*/
        return queryDTO;
    }
}
