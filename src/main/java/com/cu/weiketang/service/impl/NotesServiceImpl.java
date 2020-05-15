package com.cu.weiketang.service.impl;

import com.cu.weiketang.mapper.NotesMapper;
import com.cu.weiketang.pojo.Notes;
import com.cu.weiketang.pojo.NotesExample;
import com.cu.weiketang.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName NotesServiceImpl
 * @Description TODO
 * @Author QQ163
 * @Date 2020/5/1 22:42
 **/
@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesMapper notesMapper;
    @Override
    public int insertNotes(Notes notes) throws Exception {
        return notesMapper.insertSelective(notes);
    }

    @Override
    public Notes selectNotes(Integer uid) throws Exception {
        NotesExample notesExample = new NotesExample();
        NotesExample.Criteria criteria = notesExample.createCriteria();
        criteria.andUidEqualTo(uid);
        return notesMapper.selectByExample(notesExample).get(0);
    }

    @Override
    public int updateNotes(Notes notes) throws Exception {
        return notesMapper.updateByPrimaryKeySelective(notes);
    }
}
