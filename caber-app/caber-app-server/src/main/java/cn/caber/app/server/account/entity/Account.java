package cn.caber.app.server.account.entity;

import cn.caber.app.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("account")
public class Account extends BaseEntity {

    @TableField("account_number")
    private String accountNumber;
    @TableField("password")
    private String password;
    @TableField("name")
    private String name;
    @TableField("phone_number")
    private String phoneNumber;
    @TableField("email")
    private String email;
    @TableField("status")
    private Integer status;


}
