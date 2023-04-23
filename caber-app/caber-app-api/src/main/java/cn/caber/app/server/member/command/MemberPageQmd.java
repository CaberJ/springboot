package cn.caber.app.server.member.command;

import cn.caber.app.common.base.BasePageQmd;
import cn.caber.app.server.member.result.MemberVo;

import java.time.LocalDateTime;

public class MemberPageQmd extends BasePageQmd<MemberVo> {

    private String name;

    private Integer age;

    private String address;

    private String university;

    private LocalDateTime graduateTime;
}
