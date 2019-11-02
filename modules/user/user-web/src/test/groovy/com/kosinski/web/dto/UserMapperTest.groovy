package com.kosinski.web.dto

import com.kosinski.domain.Email
import com.kosinski.domain.Role
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class UserMapperTest extends Specification {

    private final def encoder = Mock(PasswordEncoder)
    private final def userMapper = new UserMapper(encoder)

    def "should map user from commandDTO when role is not set"() {
        given:
        def userCommandDTO = prepareDTO([role: null])
        encoder.encode("1234") >> "@#@#@#!@@"

        when:
        def user = userMapper.toEntity(userCommandDTO)

        then:
        with(user) {
            getUsername() == userCommandDTO.getUsername()
            getPassword() == "@#@#@#!@@"
            getRole() == Role.USER
            getEmail() == Email.create("email@gmail.com")
        }
    }

    def "should map user from commandDTO when role is set"() {
        given:
        def userCommandDTO = prepareDTO([role: "ADMIN"])
        encoder.encode("1234") >> "@#@#@#!@@"

        when:
        def user = userMapper.toEntity(userCommandDTO)

        then:
        with(user) {
            getUsername() == userCommandDTO.getUsername()
            getPassword() == "@#@#@#!@@"
            getRole() == Role.ADMIN
            getEmail() == Email.create("email@gmail.com")
        }
    }

    def "should throw exception when role is invalid"() {
        given:
        def userCommandDTO = prepareDTO([role: "INVALID_ROLE"])
        encoder.encode("1234") >> "@#@#@#!@@"

        when:
        userMapper.toEntity(userCommandDTO)

        then:
        thrown(RoleNotFound)
    }


    def prepareDTO(Map properties) {
        [
                username: "piotr",
                password: "1234",
                role    : "ADMIN",
                email   : "email@gmail.com"
        ] + properties as UserCommandDTO
    }

}
