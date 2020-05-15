package com.cu.weiketang.DTO;

import com.cu.weiketang.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 18:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer uid;

    private String unumber;

    private String ucollage;

    private String uname;

    private Integer type;

    public void SetUserDTO(User user){
        this.setUid(user.getUid());
        this.setUnumber(user.getUnumber());
        this.setUcollage(user.getUcollage());
        this.setUname(user.getUname());
        this.setType(user.getType());
    }
}
