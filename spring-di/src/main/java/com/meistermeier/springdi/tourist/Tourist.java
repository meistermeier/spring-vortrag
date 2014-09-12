package com.meistermeier.springdi.tourist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tourist {

    public final Fun fun;
    public final Sleep sleep;
    public final TakeMyMoney takeMyMoney;
    public final Transport transport;

    @Autowired
    public Tourist(Fun fun, Sleep sleep, TakeMyMoney takeMyMoney, Transport transport) {
        this.fun = fun;
        this.sleep = sleep;
        this.takeMyMoney = takeMyMoney;
        this.transport = transport;
    }
}
