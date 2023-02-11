package com.global.book.service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class PriceScheduled {

    Logger log = LoggerFactory.getLogger(PriceScheduled.class);

    @Scheduled( fixedRate = 200000)
    @SchedulerLock(name = "bookComputePrice")
    @Async
    public void computePrice() throws InterruptedException {

        Thread.sleep(4000);
        log.info("compute price >. " + LocalDateTime.now());
    }

    @Scheduled( fixedRate = 200000)
    @SchedulerLock(name = "bookComputeDiscount")
    @Async
    public void computeDiscount() throws InterruptedException {

        Thread.sleep(4000);
        log.info("compute discount >> " + LocalDateTime.now());
    }
}
