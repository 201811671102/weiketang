package com.cu.weiketang.controller;

import com.cu.weiketang.DTO.LessonDTO;
import com.cu.weiketang.base.config.ResultUtil;
import com.cu.weiketang.base.dto.ResultDTO;
import com.cu.weiketang.ftp.FtpOperation;
import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.Lesson;
import com.cu.weiketang.pojo.Record;
import com.cu.weiketang.pojo.User;
import com.cu.weiketang.service.CourseService;
import com.cu.weiketang.service.LessonService;
import com.cu.weiketang.service.RecordService;
import com.cu.weiketang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.net.ftp.FTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;

/**
 * @ClassName LessonController
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/29 11:08
 **/
@Controller
@Api(value = "LessonController")
@RequestMapping("/LessonController")
@Log4j2
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private FtpOperation ftpOperation;


    @PostMapping("/addCourse")
    @ResponseBody
    @ApiOperation(value = "添加章节",notes = " 500 报错")
    public ResultDTO addCourse(
            @ApiParam(value = "节名称",required = true)@RequestParam(value = "lname",required = true)String lname,
            @ApiParam(value = "节视频",required = true)@RequestParam(value = "lvideo",required = true) MultipartFile lvideo,
            @ApiParam(value = "章序号",required = true)@RequestParam(value = "chapter_id",required = true)Integer chapter_id,
            @ApiParam(value = "章名称",required = true)@RequestParam(value = "chapter_name",required = true)String chapter_name,
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer cid){
        try{
            Lesson lesson = new Lesson();
            lesson.setLname(lname);
            lesson.setChapterId(chapter_id);
            lesson.setChapterName(chapter_name);
            lesson.setCid(cid);
           /* lesson.setLvideo(lvideo);*/
            String phototype = lvideo.getOriginalFilename().substring(lvideo.getOriginalFilename().lastIndexOf("."));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String path = simpleDateFormat.format(System.currentTimeMillis());
            String name = System.currentTimeMillis()+phototype;
            ftpOperation.setFileType(FTP.BINARY_FILE_TYPE);
            ftpOperation.uploadToFtp(lvideo.getInputStream(),name,"video/weiketang/"+path);
            lesson.setLvideo("http://39.96.68.53:70/weiketang/"+path+"/"+name);
            lessonService.insertLesson(lesson);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

    @GetMapping("/getCourse")
    @ResponseBody
    @ApiOperation(value = "查询章节  lid 已经学习到的节id",notes = " 500 报错")
    public ResultDTO getCourse(
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid,
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer cid){
        try {
            LessonDTO lessonDTO = new LessonDTO();
            Course course = courseService.selectByCid(cid);
            Record record = recordService.selectByCidUid(cid,uid);
            if (record != null){
                lessonDTO.setLid(record.getLid());
            }

            lessonDTO.SetCourse(course);
            User user = userService.selectByUid(course.getUid());
            lessonDTO.setUname(user.getUname());
            lessonDTO.setUcollage(user.getUcollage());
            lessonDTO.Setlesson(lessonService.selectLesson(cid));

            return ResultUtil.Success(lessonDTO);
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

}
