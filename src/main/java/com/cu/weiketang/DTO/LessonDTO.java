package com.cu.weiketang.DTO;

import com.cu.weiketang.pojo.Course;
import com.cu.weiketang.pojo.Lesson;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @ClassName LessonDTO
 * @Description TODO
 * @Author QQ163
 * @Date 2020/4/30 11:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO{

    /*课程名*/
    private String cname;
    /*大学*/
    private String ucollage;
    /*教师名字*/
    private String uname;
    /*课程介绍*/
    private String cintroduce;
    /*课程要求*/
    private Integer crequirements;
    /*目前学习到的节id*/
    private Integer lid;
    /*章节*/
    private List<LessonDetailDTO> lessonDetailDTOS;

    public void SetCourse(Course course){
        this.setCname(course.getCname());
        this.setCrequirements(course.getCrequirements());
        this.setCintroduce(course.getCintroduce());
    }

    public void Setlesson(List<Lesson> lessonArrayList){
        lessonDetailDTOS = new ArrayList<>();
        for (Lesson lesson : lessonArrayList){
            LessonDeatilDeatilDTO lessonDeatilDeatilDTO = new LessonDeatilDeatilDTO();
            lessonDeatilDeatilDTO.setLid(lesson.getLid());
            lessonDeatilDeatilDTO.setLvideo(lesson.getLvideo());
            lessonDeatilDeatilDTO.setLname(lesson.getLname());

            boolean b = true;
            for (int i = 0; i < lessonDetailDTOS.size(); i++){
                if (lessonDetailDTOS.get(i).getChapterId() == lesson.getChapterId()){
                    lessonDetailDTOS.get(i).getLessonDeatilDeatilDTOS().add(lessonDeatilDeatilDTO);
                    b=false;
                }
            }
            if (!b){
                continue;
            }
            LessonDetailDTO lessonDetailDTO = new LessonDetailDTO();
            if (b){
                lessonDetailDTO.setChapterName(lesson.getChapterName());
                lessonDetailDTO.setChapterId(lesson.getChapterId());
                List<LessonDeatilDeatilDTO> lessonDeatilDeatilDTOS  = new ArrayList<>();
                lessonDeatilDeatilDTOS.add(lessonDeatilDeatilDTO);
                lessonDetailDTO.setLessonDeatilDeatilDTOS(lessonDeatilDeatilDTOS);
            }
            lessonDetailDTOS.add(lessonDetailDTO);
        }

    }
}
