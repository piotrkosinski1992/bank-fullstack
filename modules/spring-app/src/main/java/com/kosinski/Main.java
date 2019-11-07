package com.kosinski;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.Role;
import com.kosinski.user.domain.User;
import com.kosinski.user.gateway.BaseEntityRepository;
import com.kosinski.user.usecase.RegisterUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories("com.kosinski")
@EntityScan("com.kosinski")
public class Main implements CommandLineRunner {

    @Autowired
    private RegisterUsers registerUsers;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private BaseEntityRepository baseEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        User user1 = User.create()
                .withRole(Role.ADMIN)
                .withEmail(Email.create("piotr@o2.pl"))
                .withPassword(encoder.encode("111"));
        registerUsers.register(user1);

        User user2 = User.create()
                .withRole(Role.ADMIN)
                .withEmail(Email.create("ada@o2.pl"))
                .withPassword(encoder.encode("222"));
        registerUsers.register(user2);
    }
}
