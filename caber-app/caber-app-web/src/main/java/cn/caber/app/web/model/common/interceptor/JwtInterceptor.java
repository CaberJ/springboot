package cn.caber.app.web.model.common.interceptor;

import cn.caber.app.web.model.common.constant.AuthenticationConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AuthenticationConstant.JWT_TOKEN_KEY);

        return true;
    }

}
