package com.oszhugc.schedule.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl {

    int count1 = 1;
    int count2 = 1;
    int count3 = 1;
    int count4 = 1;


    @Scheduled(fixedRate = 1000)
    @Async
    public void job1(){
        System.out.println(Thread.currentThread().getName() + ">>>>"
                +"job1 执行第 >" + count1 + "< 次");
        count1++;
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void job2(){
        System.out.println(Thread.currentThread().getName() + ">>>>>"
                + "job2 执行第 >" + count2 + "< 次");
        count2++;
    }

    @Scheduled(initialDelay = 3000,fixedRate = 1000)
    @Async
    public void job3(){
        System.out.println(Thread.currentThread().getName() + ">>>>>"
                + "job3 执行第 >" + count3 + "< 次");
        count3++;
    }
    @Scheduled(cron = "* * * * * ?")
    @Async
    public void job4(){
        System.out.println(Thread.currentThread().getName() + ">>>>>"
                + "job4 执行第 >" + count4 + "< 次");
        count4++;
    }

}
