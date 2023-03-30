package cn.caber.caberspringbootstudy.exception;

import cn.caber.caberspringbootstudy.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class WebExceptionHandler {


    @ExceptionHandler(MyException.class)
    public Result handlerException(MyException me) {
        log.error(" 业务异常抛出：{}", me);
        return Result.fail("业务"+me.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        log.error(" 系统异常抛出：{}", e);
        return Result.fail("系统"+e.getMessage());
    }

  /*  @ExceptionHandler(MyChildException.class)
    public Result handlerException(MyChildException mce) {
        log.error(" 业务异常抛出：{}", mce);
        return Result.fail(mce.getLocalDateTime()+mce.getMessage());
    }*/

}
