package com.goldray.frontend.service.impl;

import com.goldray.frontend.mapper.RichTextMapper;
import com.goldray.frontend.model.po.RichTextPo;
import com.goldray.frontend.service.IRichTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zwb on 2017/4/18.
 */
@Service
public class RichTextServiceImpl implements IRichTextService {

    @Autowired
    private RichTextMapper richTextMapper;

    @Override
    public RichTextPo getByType(int type) {
        return richTextMapper.getByType(type);
    }
}
