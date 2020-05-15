package com.cu.weiketang.service.impl;

import com.cu.weiketang.mapper.LessonMapper;
import com.cu.weiketang.pojo.Lesson;
import com.cu.weiketang.pojo.LessonExample;
import com.cu.weiketang.service.LessonService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LessonServiceImpl
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/29 11:32
 **/
@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonMapper lessonMapper;

    @Override
    public int insertLesson(Lesson lesson) throws Exception {
        return lessonMapper.insertSelective(lesson);
    }

    @Override
    public List<Lesson> selectLesson(Integer cid) throws Exception {
        LessonExample lessonExample = new LessonExample();
        LessonExample.Criteria criteria = lessonExample.createCriteria();
        criteria.andCidEqualTo(cid);
      /*  lessonExample.setOrderByClause("chapter_id asc,lid asc");*/
        return lessonMapper.selectByExample(lessonExample);
    }

    @Override
    public List<Lesson> selectLesson(Integer lid, Integer cid, Integer num) throws Exception {
        LessonExample lessonExample = new LessonExample();
        LessonExample.Criteria criteria = lessonExample.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andLidGreaterThan(lid);
        RowBounds rowBounds = new RowBounds(0,num);
        return lessonMapper.selectByExampleWithRowbounds(lessonExample,rowBounds);
    }
}
