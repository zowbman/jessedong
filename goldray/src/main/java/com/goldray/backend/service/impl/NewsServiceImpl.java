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
        boolean result = clearTopNews(newsPo.getIsTop());
        if (!result) {
            log.error("clearTopNews(int isTop) 清除新闻置顶失败");
            return result;
        }
        return newsMapper.save(newsPo.getTitle(), newsPo.getText(), newsPo.getResume(), newsPo.getIsTop(), newsPo.getAddTime());
    }

    @Override
    public boolean update(NewsPo newsPo) {
        boolean result = clearTop(newsPo.getIsTop(), newsPo.getId());
        if (!result) {
            log.error("clearTopNews(int isTop, int id) 清除新闻置顶失败");
            return result;
        }
        return newsMapper.update(newsPo.getId(), newsPo.getTitle(), newsPo.getText(), newsPo.getResume(), newsPo.getIsTop(), newsPo.getAddTime());
    }

    @Override
    public boolean deleteById(int id) {
        return newsMapper.deleteById(id);
    }

    /**
     * 清除新闻置顶
     *
     * @param isTop
     * @return
     */
    private boolean clearTopNews(int isTop) {
        if (isTop == 1) {
            return newsMapper.updateByIsTop();
        }
        return true;
    }

    /**
     * 清除新闻置顶
     *
     * @param isTop
     * @param id
     * @return
     */
    private boolean clearTop(int isTop, int id) {
        if (isTop == 1) {
            int clearTopId = newsMapper.getIdByIsTopAndNotMe(id);
            if(clearTopId > 0){
                return true;
            }
            return newsMapper.clearTopById(clearTopId);
        }
        return true;
    }
}
