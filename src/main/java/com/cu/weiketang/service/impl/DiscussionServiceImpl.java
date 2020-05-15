package com.cu.weiketang.service.impl;

import com.cu.weiketang.mapper.DiscussionMapper;
import com.cu.weiketang.pojo.Discussion;
import com.cu.weiketang.pojo.DiscussionExample;
import com.cu.weiketang.service.DiscussionService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DiscussionServiceImpl
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 18:05
 **/
@Service
public class DiscussionServiceImpl implements DiscussionService {
    @Autowired
    private DiscussionMapper discussionMapper;
    @Override
    public int insertDiscussion(Discussion discussion) throws Exception {
        return discussionMapper.insertSelective(discussion);
    }

    @Override
    public List<Discussion> selectDiscussionByLid(Integer lid,Integer offset,Integer limit) throws Exception {
        DiscussionExample discussionExample = new DiscussionExample();
        DiscussionExample.Criteria criteria = discussionExample.createCriteria();
        criteria.andLidEqualTo(lid);
        RowBounds rowBounds = new RowBounds(offset,limit);
        return discussionMapper.selectByExampleWithRowbounds(discussionExample,rowBounds);
    }
}
