package com.goldray.backend.interceptor;

import com.goldray.backend.common.CurrentLoginStatus;
import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.helper.CodeHelper;
import com.goldray.util.JacksonMapper;
import com.goldray.util.WebUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zwb on 2017/3/12.
 */
public class CheckPrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean status = CurrentLoginStatus.get(request, response);//获取当前登陆状态
        if (!status) {
            if (WebUtil.isAjaxRequest(request)) {//ajax
                response.setContentType("application/json;charset=UTF-8");
                response.getOutputStream().print(JacksonMapper.getJsonString(new PubReturnMsg(CodeHelper.AJAXNOPRIVILEGE)));
            } else {
                response.sendRedirect("/jsp/noPrivilege.jsp");
            }
        }
        return status;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
