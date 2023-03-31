package cn.caber.app.common.web;

import cn.caber.app.common.exception.ServiceException;
import cn.caber.app.common.result.Result;
import cn.caber.app.common.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public Result handlerException(ServiceException serviceException) {
        log.error(" 业务异常抛出：{}", serviceException);
        return ResultUtil.fail(serviceException.getMessage());
    }

}
