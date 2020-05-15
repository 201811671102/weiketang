package com.cu.weiketang.controller;

import com.cu.weiketang.DTO.CourseDTO;
import com.cu.weiketang.base.config.ResultUtil;
import com.cu.weiketang.base.dto.ResultDTO;
import com.cu.weiketang.ftp.FtpOperation;
import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.User;
import com.cu.weiketang.redis.RedisUtil;
import com.cu.weiketang.service.CourseService;
import com.cu.weiketang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ClassName CourseController
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/29 10:19
 **/
@Controller
@Api(value = "CourseController")
@RequestMapping("/CourseController")
@Log4j2
public class CourseController {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private FtpOperation ftpOperation;


    @PostMapping("/addCourse")
    @ResponseBody
    @ApiOperation(value = "添加课程",notes = " 500 报错")
    public ResultDTO addCourse(
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid,
            @ApiParam(value = "课程名称",required = true)@RequestParam(value = "cname",required = true)String cname,
            @ApiParam(value = "课程图片",required = true)@RequestParam(value = "cpicture",required = true) MultipartFile cpicture,
            @ApiParam(value = "课程介绍",required = true)@RequestParam(value = "cintroduce",required = true)String cintroduce,
            @ApiParam(value = "课程年级",required = true)@RequestParam(value = "cgrade",required = true)String cgrade,
            @ApiParam(value = "学习要求",required = true)@RequestParam(value = "crequirements",required = true)Integer crequirements){
        try {
            Course course = new Course();
            course.setCname(cname);
            course.setCintroduce(cintroduce);
            course.setCgrade(cgrade);
            course.setCrequirements(crequirements);

            String phototype = cpicture.getOriginalFilename().substring(cpicture.getOriginalFilename().lastIndexOf("."));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String path = simpleDateFormat.format(System.currentTimeMillis());
            String name = System.currentTimeMillis()+phototype;
            ftpOperation.uploadToFtp(cpicture.getInputStream(),name,"photo/weiketang/"+path);
            course.setCpicture("http://39.96.68.53:70/weiketang/"+path+"/"+name);

            course.setCnumber("0");
            course.setUid(uid);
            course.setUpdateTime(new Date());
            course.setState(true);
            courseService.insertNewCourse(course);
            redisUtil.set("weiketang"+course.getCid(),0);
            return ResultUtil.Success();
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

    @PutMapping("/subscribe")
    @ApiOperation(value = "订阅数加一",notes = "500 报错")
    @ResponseBody
    public ResultDTO addCourse(
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer cid){
        try {
            Course course = courseService.selectByCid(cid);
            course.setCnumber((Integer.parseInt(course.getCnumber())+1)+"");
            redisUtil.set("weiketang" + cid,course.getCnumber());
            courseService.updateCourse(course);
            return new ResultUtil().Success(course.getCnumber());
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

    @GetMapping("/getCourse")
    @ApiOperation(value = "查询课程",notes = "500 报错")
    @ResponseBody
    public ResultDTO getCourse(
            @ApiParam(value = "年级",required = true)@RequestParam(value = "cgrade",required = true)String  cgrade,
            @ApiParam(value = "页码",required = true)@RequestParam(value = "offset",required = true)Integer  offset,
            @ApiParam(value = "页数",required = true)@RequestParam(value = "limit",required = true)Integer  limit){
        try {
            List<Course> courseList = courseService.selectCourseByCgrade(cgrade,offset*limit,limit);
            List<CourseDTO> courseDTOS = new ArrayList<>();
            for (Course course : courseList){
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.SetCourse(course);
                User user = userService.selectByUid(course.getUid());
                user.setUpassword(null);
                courseDTO.setUname(user.getUname());
                courseDTO.setCollage(user.getUcollage());
                courseDTOS.add(courseDTO);
            }
            return new ResultUtil().Success(courseDTOS);
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

    @PutMapping("/deleteCourse")
    @ApiOperation(value = "删除课程",notes = "500 报错")
    @ResponseBody
    public ResultDTO deleteCourse(
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer  cid){
        try {
            courseService.updateCourse(cid);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

    @PostMapping("/changeCourse")
    @ResponseBody
    @ApiOperation(value = "修改课程",notes = " 500 报错")
    public ResultDTO changeCourse(
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "cid",required = true)Integer  cid,
            @ApiParam(value = "课程名称",required = false)@RequestParam(value = "cname",required = false)String cname,
            @ApiParam(value = "课程图片",required = false)@RequestParam(value = "cpicture",required = false) MultipartFile cpicture,
            @ApiParam(value = "课程介绍",required = false)@RequestParam(value = "cintroduce",required = false)String cintroduce,
            @ApiParam(value = "课程年级",required = false)@RequestParam(value = "cgrade",required = false)String cgrade,
            @ApiParam(value = "学习要求",required = false)@RequestParam(value = "crequirements",required = false)Integer crequirements){
        try {
            Course course = courseService.selectByCid(cid);
            if (StringUtils.isNotBlank(cname))course.setCname(cname);
            if (StringUtils.isNotBlank(cintroduce))course.setCintroduce(cintroduce);
            if (StringUtils.isNotBlank(cgrade))course.setCgrade(cgrade);
            if (crequirements != null ) course.setCrequirements(crequirements);
      /*      if (StringUtils.isNotBlank(cpicture))course.setCpicture(cpicture);*/
            if (cpicture != null){
                String path = course.getCpicture().replaceFirst("http://39.96.68.53:70","photo");
                String name = course.getCpicture().substring(course.getCpicture().lastIndexOf("/"));
                ftpOperation.delectFile(path,name);
                String phototype = cpicture.getOriginalFilename().substring(cpicture.getOriginalFilename().lastIndexOf("."));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                path = "photo/weiketang/"+simpleDateFormat.format(System.currentTimeMillis());
                name = System.currentTimeMillis()+phototype;
                ftpOperation.uploadToFtp(cpicture.getInputStream(),name,path);
                course.setCpicture(path+"/"+name);
            }
            course.setUpdateTime(new Date());
            courseService.updateCourse(course);
            return ResultUtil.Success();
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

}
