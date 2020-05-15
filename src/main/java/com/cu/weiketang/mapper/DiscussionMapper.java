package com.cu.weiketang.mapper;

import com.cu.weiketang.pojo.Discussion;
import com.cu.weiketang.pojo.DiscussionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface DiscussionMapper {
    long countByExample(DiscussionExample example);

    int deleteByExample(DiscussionExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Discussion record);

    int insertSelective(Discussion record);

    List<Discussion> selectByExampleWithRowbounds(DiscussionExample example, RowBounds rowBounds);

    List<Discussion> selectByExample(DiscussionExample example);

    Discussion selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Discussion record, @Param("example") DiscussionExample example);

    int updateByExample(@Param("record") Discussion record, @Param("example") DiscussionExample example);

    int updateByPrimaryKeySelective(Discussion record);

    int updateByPrimaryKey(Discussion record);
}