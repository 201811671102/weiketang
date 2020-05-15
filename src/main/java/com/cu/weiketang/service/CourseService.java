package com.cu.weiketang.service;

import com.cu.weiketang.pojo.Course;

import java.util.List;

public interface CourseService {
    /*添加课程*/
    int insertNewCourse(Course course) throws Exception;
    /*查询课程*/
    List<Course> selectCourseByCgrade(String cgrade,Integer offset,Integer limit) throws Exception;
    /*删除课程*/
    int updateCourse(Integer cid)throws Exception;
    /*根据cid查询课程*/
    Course selectByCid(Integer cid)throws Exception;
    /*更新课程*/
    int updateCourse(Course course)throws Exception;
}
