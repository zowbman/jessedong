package com.goldray.backend.common;

import com.goldray.listener.SesstionListener;
import com.goldray.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zwb on 2017/3/12.
 */
public class CurrentLoginStatus {
    /**
     * 获取当前登陆状态
     *
     * @param request
     * @param response
     * @return
     */
    public static boolean get(HttpServletRequest request, HttpServletResponse response) {
        Boolean loginStatus = (Boolean) request.getSession().getAttribute("adminLoginStatus");
        if (loginStatus != null && !loginStatus) {
            String sid = WebUtil.getCookieByName(request, "currentAdminLoginStatus");
            if (sid != null) {
                HttpSession session = SesstionListener.getSession(sid);
                if (session != null) {
                    loginStatus = (Boolean) session.getAttribute("currentAdminLoginStatus");
                    if (loginStatus != null && loginStatus) {
                        SesstionListener.removeSession(sid);
                        request.getSession().setAttribute("currentAdminLoginStatus", loginStatus);
                        WebUtil.addCookie(response, "currentAdminLoginStatus", request.getSession().getId(), 30 * 60);
                    }
                }
            }
        }
        return loginStatus == null ? false : loginStatus;
    }
}
