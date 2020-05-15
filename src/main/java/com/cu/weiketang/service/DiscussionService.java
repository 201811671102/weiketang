package com.cu.weiketang.service;

import com.cu.weiketang.pojo.Discussion;

import java.util.List;

public interface DiscussionService {
    /*添加讨论*/
    int insertDiscussion(Discussion discussion)throws Exception;
    /*lid查询讨论*/
    List<Discussion> selectDiscussionByLid(Integer lid,Integer offset,Integer limit)throws Exception;
}
