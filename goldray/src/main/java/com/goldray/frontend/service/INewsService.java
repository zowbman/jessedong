package com.goldray.frontend.service;

import com.goldray.backend.model.po.NewsPo;
import com.goldray.frontend.model.po.NewsListPo;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.TopNews;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
public interface INewsService {

    /**
     *
     * @param orderStyleEnum
     * @return
     */
    List<NewsListPo> findByOrderByAddTime(OrderStyleEnum orderStyleEnum);


    /**
     *
     * @param id
     * @return
     */
    NewsPo getById(int id);


    /**
     *
     * @return
     */
    TopNews getTopNews();
}
