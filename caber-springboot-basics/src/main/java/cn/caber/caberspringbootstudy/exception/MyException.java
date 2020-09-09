package cn.caber.caberspringbootstudy.exception;

public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;
    public MyException(int code,String msg){
        super(msg);
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }
}
