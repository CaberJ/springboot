package cn.caber.app.web.common.interceptor;

import cn.caber.app.common.constant.LogInConstant;
import cn.caber.app.common.context.CaberLoginContext;
import cn.caber.app.common.util.JwtUtil;
import cn.caber.app.web.common.constant.AuthenticationConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(AuthenticationConstant.JWT_TOKEN_KEY);
        Map<String, Object> data = JwtUtil.parseJwt(token);
        CaberLoginContext.put(LogInConstant.OPERATOR, data.get(LogInConstant.OPERATOR));
        CaberLoginContext.put(LogInConstant.ACCOUNT, data.get(LogInConstant.ACCOUNT));
        CaberLoginContext.put(LogInConstant.NAME, data.get(LogInConstant.NAME));
        return true;
    }

}
