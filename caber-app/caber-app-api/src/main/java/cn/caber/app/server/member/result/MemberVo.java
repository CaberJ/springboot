package cn.caber.app.server.member.result;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MemberVo implements Serializable {

    private String name;

    private Integer age;

    private String address;

    private String personalizedSignature;

}
