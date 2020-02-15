package xuelang_springBoot.com.xuelang.demo.controller;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xuelang_springBoot.com.xuelang.demo.domain.JsonData;
import xuelang_springBoot.com.xuelang.demo.jms.MsgProducer;


/**
 * @ClassName OrderController
 * @功能说明： TODO
 * @Author xueLang
 * @Date 2020/2/14 下午3:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private MsgProducer msgProducer;

    @GetMapping("/order")
    public Object order(String msg, String tag) throws Exception {

        Message message = new Message("testTopic", tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult result = msgProducer.getProducer().send(message);

        System.out.println("发送消息响应MsgId ：" + result.getMsgId() + ", 发送状态：" + result.getSendStatus());

        return JsonData.buildSuccess();
    }
}
