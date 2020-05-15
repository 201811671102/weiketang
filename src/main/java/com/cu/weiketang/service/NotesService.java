package com.cu.weiketang.service;

import com.cu.weiketang.pojo.Notes;

public interface NotesService {
    /*添加笔记*/
    int insertNotes(Notes notes)throws Exception;
    /*查询笔记*/
    Notes selectNotes(Integer uid)throws Exception;
    /*更新笔记*/
    int updateNotes(Notes notes)throws Exception;
}
