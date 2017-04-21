package com.goldray.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by zwb on 2017/4/20.
 */
@Controller
public class PageController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 首页
     *
     * @return
     */
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("home", 1);
        return "frontend/index";
    }


    /**
     * aboutUs(关于我们);techSupport(技术支持);contactUs(联系我们)
     *
     * @return
     */
    @GetMapping("/nav/{page}")
    public String nav(@PathVariable("page") String page, Model model) {
        log.info("param page:[{}]", page);
        if (NAV_TYPE.get(page) == null) {
            log.error("param page:[{}] is error", page);
            return "redirect:/";
        }
        int richTextType = NAV_TYPE.get(page);
        model.addAttribute("page", page);
        model.addAttribute("richTextType", richTextType);
        model.addAttribute(page, 1);
        model.addAttribute("navIcon", NAV_ICO.get(richTextType));
        return "frontend/richText";
    }

    /**
     * 新闻中心
     *
     * @return
     */
    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("news", 1);
        return "frontend/newsList";
    }

    /**
     * 新闻中心详细
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/news/{id}")
    public String newsDetail(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "frontend/newsDetail";
    }

    /**
     * 产品详细
     *
     * @param code
     * @param model
     * @return
     */
    @GetMapping("/product/{code}")
    public String pdDetail(@PathVariable("code") String code, Model model) {
        model.addAttribute("code", code);
        return "frontend/productDetail";
    }

    @GetMapping("/admin")
    public String admin() {
        return "frontend/adminLogin";
    }
}
