package cn.caber.caberspringbootstudy.common;

public class Result<T> {
    private String code;
    private T data;
    private String message;

    public Result(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Result fail(String message){
        return new Result("1",message);
    }

    public static Result success(String message){
        return new Result("0",message);
    }

    public static  <T> Result<T> success(T data){
        return new Result<T>("0",data);
    }
}
