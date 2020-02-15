package xuelang_springBoot.com.xuelang.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.sql.rowset.serial.SerialStruct;
import java.util.concurrent.Future;

/**
 * @ClassName AsyncTask
 * @功能说明： 异步任务业务类
 * @Author xueLang
 * @Date 2020/2/13 下午9:29
 * @Version 1.0
 */
@Component
public class AsyncTask {

    @Async
    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000l);
        long end = System.currentTimeMillis();
        System.out.println("任务一耗时：" + (end - begin));
    }

    @Async
    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000l);
        long end = System.currentTimeMillis();
        System.err.println("任务二耗时：" + (end - begin));
    }

    @Async
    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(5000l);
        long end = System.currentTimeMillis();
        System.out.println("任务三耗时：" + (end - begin));
    }

    @Async
    public Future<String> task4() throws Exception {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000l);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end - begin));

        return new AsyncResult<String>("任务1耗时"+(end - begin));
    }
    @Async
    public Future<String> task5() throws Exception {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000l);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时：" + (end - begin));

        return new AsyncResult<String>("任务2耗时"+(end - begin));
    }
    @Async
    public Future<String> task6() throws Exception {
        long begin = System.currentTimeMillis();
        Thread.sleep(5000l);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时：" + (end - begin));

        return new AsyncResult<String>("任务3耗时"+(end - begin));
    }
}
