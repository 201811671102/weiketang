package com.cu.weiketang.service.impl;

import com.cu.weiketang.mapper.CourseMapper;
import com.cu.weiketang.mapper.RecordMapper;
import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.Record;
import com.cu.weiketang.pojo.RecordExample;
import com.cu.weiketang.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * @ClassName RecordServiceImpl
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 18:41
 **/
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public int insertRecord(Record record) throws Exception {
        return recordMapper.insertSelective(record);
    }

    @Override
    public int updateRecord(Record record) throws Exception {
        return recordMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Record> selectByUid(Integer uid) throws Exception {
        RecordExample recordExample = new RecordExample();
        RecordExample.Criteria criteria = recordExample.createCriteria();
        criteria.andUidEqualTo(uid);
        criteria.andUtimeLessThanOrEqualTo(new Date());
        return recordMapper.selectByExample(recordExample);
    }

    @Override
    public Record selectByCidUid(Integer cid, Integer uid) throws Exception {
        try {
            RecordExample recordExample = new RecordExample();
            RecordExample.Criteria criteria = recordExample.createCriteria();
            criteria.andCidEqualTo(cid);
            criteria.andUidEqualTo(uid);
            return recordMapper.selectByExample(recordExample).get(0);
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }
}
