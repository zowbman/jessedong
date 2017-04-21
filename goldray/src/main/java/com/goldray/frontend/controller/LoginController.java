package com.goldray.frontend.controller;

import com.goldray.config.CustomPropertyPlaceholderConfigurer;
import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.helper.CodeHelper;
import com.goldray.util.WebUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zwb on 2017/4/21.
 */
@Controller
@RequestMapping("/frontend/json")
public class LoginController {
    private Logger log = LoggerFactory.getLogger(getClass());

    private static final String ADMIN_USER_PREFIX = "custom.admin.user.";

    /**
     * 登陆/注销
     *
     * @param pwd
     * @return
     */
    @PostMapping("/v1/adminLogin")
    @ResponseBody
    public PubReturnMsg adminLogin(String username, String pwd, HttpSession httpSession, @CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId, HttpServletResponse resp) {
        log.info("param username:[{}],pwd:[{}]", username, pwd);
        if (username == null || "".equals(username) || pwd == null || "".equals(pwd)) {
            return new PubReturnMsg(CodeHelper.USERNAMEORPWDERROR);
        }
        String pendingPwd = DigestUtils.md5Hex(username + pwd);//待验证密码
        String rightPwd = CustomPropertyPlaceholderConfigurer.getStringValue(ADMIN_USER_PREFIX + username);//正确密码
        if (rightPwd == null || "".equals(rightPwd) || !pendingPwd.equals(rightPwd)) {
            log.info("param pendingPwd:[{}],rightPwd:[{}] fail password", pendingPwd, rightPwd);
            return new PubReturnMsg(CodeHelper.USERNAMEORPWDERROR);
        }
        //存session
        httpSession.setAttribute("adminLoginStatus", true);
        WebUtil.addCookie(resp, "adminLoginStatus", sessionId, 30 * 60);
        return new PubReturnMsg(CodeHelper.SUCCESS, "登陆成功", "/backend");
    }
}
