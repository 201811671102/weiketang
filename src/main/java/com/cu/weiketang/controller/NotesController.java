package com.cu.weiketang.controller;

import com.cu.weiketang.base.config.ResultUtil;
import com.cu.weiketang.base.dto.ResultDTO;
import com.cu.weiketang.pojo.Notes;
import com.cu.weiketang.service.NotesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName NotesController
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 22:45
 **/
@Controller
@Api(value = "NotesController")
@RequestMapping("/NotesController")
@Log4j2
public class NotesController {
    @Autowired
    private NotesService notesService;

    @PostMapping("/addNotes")
    @ResponseBody
    @ApiOperation(value = "添加笔记",notes = " 500 报错")
    public ResultDTO addNotes(
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid,
            @ApiParam(value = "笔记内容",required = true)@RequestParam(value = "ucontent",required = true)String ucontent){
        try {
            Notes notes = new Notes();
            notes.setUid(uid);
            notes.setUcontent(ucontent);
            notesService.insertNotes(notes);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }
    @PutMapping("/changeNotes")
    @ResponseBody
    @ApiOperation(value = "修改笔记",notes = " 500 报错")
    public ResultDTO changeNotes(
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid,
            @ApiParam(value = "笔记内容",required = true)@RequestParam(value = "ucontent",required = true)String ucontent){
        try {
            Notes notes = notesService.selectNotes(uid);
            notes.setUcontent(ucontent);
            notesService.updateNotes(notes);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }
    @PostMapping("/getNotes")
    @ResponseBody
    @ApiOperation(value = "查询笔记",notes = " 500 报错")
    public ResultDTO getNotes(
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid){
        try {
            return new ResultUtil().Success(notesService.selectNotes(uid));
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }
}
