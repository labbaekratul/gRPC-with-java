package tech.utkorsho.sec01;


import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.Sample;

import java.time.Instant;

public class WellKnownType {

    private static final Logger log = LoggerFactory.getLogger(WellKnownType.class);

    public static void main(String[] args) {

        var sample = Sample.newBuilder()
                .setAge(Int32Value.of(12))
                .setLoginTime(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                .build();

        log.info("{}", Instant.ofEpochSecond(sample.getLoginTime().getSeconds()));
    }
}
