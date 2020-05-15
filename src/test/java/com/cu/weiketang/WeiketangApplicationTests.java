package com.cu.weiketang;

import com.cu.weiketang.redis.RedisUtil;
import com.cu.weiketang.service.LessonService;
import com.cu.weiketang.service.UserService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootTest(classes = {WeiketangApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class WeiketangApplicationTests {
    @Value("${weiketang.ftpaccount}")
    private String userName;

    @Autowired
    private RedisUtil redisUtil;


    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        gregorianCalendar.set(Calendar.HOUR_OF_DAY,6);
        gregorianCalendar.set(Calendar.MINUTE,0);
        gregorianCalendar.set(Calendar.SECOND,0);
        System.out.println(gregorianCalendar.getTime());
    }
    @Test
    public void time(){
        GregorianCalendar nowgregorianCalendar = new GregorianCalendar(2020,5,8,10,10,10);
        Date now = nowgregorianCalendar.getTime();
        GregorianCalendar oldgregorianCalendar = new GregorianCalendar(2020,5,5,15,10,10);
        Date old = oldgregorianCalendar.getTime();
        System.out.println("改变前now：-----"+now);
        System.out.println("改变前old：-----"+old);

        if (old.getTime()>getDate(old).getTime()){
            old.setTime(old.getTime()+(24*60*60*1000));
            old = getDate(old);
        }else{
            old=getDate(old);
        }
        System.out.println("改变后 old "+old);
        if (now.getTime()>getDate(now).getTime()){
            System.out.println(1+(getDate(now).getTime() - old.getTime()) / (24 * 60 * 60 * 1000));
        }else{
            System.out.println((getDate(now).getTime() - old.getTime()) / (24 * 60 * 60 * 1000));
        }
    }

    public Date getDate(Date date){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY,6);
        gregorianCalendar.set(Calendar.MINUTE,0);
        gregorianCalendar.set(Calendar.SECOND,0);
        return gregorianCalendar.getTime();
    }
    @Autowired
    private LessonService lessonService;


}
