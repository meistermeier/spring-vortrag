package com.meistermeier.springdi;

import com.meistermeier.springdi.service.Hotel;
import com.meistermeier.springdi.service.ShoppingMall;
import com.meistermeier.springdi.service.Shuttle;
import com.meistermeier.springdi.service.ThemePark;
import com.meistermeier.springdi.tourist.Fun;
import com.meistermeier.springdi.tourist.Sleep;
import com.meistermeier.springdi.tourist.TakeMyMoney;
import com.meistermeier.springdi.tourist.Transport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.meistermeier.springdi.tourist")
@Configuration
public class HolidayContext {

    @Bean
    public Fun fun() {
        return new ThemePark();
    }

    @Bean
    public Sleep sleep() {
        return new Hotel();
    }

    @Bean
    public TakeMyMoney takeMyMoney() {
        return new ShoppingMall();
    }

    @Bean
    public Transport transport() {
        return new Shuttle();
    }

}
