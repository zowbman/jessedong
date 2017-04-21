package com.goldray.backend.service.impl;

import com.goldray.backend.mapper.BNewsMapper;
import com.goldray.backend.model.po.NewsListPo;
import com.goldray.backend.model.po.NewsPo;
import com.goldray.backend.service.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/4/19.
 */
@Service("BNewsServiceImpl")
public class NewsServiceImpl implements INewsService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BNewsMapper newsMapper;

    @Override
    public List<NewsListPo> findAll() {
        return newsMapper.findAll();
    }

    @Override
    public NewsPo getById(int id) {
        return newsMapper.getById(id);
    }

    @Override
    public boolean save(NewsPo newsPo) {
        newsMapper.clearTop();
        return newsMapper.save(newsPo.getTitle(), newsPo.getText(), newsPo.getResume(), newsPo.getIsTop(), newsPo.getAddTime());
    }

    @Override
    public boolean update(NewsPo newsPo) {
        newsMapper.clearTop();
        return newsMapper.update(newsPo.getId(), newsPo.getTitle(), newsPo.getText(), newsPo.getResume(), newsPo.getIsTop(), newsPo.getAddTime());
    }

    @Override
    public boolean deleteById(int id) {
        return newsMapper.deleteById(id);
    }
}
