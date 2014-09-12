package com.meistermeier.springdi;

import com.meistermeier.springdi.service.Bike;
import com.meistermeier.springdi.service.Camping;
import com.meistermeier.springdi.service.GarageSale;
import com.meistermeier.springdi.service.Hotel;
import com.meistermeier.springdi.service.ShoppingMall;
import com.meistermeier.springdi.service.Shuttle;
import com.meistermeier.springdi.service.ThemePark;
import com.meistermeier.springdi.service.WalkInThePark;
import com.meistermeier.springdi.tourist.Fun;
import com.meistermeier.springdi.tourist.Sleep;
import com.meistermeier.springdi.tourist.TakeMyMoney;
import com.meistermeier.springdi.tourist.Transport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@ComponentScan("com.meistermeier.springdi.tourist")
@Configuration
public class HolidayContextWithProfiles {

    @Bean
    @Profile("luxury")
    public Fun luxuryFun() {
        return new ThemePark();
    }

    @Bean
    @Profile("luxury")
    public Sleep luxurySleep() {
        return new Hotel();
    }

    @Bean
    @Profile("luxury")
    public TakeMyMoney luxuryTakeMyMoney() {
        return new ShoppingMall();
    }

    @Bean
    @Profile("luxury")
    public Transport luxuryTransport() {
        return new Shuttle();
    }

    @Bean
    @Profile("cheap")
    public Fun cheapFun() {
        return new WalkInThePark();
    }

    @Bean
    @Profile("cheap")
    public Sleep cheapSleep() {
        return new Camping();
    }

    @Bean
    @Profile("cheap")
    public TakeMyMoney cheapTakeMyMoney() {
        return new GarageSale();
    }

    @Bean
    @Profile("cheap")
    public Transport cheapTransport() {
        return new Bike();
    }

}
