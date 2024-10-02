package tech.utkorsho.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.School;

public class DefaultValue {

    private static final Logger log = LoggerFactory.getLogger(DefaultValue.class);

    public static void main(String[] args) {

        var school = School.newBuilder().build();

        log.info("{}", school.getId());
        log.info("{}", school.getName());
    }
}
