package com.cu.weiketang.mapper;

import com.cu.weiketang.pojo.Notes;
import com.cu.weiketang.pojo.NotesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface NotesMapper {
    long countByExample(NotesExample example);

    int deleteByExample(NotesExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(Notes record);

    int insertSelective(Notes record);

    List<Notes> selectByExampleWithRowbounds(NotesExample example, RowBounds rowBounds);

    List<Notes> selectByExample(NotesExample example);

    Notes selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") Notes record, @Param("example") NotesExample example);

    int updateByExample(@Param("record") Notes record, @Param("example") NotesExample example);

    int updateByPrimaryKeySelective(Notes record);

    int updateByPrimaryKey(Notes record);
}