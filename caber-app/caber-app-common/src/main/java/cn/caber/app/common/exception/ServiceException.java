package cn.caber.app.common.exception;

public class ServiceException extends RuntimeException{

    private String errorCode;

    public ServiceException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

}
