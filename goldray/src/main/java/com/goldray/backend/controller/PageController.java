package com.goldray.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by zwb on 2017/4/21.
 */
@Controller("BPageController")
public class PageController {

    /**
     * 后台首页
     *
     * @return
     */
    @RequestMapping("/backend")
    public String index() {
        return "backend/index";
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping("/backend/logout")
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("adminLoginStatus");
        return "redirect:/";
    }
}
