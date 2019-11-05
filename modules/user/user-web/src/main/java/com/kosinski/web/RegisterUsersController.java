package com.kosinski.web;

import com.kosinski.user.usecase.RegisterUsers;
import com.kosinski.web.dto.UserCommandDTO;
import com.kosinski.web.dto.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class RegisterUsersController {

    private final RegisterUsers registerUsers;
    private final UserMapper userMapper;

    public RegisterUsersController(RegisterUsers registerUsers, UserMapper userMapper) {
        this.registerUsers = registerUsers;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserCommandDTO userCommandDTO) {
        registerUsers.register(userMapper.toEntity(userCommandDTO));
    }
}
