package cn.caber.app.common.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private Integer code;
    private T data;
    private String message;

}
