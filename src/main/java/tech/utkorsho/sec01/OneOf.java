package tech.utkorsho.sec01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.Credentials;
import tech.utkorsho.models.Email;
import tech.utkorsho.models.Phone;

public class OneOf {

    private static final Logger log = LoggerFactory.getLogger(OneOf.class);

    public static void main(String[] args) {

        var email = Email.newBuilder().setAddress("labbaekratul@gmail.com").setPassword("admin").build();
        var phone = Phone.newBuilder().setNumber(123456789).setCode(123).build();

        login(Credentials.newBuilder().setEmail(email).build());
        login(Credentials.newBuilder().setPhone(phone).build());
    }

    public static void login(Credentials credentials) {
        switch (credentials.getLoginTypeCase()) {
            case EMAIL -> log.info("email -> {}", credentials.getEmail());
            case PHONE -> log.info("phone -> {}", credentials.getPhone());
        }
    }
}
