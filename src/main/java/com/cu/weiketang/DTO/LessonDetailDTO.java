package com.cu.weiketang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName LessonDetailDTO
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/3 14:06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDetailDTO {
    private Integer chapterId;

    private String chapterName;

    private List<LessonDeatilDeatilDTO> lessonDeatilDeatilDTOS;
}
