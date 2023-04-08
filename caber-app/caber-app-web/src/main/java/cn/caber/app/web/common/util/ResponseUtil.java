package cn.caber.app.web.common.util;

import cn.caber.app.common.exception.ServiceErrorCode;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtil {

    public static HttpServletResponse write(HttpServletResponse httpServletResponse, HttpStatus status, ServiceErrorCode errorCode) {
        httpServletResponse.reset();
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setStatus(status.value());
        httpServletResponse.setContentType("application/json;charset=UTF-8");

        PrintWriter writer = null;
        try {
            writer = httpServletResponse.getWriter();
            writer.write(errorCode.getErrorMessage());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpServletResponse;

    }
}
