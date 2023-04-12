package cn.caber.app.common.exception;

public enum ServiceErrorCode {

    ACCOUNT_EXIST("1000001", "账户已存在"),
    ACCOUNT_NOT_EXIST("1000002", "账户不存在"),
    ACCOUNT_SIGNUP_FAIL("1000003","账户注册失败"),
    ACCOUNT_PASSWORD_ERROR("1000004", "密码错误"),
    LOGIN_VERIFICATION_ERROR("1000005","登陆校验失败"),
    ACCOUNT_VERIFICATION_ERROR("1000006","账户校验失败"),
    ;
    private String errorCode;
    private String errorMessage;

    ServiceErrorCode(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void fire() {
        throw new ServiceException(this.errorMessage, this.errorCode);
    }

    public void throwIf(boolean flag) {
        if (flag) {
            throw new ServiceException(this.errorMessage, this.errorCode);
        }
    }
}
