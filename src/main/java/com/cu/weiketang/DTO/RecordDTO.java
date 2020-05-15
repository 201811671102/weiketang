package com.cu.weiketang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName RecordDTO
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 21:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
        /*课程名字*/
        private String cname;
        /*课程发布者大学名*/
        private String ucollage;
        /*课程照片*/
        private String cpicture;
        /*节点名*/
        private List<String> lname;
        /*节id*/
        private Integer lid;
        /*课程id*/
        private Integer cid;
}
