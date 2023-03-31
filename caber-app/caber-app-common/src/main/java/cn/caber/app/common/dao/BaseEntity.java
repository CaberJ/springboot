package cn.caber.app.common.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable, Cloneable {
    @TableField("id")
    private int id;
}
