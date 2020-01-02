//package com.zhiliao.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.Trigger;
//import org.springframework.scheduling.TriggerContext;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.concurrent.ScheduledFuture;
//
///**
// * @author Mr.Zhong
// * @create2019-09-05 9:00
// */
//@Component("myScheduled")
//public class Patrol {
//
//        private ScheduledFuture<?> future;
//
//        @Autowired
//        private ThreadPoolTaskScheduler threadPoolTaskScheduler;
//
//        @Bean
//        public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//            return new ThreadPoolTaskScheduler();
//        }
//
//        @Override
//        public void setCron(final String cron) {
//            stopCron();
//            future = threadPoolTaskScheduler.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    // TODO Auto-generated method stub
//                    System.out.println("执行任务");
//                }
//            }, new Trigger() {
//                @Override
//                public Date nextExecutionTime(TriggerContext triggerContext) {
//                    if(cron==null || "".equals(cron)) {
//                        return null;
//                    }
//                    CronTrigger cronTrigger = new CronTrigger(cron);
//                    return cronTrigger.nextExecutionTime(triggerContext);
//                }
//            });
//        }
//
//        @Override
//        public void stopCron() {
//            if(future!=null) {
//                future.cancel(true);
//            }
//        }
//    }
//
//
//
//
