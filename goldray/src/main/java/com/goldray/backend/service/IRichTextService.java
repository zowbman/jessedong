package com.goldray.backend.service;

import com.goldray.backend.model.po.RichTextPo;

/**
 * Created by zwb on 2017/4/18.
 */
public interface IRichTextService {

    /**
     * @param type
     * @return
     */
    RichTextPo getByType(int type);

    /**
     * 保存
     * @param richTextPo
     * @return
     */
    boolean save(RichTextPo richTextPo);

    /**
     * 修改
     * @param richTextPo
     * @return
     */
    boolean update(RichTextPo richTextPo);

    /**
     *
     * @param id
     * @return
     */
    RichTextPo getById(int id);
}
