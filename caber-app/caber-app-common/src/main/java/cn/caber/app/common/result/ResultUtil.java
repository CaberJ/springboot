package cn.caber.app.common.result;

public class ResultUtil {
    public static final Integer SUCCESS_CODE = 0;
    public static final String SUCCESS_MESSAGE = "请求成功";
    public static final Integer FAIL_CODE = 0;
    public static final String FAIL_MESSAGE = "请求成功";

    public static Result<Void> success() {
        Result<Void> response = new Result<Void>();
        response.setCode(SUCCESS_CODE);
        response.setMessage(SUCCESS_MESSAGE);
        return response;
    }

    public static <T> Result<T> success(T data) {
        Result<T> response = new Result<T>();
        response.setCode(SUCCESS_CODE);
        response.setMessage(SUCCESS_MESSAGE);
        response.setData(data);
        return response;
    }

    public static Result fail() {
        Result<Void> response = new Result<Void>();
        response.setCode(FAIL_CODE);
        response.setMessage(FAIL_MESSAGE);
        return response;
    }

    public static Result fail(String message) {
        Result<Void> response = new Result<Void>();
        response.setCode(FAIL_CODE);
        response.setMessage(message);
        return response;
    }
}
