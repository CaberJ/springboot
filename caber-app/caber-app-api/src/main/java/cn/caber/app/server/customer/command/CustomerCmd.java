package cn.caber.app.server.customer.command;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CustomerCmd implements Serializable {

    private String name;

    private Integer age;

    private String address;

    private String university;

    private LocalDateTime graduateTime;
}
