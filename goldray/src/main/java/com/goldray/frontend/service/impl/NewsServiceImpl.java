package com.goldray.frontend.service.impl;

import com.goldray.backend.model.po.NewsPo;
import com.goldray.frontend.mapper.NewsMapper;
import com.goldray.frontend.model.po.NewsListPo;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.TopNews;
import com.goldray.frontend.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<NewsListPo> findByOrderByAddTime(OrderStyleEnum orderStyleEnum) {
        return newsMapper.findByIsShowAndOderByAddTime(orderStyleEnum);
    }

    @Override
    public NewsPo getById(int id) {
        return newsMapper.getById(id);
    }

    @Override
    public TopNews getTopNews() {
        return newsMapper.getTopNews();
    }
}
