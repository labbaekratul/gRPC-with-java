package tech.utkorsho.sec01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.Person;

import java.nio.file.Path;

public class SimpleProtoDemo {

    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) {

        var person = createPerson();

        log.info("{}",person);


    }

    private static Person createPerson() {
        return Person.newBuilder()
                .setLastName("Labbaek Ratul")
                .setAge(32)
                .setEmail("labbaekratul@gmail.com")
                .setEmployed(true)
                .setSalary(1000.2054)
                .setBankAccountNumber(123456789158L)
                .setBalance(-1000)
                .build();
    }
}
