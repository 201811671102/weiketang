package com.cu.weiketang.service;



import com.cu.weiketang.pojo.Record;

import java.util.List;

public interface RecordService {
    /*添加记录*/
    int insertRecord(Record record)throws  Exception;
    /*uid cid 更新记录*/
    int updateRecord(Record record)throws Exception;
    /*uid 获取记录*/
    List<Record> selectByUid(Integer uid)throws Exception;
    /*cid uid 获取记录*/
    Record selectByCidUid(Integer cid,Integer uid)throws Exception;
}
