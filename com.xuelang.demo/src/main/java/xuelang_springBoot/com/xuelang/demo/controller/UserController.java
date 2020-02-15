package xuelang_springBoot.com.xuelang.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xuelang_springBoot.com.xuelang.demo.domain.JsonData;
import xuelang_springBoot.com.xuelang.demo.task.AsyncTask;

import java.util.concurrent.Future;

/**
 * @ClassName UserController
 * @功能说明： TODO
 * @Author xueLang
 * @Date 2020/2/13 下午12:54
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {





    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/async_task")
    public JsonData execTask() throws Exception {

        long begin = System.currentTimeMillis();

       /* asyncTask.task1();

        asyncTask.task2();

        asyncTask.task3();*/

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();

        for (; ; ) {
            if (task4.isDone() && task5.isDone() && task6.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();

        return JsonData.buildSuccess(end - begin);
    }

}
