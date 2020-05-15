package com.cu.weiketang.controller;

import com.cu.weiketang.DTO.UserDTO;
import com.cu.weiketang.base.config.ResultUtil;
import com.cu.weiketang.base.dto.ResultDTO;
import com.cu.weiketang.pojo.User;
import com.cu.weiketang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @ClassName UserController
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/29 0:46
 **/
@Controller
@Api(value = "用户controller",tags = "用户注册，登录")
@RequestMapping("/UserController")
@Log4j2
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/userLog")
    @ResponseBody
    @ApiOperation(value = "用户登录",notes = "404 用户不存在 400 密码错误 500 报错 0学生 1教师")
    public ResultDTO userLog(
            @ApiParam(value = "用户账号",required = true)@RequestParam(value = "unumber",required = true)String unumber,
            @ApiParam(value = "用户密码",required = true)@RequestParam(value = "upassword",required = true)String upassword){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(unumber,upassword);
            subject.login(token);
            User user = (User) subject.getPrincipal();
            UserDTO userDTO = new UserDTO();
            userDTO.SetUserDTO(user);
            return ResultUtil.Success(userDTO);
        }catch (UnknownAccountException e){
            return ResultUtil.Error("404","用户不存在");
        }catch (IncorrectCredentialsException e){
            return  ResultUtil.Error("400","密码错误");
        }catch (Exception e){
            log.info(e.toString());
            return ResultUtil.Error("500",e.toString());
        }
    }

    @PostMapping("/usersign")
    @ResponseBody
    @ApiOperation(value = "用户注册",notes = "400 学号重复 500 报错 类型0学生1教师")
    public ResultDTO usersign(
            @ApiParam(value = "用户账号",required = true)@RequestParam(value = "unumber",required = true)String unumber,
            @ApiParam(value = "用户密码",required = true)@RequestParam(value = "upassword",required = true)String upassword,
            @ApiParam(value = "用户名字",required = true)@RequestParam(value = "uname",required = true)String uname,
            @ApiParam(value = "用户学校",required = true)@RequestParam(value = "ucollage",required = true)String ucollage,
            @ApiParam(value = "用户类型",required = true)@RequestParam(value = "type",required = true)Integer type){
        try {
          if (userService.selectByUnumber(unumber) != null){
              return  ResultUtil.Error("400","学号已经被注册");
          }
          User user = new User();
          user.setUnumber(unumber);
          user.setUpassword(upassword);
          user.setUname(uname);
          user.setUcollage(ucollage);
          user.setType(type);
          userService.insertUser(user);
            UserDTO userDTO = new UserDTO();
            userDTO.SetUserDTO(user);
          return  ResultUtil.Success();
        }catch (Exception e){
            log.info(e.toString());
            return  ResultUtil.Error("500",e.toString());
        }
    }
}
