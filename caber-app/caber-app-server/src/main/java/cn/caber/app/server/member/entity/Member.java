package cn.caber.app.server.member.entity;

import cn.caber.app.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("caber")
public class Member extends BaseEntity {


    private String name;

    private Integer age;

    private String address;

    /**
     * 个性签名
     */
    private String personalizedSignature;
}
