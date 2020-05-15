package com.cu.weiketang.service.impl;

import com.cu.weiketang.mapper.CourseMapper;
import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.CourseExample;
import com.cu.weiketang.service.CourseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/29 10:43
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int insertNewCourse(Course course) throws Exception{
        return courseMapper.insertSelective(course);
    }

    @Override
    public List<Course> selectCourseByCgrade(String cgrade,Integer offset,Integer limit) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCgradeEqualTo(cgrade);
        criteria.andStateEqualTo(true);
        RowBounds rowBounds = new RowBounds(offset,limit);
        return courseMapper.selectByExampleWithRowbounds(courseExample,rowBounds);
    }

    @Override
    public int updateCourse(Integer cid) throws Exception {
        Course course = new Course();
        course.setCid(cid);
        course.setState(false);
        return courseMapper.updateByPrimaryKeySelective(course);
    }

    @Override
    public Course selectByCid(Integer cid) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCidEqualTo(cid);
        criteria.andStateEqualTo(true);
        return courseMapper.selectByExample(courseExample).get(0);
    }

    @Override
    public int updateCourse(Course course) throws Exception {
        return courseMapper.updateByPrimaryKey(course);
    }
}
