package cn.caber.caberspringbootstudy.exception;

import java.time.LocalDateTime;

public class MyChildException extends MyException {
    private LocalDateTime localDateTime;


    public MyChildException(int code, String msg) {
        super(code, msg);
        this.localDateTime = LocalDateTime.now();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
