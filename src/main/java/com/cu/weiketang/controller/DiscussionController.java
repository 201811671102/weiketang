package com.cu.weiketang.controller;

import com.cu.weiketang.DTO.DiscussionDTO;
import com.cu.weiketang.base.config.ResultUtil;
import com.cu.weiketang.base.dto.ResultDTO;
import com.cu.weiketang.pojo.Discussion;
import com.cu.weiketang.pojo.Lesson;
import com.cu.weiketang.pojo.User;
import com.cu.weiketang.service.DiscussionService;
import com.cu.weiketang.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DiscussionController
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/30 11:18
 **/
@Controller
@Api(value = "DiscussionController")
@RequestMapping("/DiscussionController")
@Log4j2
public class DiscussionController {

    @Autowired
    private UserService userService;
    @Autowired
    private DiscussionService discussionService;

    @ResponseBody
    @PostMapping("/addDiscussion")
    @ApiOperation(value = "添加课后讨论")
    public ResultDTO addDiscussion(
            @ApiParam(value = "课程id",required = true)@RequestParam(value = "lid",required = true)Integer lid,
            @ApiParam(value = "用户id",required = true)@RequestParam(value = "uid",required = true)Integer uid,
            @ApiParam(value = "评论内容",required = true)@RequestParam(value = "dcontent",required = true)String dcontent
    ){
        try {
            User user = userService.selectByUid(uid);
            Discussion discussion = new Discussion();
            discussion.setDcontent(dcontent);
            discussion.setLid(lid);
            discussion.setUcollage(user.getUcollage());
            discussion.setUid(uid);
            discussion.setUname(user.getUname());
            discussionService.insertDiscussion(discussion);
            return new ResultUtil().Success();
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }

    @ResponseBody
    @GetMapping("/getDiscussion")
    @ApiOperation(value = "查看课后讨论")
    public ResultDTO addDiscussion(
            @ApiParam(value = "页码",required = true)@RequestParam(value = "offset",required = true)Integer  offset,
            @ApiParam(value = "页数",required = true)@RequestParam(value = "limit",required = true)Integer  limit,
            @ApiParam(value = "节id",required = true)@RequestParam(value = "lid",required = true)Integer lid
    ){
        try {
            List<Discussion> discussionList = discussionService.selectDiscussionByLid(lid,offset*limit,limit);
            List<DiscussionDTO> discussionDTOList = new ArrayList<>();
            for (Discussion discussion : discussionList){
                DiscussionDTO discussionDTO = new DiscussionDTO();
                discussionDTO.setDcontent(discussion.getDcontent());
                discussionDTO.setUname(discussion.getUname());
                discussionDTO.setUcollage(discussion.getUcollage());
                discussionDTOList.add(discussionDTO);
            }
            return new ResultUtil().Success(discussionDTOList);
        }catch (Exception e){
            log.info(e.toString());
            return new ResultUtil().Error("500",e.toString());
        }
    }
}
