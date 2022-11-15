package com.example.emos.wx;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.emos.wx.db.dao.MessageDao;
import com.example.emos.wx.db.dao.MessageRefDao;
import com.example.emos.wx.db.pojo.MessageEntity;
import com.example.emos.wx.db.pojo.MessageRefEntity;
import com.example.emos.wx.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbTest {
    @Autowired
    MessageService messageService;


//    @Test
//    public void insertmessage() {
//        MessageEntity messageEntity = new MessageEntity();
//        messageEntity.set_id("600bea9ab5bafb311f147506");
//        messageEntity.setUuid("bfcb7c47-5886-c528-5127-ce285bc2322a");
//        messageEntity.setSenderId(0);
//        messageEntity.setSenderPhoto("https://static-1258386385.cos.ap-beijing.myqcloud.com/img/System.jpg");
//        messageEntity.setSenderName("Emos系统");
//        messageEntity.setMsg("HelloWorld");
//        messageEntity.setSendTime(new Date());
//        messageDao.insert(messageEntity);
//
//    }
//    @Test
//    public void insertmessageref() {
//        MessageRefEntity messageRefEntity = new MessageRefEntity();
//        messageRefEntity.set_id("600beaf0d6310000830036f3");
//        messageRefEntity.setMessageId("600bea9ab5bafb311f147506");
//        messageRefEntity.setReceiverId(3);
//        messageRefEntity.setReadFlag(Boolean.FALSE);
//        messageRefEntity.setLastFlag(Boolean.TRUE);
//        messageRefDao.insert(messageRefEntity);
//    }

    @Test
    public void test() {
        for (int i =1; i<=100;i++){
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setUuid(IdUtil.simpleUUID());
            messageEntity.setSenderId(0);
            messageEntity.setSenderName("系统消息");
            messageEntity.setMsg("这是第"+i+"条测试消息");
            messageEntity.setSendTime(new Date());
            String id = messageService.insertMessage(messageEntity);
            MessageRefEntity messageRefEntity = new MessageRefEntity();
            messageRefEntity.setMessageId(id);
            messageRefEntity.setReceiverId(3);
            messageRefEntity.setReadFlag(Boolean.FALSE);
            messageRefEntity.setLastFlag(Boolean.TRUE);
            messageService.insertRef(messageRefEntity);
        }
    }
}
