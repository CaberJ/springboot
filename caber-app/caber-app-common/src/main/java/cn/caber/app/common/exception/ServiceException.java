package cn.caber.app.common.exception;

public class ServiceException extends RuntimeException{

    private Integer errorCode;

    public ServiceException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

}
