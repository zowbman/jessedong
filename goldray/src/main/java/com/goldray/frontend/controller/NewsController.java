package com.goldray.frontend.controller;

import com.goldray.backend.model.po.NewsPo;
import com.goldray.frontend.model.po.NewsListPo;
import com.goldray.frontend.model.po.NewsListPoShow;
import com.goldray.frontend.model.po.NewsPoShow;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.frontend.model.po.TopNews;
import com.goldray.helper.CodeHelper;
import com.goldray.util.ConcurrentDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Controller
@RequestMapping("/news/json")
public class NewsController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @return
     */
    @GetMapping("/v1/list")
    @ResponseBody
    public PubReturnMsg list() {
        System.out.println("hello");
        List<NewsListPo> newsListPos = iNewsService.findByOrderByAddTime(OrderStyleEnum.DESC);
        List<NewsListPoShow> newsListPoShows = new ArrayList<>();
        newsListPos.forEach((newsListPo) -> {
            {
                NewsListPoShow newsListPoShow = new NewsListPoShow();
                newsListPoShow.setId(newsListPo.getId());
                newsListPoShow.setTitle(newsListPo.getTitle());
                if (newsListPo.getIsTop() == 1) {
                    newsListPoShow.setIsTop("[置顶]");
                }
                newsListPoShow.setAddTime(ConcurrentDateTimeUtil.format(newsListPo.getAddTime() * 1000L));
                newsListPoShows.add(newsListPoShow);
            }
        });
        return new PubReturnMsg(CodeHelper.SUCCESS, newsListPoShows);
    }

    /**
     * @return
     */
    @GetMapping("/v1/{id}")
    @ResponseBody
    public PubReturnMsg detail(@PathVariable("id") int id) {
        log.info("param id:[{}]", id);
        if (id < 0) {
            log.error("param id:[{}] 小于 0", id);
            return new PubReturnMsg(CodeHelper.PARAMS_ERROR);
        }
        NewsPo newsPo = iNewsService.getById(id);
        if (newsPo == null) {
            log.error("param id:[{}],新闻不存在", id);
            return new PubReturnMsg(CodeHelper.NEWSNOTEXIST_ERROR);
        }
        NewsPoShow newsPoShow = new NewsPoShow();
        newsPoShow.setTitle(newsPo.getTitle());
        newsPoShow.setText(newsPo.getText());
        newsPoShow.setAddTime(ConcurrentDateTimeUtil.format(newsPo.getAddTime() * 1000L));
        return new PubReturnMsg(CodeHelper.SUCCESS, newsPoShow);
    }

    /**
     * 置顶新闻
     *
     * @return
     */
    @GetMapping("/v1/top")
    @ResponseBody
    public PubReturnMsg top() {
        TopNews topNews = iNewsService.getTopNews();
        return new PubReturnMsg(CodeHelper.SUCCESS, topNews);
    }
}
