package xuelang_springBoot.com.xuelang.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName TestTask
 * @功能说明： TODO
 * @Author xueLang
 * @Date 2020/2/13 下午8:58
 * @Version 1.0
 */
@Component
public class TestTask {
   // @Scheduled(fixedRate = 2000)//每两秒执行一次
    @Scheduled(cron = "1  * * * * *")
    public void sum(){

        System.out.println("当前时间：" + new Date());
    }
}
