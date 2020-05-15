package com.cu.weiketang.base.config;


import com.cu.weiketang.base.dto.ResultDTO;

public class ResultUtil {
    public static ResultDTO Success(Object object){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setData(object);
        resultDTO.setMsg("成功");
        resultDTO.setCode("200");
        return resultDTO;
    }
    public static ResultDTO Success(String code,Object object){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setData(object);
        resultDTO.setMsg("成功");
        resultDTO.setCode(code);
        return resultDTO;
    }

    public static ResultDTO Success(){return Success(null);}

    public static ResultDTO Error(String code , String msg){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(msg);
        resultDTO.setCode(code);
        return  resultDTO;
    }
}
