package com.cu.weiketang.mapper;

import com.cu.weiketang.pojo.Lesson;
import com.cu.weiketang.pojo.LessonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface LessonMapper {
    long countByExample(LessonExample example);

    int deleteByExample(LessonExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(Lesson record);

    int insertSelective(Lesson record);

    List<Lesson> selectByExampleWithRowbounds(LessonExample example, RowBounds rowBounds);

    List<Lesson> selectByExample(LessonExample example);

    Lesson selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") Lesson record, @Param("example") LessonExample example);

    int updateByExample(@Param("record") Lesson record, @Param("example") LessonExample example);

    int updateByPrimaryKeySelective(Lesson record);

    int updateByPrimaryKey(Lesson record);
}