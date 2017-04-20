package com.goldray.frontend.service;

import com.goldray.frontend.model.po.RichTextPo;

/**
 * Created by zwb on 2017/4/18.
 */
public interface IRichTextService {

    /**
     *
     * @param type
     * @return
     */
    RichTextPo getByType(int type);
}
