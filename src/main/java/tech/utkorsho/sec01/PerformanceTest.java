package tech.utkorsho.sec01;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.Person;

import java.io.IOException;

public class PerformanceTest {

    private static final Logger log = LoggerFactory.getLogger(PerformanceTest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        var protoPerson = Person.newBuilder()
                .setLastName("noa")
                .setAge(12)
                .setEmail("noa@gamil.com")
                .setEmployed(true)
                .setSalary(1000.2345)
                .setBankAccountNumber(123456974254494L)
                .setBalance(-1000)
                .build();
        var jsonPerson = new JsonPerson("noa", 12, "noa@gmail.com", true, 1000.2345, 123456974254494L, -10000);

        json(jsonPerson);
        proto(protoPerson);
//        for (int i = 0; i < 5; i++) {
//            runTest("json", () -> {
//                try {
//                    json(jsonPerson);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//            runTest("proto", () -> {
//                try {
//                    proto(protoPerson);
//                } catch (InvalidProtocolBufferException e) {
//                    throw new RuntimeException(e);
//                }
//            });
//        }
    }

    private static void proto(Person person) throws InvalidProtocolBufferException {
        var bytes = person.toByteArray();
        log.info("proto byte length: {}", bytes.length);
        Person.parseFrom(bytes);
    }

    private static void json(JsonPerson person) throws IOException {
        var bytes = mapper.writeValueAsBytes(person);
        log.info("json byte length: {}", bytes.length);
        mapper.readValue(bytes, JsonPerson.class);
    }

    private static void runTest(String testName, Runnable runnable) {
        var start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            runnable.run();
        }
        var end = System.currentTimeMillis();
        log.info("time taken for  {} - {} ms", testName, (end - start));
    }
}
