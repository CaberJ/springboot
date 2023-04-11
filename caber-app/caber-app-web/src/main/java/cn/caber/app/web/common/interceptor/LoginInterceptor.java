package cn.caber.app.web.common.interceptor;

import cn.caber.app.common.constant.LogInConstant;
import cn.caber.app.common.context.CaberLoginContext;
import cn.caber.app.common.exception.ServiceErrorCode;
import cn.caber.app.common.util.JwtUtil;
import cn.caber.app.web.common.constant.AuthenticationConstant;
import cn.caber.app.web.common.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("权限校验拦截器");
        String token = request.getHeader(AuthenticationConstant.JWT_TOKEN_KEY);
        Map<String, Object> data = null;
        try {
            data = JwtUtil.parseJwt(token);
        } catch (Exception e) {
            ResponseUtil.write(response, HttpStatus.FORBIDDEN, ServiceErrorCode.LOGIN_VERIFICATION_ERROR);
        }
        CaberLoginContext.put(LogInConstant.OPERATOR, data.get(LogInConstant.OPERATOR));
        CaberLoginContext.put(LogInConstant.ACCOUNT, data.get(LogInConstant.ACCOUNT));
        CaberLoginContext.put(LogInConstant.NAME, data.get(LogInConstant.NAME));
        return true;
    }

}