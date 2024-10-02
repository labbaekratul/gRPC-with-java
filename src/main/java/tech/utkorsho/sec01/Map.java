package tech.utkorsho.sec01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.utkorsho.models.BodyStyle;
import tech.utkorsho.models.Car;
import tech.utkorsho.models.Dealer;

public class Map {

    private static final Logger log = LoggerFactory.getLogger(Map.class);

    public static void main(String[] args) {

        var car1 = Car.newBuilder()
                .setMake("honda")
                .setModel("civic")
                .setYear(2000)
                .setBodyStyle(BodyStyle.COUPE)
                .build();

        var car2 = Car.newBuilder()
                .setMake("honda")
                .setModel("accord")
                .setYear(2002)
                .setBodyStyle(BodyStyle.COUPE)
                .build();

        var dealer = Dealer.newBuilder()
                .putInventory(car1.getYear(),car1)
                .putInventory(car2.getYear(),car2)
                .build();
        log.info("Car info {}",dealer);
    }
}
