package tech.utkorsho.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleSerialization {
    private static final Logger log = LoggerFactory.getLogger(SimpleSerialization.class);
    private static final Path PATH = Path.of("person.out");

    public static void main(String[] args) throws IOException {

        var person = Person.newBuilder()
                .setLastName("Labbaek Ratul")
                .setAge(32)
                .setEmail("labbaekratul@gmail.com")
                .setEmployed(true)
                .setSalary(1000.2054)
                .setBankAccountNumber(123456789158L)
                .setBalance(-1000)
                .build();

        serialize(person);
        log.info("{}", deserialize());
        log.info("{}",person.equals(deserialize()));
        log.info("byte length: {}",person.toByteArray().length);

    }

    public static void serialize(Person person) throws IOException {
//        try(var stream = Files.newInputStream(PATH)) {
//            person.writeTo(stream);
//        }
        person.writeTo(Files.newOutputStream(PATH));

    }

    public static Person deserialize() throws IOException {
        return Person.parseFrom(Files.newInputStream(PATH));
    }
}
