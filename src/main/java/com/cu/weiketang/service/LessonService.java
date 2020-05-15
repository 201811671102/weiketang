package com.cu.weiketang.service;

import com.cu.weiketang.pojo.Lesson;

import java.util.List;

public interface LessonService {
    /*添加章节*/
    int insertLesson(Lesson lesson)throws Exception;
    /*查询章节*/
    List<Lesson> selectLesson(Integer cid)throws Exception;
    /*查询特定章节*/
    List<Lesson> selectLesson(Integer lid,Integer cid,Integer num)throws Exception;
}
