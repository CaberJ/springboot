package cn.caber.app.server.model.entity;

import cn.caber.app.common.dao.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("caber")
public class Person extends BaseEntity {


    private String name;

    private Integer age;

    private String address;

    private String university;
    @TableField("graduate_time")
    private LocalDateTime graduateTime;
}
