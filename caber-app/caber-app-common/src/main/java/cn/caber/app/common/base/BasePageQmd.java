package cn.caber.app.common.base;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class BasePageQmd<T> implements Serializable {

    /**
     * 当前页
     */
    @NotNull(message = "当前页不能为空")
    public Long current = 1L;

    /**
     * 每页显示条数，默认 10
     */
    @NotNull(message = "每页显示条数不能为空")
    public Long size = 10L;

    /**
     * 排序字段
     */
    public String order;

}
