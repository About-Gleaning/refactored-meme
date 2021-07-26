package com.liurui.meme.api.core.base;

import com.google.common.base.Strings;
import com.liurui.arsenal.base.web.bean.person.UserContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private HttpSession session;

    public UserContext getUserContext() {
        var userId = Strings.nullToEmpty(request.getHeader("userId"));
        var userName = Strings.nullToEmpty(request.getHeader("userName"));
        var token = Strings.nullToEmpty(request.getHeader("token"));
        return UserContext.getInstance()
                .setUserId(userId)
                .setUserName(userName)
                .setToken(token);
    }

}
