package com.goldray.backend.service.impl;

import com.goldray.backend.mapper.BRichTextMapper;
import com.goldray.backend.model.po.RichTextPo;
import com.goldray.backend.service.IRichTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zwb on 2017/4/18.
 */
@Service("BRichTextServiceImpl")
public class RichTextServiceImpl implements IRichTextService {

    @Autowired
    private BRichTextMapper richTextMapper;

    @Override
    public RichTextPo getByType(int type) {
        return richTextMapper.getByType(type);
    }

    @Override
    public boolean save(RichTextPo richTextPo) {
        int count = richTextMapper.isExistType(richTextPo.getType());
        if (count > 0) {
            return false;
        }
        return richTextMapper.save(richTextPo.getType(), richTextPo.getText(), richTextPo.getAddTime());
    }

    @Override
    public boolean update(RichTextPo richTextPo) {
        return richTextMapper.update(richTextPo.getId(), richTextPo.getText(), richTextPo.getAddTime());
    }

    @Override
    public RichTextPo getById(int id) {
        return richTextMapper.getById(id);
    }
}
