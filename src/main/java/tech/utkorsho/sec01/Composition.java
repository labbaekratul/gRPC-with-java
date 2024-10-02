package tech.utkorsho.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.Address;
import tech.utkorsho.models.School;
import tech.utkorsho.models.Student;

public class Composition {

    private static final Logger log = LoggerFactory.getLogger(Composition.class);

    public static void main(String[] args) {

        // create student
        var address = Address.newBuilder()
                .setStreet("123 main set")
                .setCity("dhaka")
                .setState("Dhaka")
                .build();

        var student = Student.newBuilder()
                .setName("sam")
                .setAddress(address)
                .build();

        // create school
        var school = School.newBuilder()
                .setId(1)
                .setName("Mile Stone")
                .setAddress(address.toBuilder().setStreet("234 main dhaka"))
                .build();


        log.info("school {}", school);
        log.info("student {}", student);
    }
}
