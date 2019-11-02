package com.kosinski;

import com.kosinski.user.domain.Email;
import com.kosinski.user.domain.Role;
import com.kosinski.user.domain.User;
import com.kosinski.user.gateway.BaseEntityRepository;
import com.kosinski.user.gateway.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private BaseEntityRepository baseEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        userRepository.save(
                User.create()
                        .withRole(Role.ADMIN)
                        .withEmail(Email.create("piotr@o2.pl"))
                        .withUsername("111")
                        .withPassword(encoder.encode("111")));

        System.out.println(baseEntityRepository.findAll().size());
    }
}
