package com.example.emos.wx;



import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.emos.wx.db.pojo.MessageEntity;
import com.example.emos.wx.db.pojo.MessageRefEntity;
import com.example.emos.wx.db.pojo.TbMeeting;
import com.example.emos.wx.service.MeetingService;
import com.example.emos.wx.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    MeetingService meetingService;
    @Test
    public void test() {
        for (int i =101; i<=110;i++){
            TbMeeting meeting = new TbMeeting();
            meeting.setId((long)i);
            meeting.setUuid(IdUtil.simpleUUID());
            meeting.setTitle("测试用户4L会议"+i);
            meeting.setCreatorId(4L);
            meeting.setDate(DateUtil.today());
            meeting.setPlace("线上用户4L会议室");
            meeting.setStart("14:30");
            meeting.setEnd("15:30");
            meeting.setType((short)1);
            meeting.setMembers("[3,4]");
            meeting.setDesc("Emos项目上线测试");
            meeting.setInstanceId(IdUtil.simpleUUID());
            meeting.setStatus((short)3);
            meetingService.insertMeeting(meeting);
        }
    }


}