package com.goldray.backend.controller;

import com.goldray.backend.model.po.NewsListPo;
import com.goldray.backend.model.po.NewsListPoShow;
import com.goldray.backend.model.po.NewsPo;
import com.goldray.backend.model.po.NewsPoShow;
import com.goldray.backend.model.vo.NewsVo;
import com.goldray.util.BackendReMsg;
import com.goldray.util.ConcurrentDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwb on 2017/4/19.
 */
@Controller("BNewsController")
@RequestMapping("/backend/news")
public class NewsController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * news列表
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<NewsListPo> newsListPos = iNewsService.findAll();
        List<NewsListPoShow> newsListPoShows = new ArrayList<>();
        newsListPos.forEach((newsListPo) -> {
            NewsListPoShow nlps = new NewsListPoShow();
            nlps.setId(newsListPo.getId());
            nlps.setTitle(newsListPo.getTitle());
            nlps.setIsTop(newsListPo.getIsTop() == 0 ? "否" : "是");
            nlps.setAddTime(ConcurrentDateTimeUtil.format(newsListPo.getAddTime() * 1000L));
            newsListPoShows.add(nlps);
        });
        model.addAttribute("newsListPos", newsListPoShows);
        return "backend/newsList";
    }

    /**
     * news编辑
     *
     * @param type
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/save")
    public String save(String type, @RequestParam(defaultValue = "0") int id, Model model) {
        log.info("type;[{}],id:[{}]", type, id);
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && id == 0) {
            log.error("参数错误,type is edit, id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
            return "backend/error";
        }
        NewsPoShow nps = new NewsPoShow();
        if ("edit".equalsIgnoreCase(type)) {
            NewsPo np = iNewsService.getById(id);
            if (np == null) {
                log.error("参数错误,id:[{}] is error", id);
                model.addAttribute("msg", BackendReMsg.ID_ERROR);
                return "backend/error";
            }
            nps.setId(np.getId());
            nps.setTitle(np.getTitle());
            nps.setText(np.getText());
            nps.setResume(np.getResume());
            nps.setIsTop(np.getIsTop());
            nps.setAddTime(ConcurrentDateTimeUtil.format(np.getAddTime() * 1000L));
        } else {
            nps.setAddTime(ConcurrentDateTimeUtil.format(System.currentTimeMillis()));
        }
        model.addAttribute("np", nps);
        model.addAttribute("type", type);
        return "backend/newsSave";
    }

    /**
     * @param type
     * @param newsVo
     * @param model
     * @return
     */
    @PostMapping("/saveSubmit")
    public String saveSubmit(String type, NewsVo newsVo, Model model) {
        log.info("type:[{}],richTextVo[{}]", type, newsVo.toString());
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && newsVo.getId() == 0) {
            log.error("参数错误,type is edit, id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
            return "backend/error";
        }
        boolean result = false;
        if ("add".equalsIgnoreCase(type)) {
            NewsPo np = new NewsPo();
            np.setTitle(newsVo.getTitle());
            np.setIsTop(newsVo.getIsTop());
            np.setAddTime((int) (newsVo.getAddTime().getTime() / 1000L));
            np.setText(newsVo.getText());
            np.setResume(newsVo.getResume());
            result = iNewsService.save(np);
        } else {
            NewsPo np = iNewsService.getById(newsVo.getId());
            if (np != null) {
                np.setTitle(newsVo.getTitle());
                np.setText(newsVo.getText());
                np.setResume(newsVo.getResume());
                np.setIsTop(newsVo.getIsTop());
                np.setAddTime((int) (newsVo.getAddTime().getTime() / 1000L));
                result = iNewsService.update(np);
            }
        }
        if (!result) {
            log.error(BackendReMsg.NEWSSAVE_ERROR + ",param->type:[{}],newsVo[{}]", type, newsVo.toString());
            model.addAttribute("msg", BackendReMsg.NEWSSAVE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/news/list");
        return "backend/success";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete")
    public String delete(@RequestParam(defaultValue = "0") int id, Model model) {
        log.info("id:[{}]", id);
        if (id == 0) {
            log.error("参数错误,id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
        }
        boolean result = iNewsService.deleteById(id);
        if (!result) {
            model.addAttribute("msg", BackendReMsg.NEWSDELETE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/news/list");
        return "backend/success";
    }
}
