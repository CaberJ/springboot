package cn.caber.app.server.customer.command;

import cn.caber.app.common.base.BasePageQmd;
import cn.caber.app.server.customer.result.CustomerVo;

import java.time.LocalDateTime;

public class CustomerPageQmd extends BasePageQmd<CustomerVo> {

    private String name;

    private Integer age;

    private String address;

    private String university;

    private LocalDateTime graduateTime;
}
