package com.study.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ClassName ScheduledTask
 * @Description 定时任务
 * @Author jieyu
 * @Date 2018/12/21 14:27
 * @Version 1.0
 **/
@Component
@Slf4j
public class ScheduledTask {

    private int fixedDelayCount = 1;
    private int fixedRateCount = 1;
    private int initialDelayCount = 1;
    private int cronCount = 1;
    //fixedRate 任务两次执行时间间隔是任务的开始点，而 fixedDelay 的间隔是前次任务的结束与下次任务的开始。

    @Scheduled(fixedDelay = 5000) //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    public void testFixDelay() {
        log.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
    }

    @Scheduled(fixedRate = 5000)  //fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
    public void testFixedRate() {
        log.info("===fixedRate: 第{}次执行方法", fixedRateCount++);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)   //initialDelay = 1000表示延迟1000ms执行第一次任务
    public void testInitialDelay() {
        log.info("===initialDelay: 第{}次执行方法", initialDelayCount++);
    }

    @Scheduled(cron = "0 0/1 * * * ?")  //cron接受cron表达式，根据cron表达式确定定时规则
    public void testCron() {
        log.info("===initialDelay: 第{}次执行方法", cronCount++);
    }


}
