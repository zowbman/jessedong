package com.goldray.backend.service;

import com.goldray.backend.model.po.NewsListPo;
import com.goldray.backend.model.po.NewsPo;

import java.util.List;

/**
 * Created by zwb on 2017/4/19.
 */
public interface INewsService {
    /**
     * 列表
     *
     * @return
     */
    List<NewsListPo> findAll();

    /**
     * @param id
     * @return
     */
    NewsPo getById(int id);

    /**
     * @param newsPo
     * @return
     */
    boolean save(NewsPo newsPo);

    /**
     * @param newsPo
     * @return
     */
    boolean update(NewsPo newsPo);

    /**
     *
     * @param id
     * @return
     */
    boolean deleteById(int id);
}
