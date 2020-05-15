package com.cu.weiketang.controller;

import com.cu.weiketang.DTO.RecordDTO;
import com.cu.weiketang.base.config.ResultUtil;
import com.cu.weiketang.base.dto.ResultDTO;
import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.Lesson;
import com.cu.weiketang.pojo.Record;
import com.cu.weiketang.service.CourseService;
import com.cu.weiketang.service.LessonService;
import com.cu.weiketang.service.RecordService;
import com.cu.weiketang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName RecordControler
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 18:23
 **/
@Controller
@Api(value = "RecordControler")
@RequestMapping("/RecordControler")
@Log4j2
public class RecordControler {

    @Autowired
    private RecordService recordService;
    @Autowired
    private LessonService lessonService;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @PostMapping("/inRecord")
    @ResponseBody
    @ApiOperation(value = "添加课程",notes = "500报错")
    public ResultDTO inRecord(
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer cid,
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid
    ){
        try {
            Record record = new Record();
            record.setCid(cid);
            record.setLid(0);
            record.setUid(uid);
            record.setRtime(new Date());
            record.setLnumber(null);
            record.setUtime(new Date());
            record.setUtime(new Date());
            record.setLnumber(0);
            recordService.insertRecord(record);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }

    @PutMapping("/changeRecord")
    @ResponseBody
    @ApiOperation(value = "更新学习记录",notes = "500 报错")
    public ResultDTO changeRecord(
            @ApiParam(value = "节id",required = true)@RequestParam(value = "lid",required = true)Integer lid,
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer cid,
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid){
        try {
            Record record = recordService.selectByCidUid(cid,uid);
            if (record.getCid() <= record.getCid() && lid <= record.getLid()){
                return new ResultUtil().Success();
            }
            record.setLid(lid);
            record.setRtime(new Date());
            record.setUtime(new Date());
            record.setLnumber(0);
            Integer num = record.getLnumber()+1;
            if (num == courseService.selectByCid(cid).getCrequirements() && record.getUtime().getTime()<=new Date().getTime()){
                record.setLnumber(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(new Date());
                gregorianCalendar.add(Calendar.DATE,1);
                gregorianCalendar.set(Calendar.HOUR_OF_DAY,6);
                gregorianCalendar.set(Calendar.MINUTE,0);
                gregorianCalendar.set(Calendar.SECOND,0);
                record.setUtime(gregorianCalendar.getTime());
            }else {
                record.setLnumber(num);
                if(record.getUtime().getTime()<=new Date().getTime()){
                    record.setUtime(new Date());
                }
            }
            recordService.updateRecord(record);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }

    @GetMapping("/getRecord")
    @ResponseBody
    @ApiOperation(value = "提醒学生学习",notes = "500 报错")
    public ResultDTO getRecord(@ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid){
        try {
            List<Record> recordList = recordService.selectByUid(uid);
            List<RecordDTO> recordDTOList = new ArrayList<>();
            for (Record record : recordList){
                try {
                    Date date = new Date();
                    Course course = courseService.selectByCid(record.getCid());
                    Integer num = 0;
                    if (record.getLnumber() != 0){
                        num = course.getCrequirements()-record.getLnumber();
                    }else{
                         num  = Math.toIntExact((getDate(date).getTime() - getDate(record.getRtime()).getTime()) / (24 * 60 * 60 * 1000));
                         if (date.getTime()>getDate(date).getTime() || record.getLid() == 0){
                            num++;
                         }
                    }
                    if (num == 0 ){
                        continue;
                    }
                    num = course.getCrequirements() * num;
                    List<String> lname = new ArrayList<>();
                    List<Lesson> lessonList = lessonService.selectLesson(record.getLid(),record.getCid(),num);
                    RecordDTO recordDTO = new RecordDTO();
                    for (Lesson lesson : lessonList){
                        lname.add(lesson.getLname());
                    }
                    recordDTO.setUcollage(userService.selectByUid(course.getUid()).getUcollage());
                    recordDTO.setCname(course.getCname());
                    recordDTO.setCpicture(course.getCpicture());
                    recordDTO.setLname(lname);
                    recordDTO.setCid(course.getCid());
                    recordDTO.setLid(lessonList.get(0).getLid());
                    recordDTOList.add(recordDTO);
                }catch (IndexOutOfBoundsException e){
                    continue;
                }
            }

            return new ResultUtil().Success(recordDTOList);
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
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
}
