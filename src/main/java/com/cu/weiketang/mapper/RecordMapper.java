package com.cu.weiketang.mapper;

import com.cu.weiketang.pojo.Record;
import com.cu.weiketang.pojo.RecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface RecordMapper {
    long countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExampleWithRowbounds(RecordExample example, RowBounds rowBounds);

    List<Record> selectByExample(RecordExample example);

    Record selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}