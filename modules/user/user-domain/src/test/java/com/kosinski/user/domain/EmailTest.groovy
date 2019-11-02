package com.kosinski.user.domain

import spock.lang.Specification

class EmailTest extends Specification {

    def "should throw exception when given email is invalid"() {
        when:
        Email.create(email)

        then:
        thrown(InvalidEmail)

        where:
        email << ["dsa.pl", "@assdpl", "@o2.pl"]
    }

    def "should validate valid emails"() {
        when:
        Email.create(email)

        then:
        noExceptionThrown()

        where:
        email << ["dsa@o2.pl", "assdpl@gmail.com", "ok@o2.pl"]
    }
}
