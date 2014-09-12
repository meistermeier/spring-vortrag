package com.meistermeier.springdi;

import com.meistermeier.springdi.tourist.Tourist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Holiday {

    public static void main(String[] args) {
//        Tourist tourist = simpleContext().getBean(Tourist.class);
//        Tourist tourist = complexContext("").getBean(Tourist.class);
//        Tourist tourist = complexContext("luxury").getBean(Tourist.class);
        Tourist tourist = complexContext("cheap").getBean(Tourist.class);
        System.out.println(tourist.fun);
        System.out.println(tourist.sleep);
        System.out.println(tourist.takeMyMoney);
        System.out.println(tourist.transport);
    }

    private static ApplicationContext complexContext(String profile) {
        System.getProperties().setProperty("spring.profiles.active", profile);
        return new AnnotationConfigApplicationContext(HolidayContextWithProfiles.class);
    }

    static ApplicationContext simpleContext() {
        return new AnnotationConfigApplicationContext(HolidayContext.class);
    }
}
