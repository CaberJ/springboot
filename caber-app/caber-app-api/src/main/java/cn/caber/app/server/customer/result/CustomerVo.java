package cn.caber.app.server.customer.result;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CustomerVo implements Serializable {

    private String name;

    private Integer age;

    private String address;

    private String university;

    private LocalDateTime graduateTime;
}
