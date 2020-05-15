package com.cu.weiketang.DTO;

import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CourseDTO
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/30 10:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO{

    private Integer cid;

    /*课程名*/
    private String cname;
    /*课程照片*/
    private String cpicture;
    /*观看人数*/
    private String cnumber;
    /*大学*/
    private String collage;
    /*教师名字*/
    private String uname;

    public void SetCourse(Course course){
        this.setCid(course.getCid());
        this.setCname(course.getCname());
        this.setCpicture(course.getCpicture());
        this.setCnumber(course.getCnumber());
    }
}
