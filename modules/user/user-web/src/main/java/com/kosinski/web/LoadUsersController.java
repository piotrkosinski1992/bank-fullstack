package com.kosinski.web;


import com.kosinski.user.domain.User;
import com.kosinski.user.usecase.LoadUsers;
import com.kosinski.web.dto.UserMapper;
import com.kosinski.web.dto.UserQueryDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class LoadUsersController {

    private final LoadUsers loadUsers;
    private final UserMapper userMapper;

    public LoadUsersController(LoadUsers loadUsers, UserMapper userMapper) {
        this.loadUsers = loadUsers;
        this.userMapper = userMapper;
    }

    @GetMapping("/{username}")
    public UserQueryDTO getByUsername(@PathVariable String username) {
        User user = loadUsers.loadByUsername(username);
        return userMapper.toDTO(user);
    }
}
