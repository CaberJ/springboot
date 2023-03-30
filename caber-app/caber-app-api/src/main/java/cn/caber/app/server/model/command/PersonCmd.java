package cn.caber.app.server.model.command;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonCmd {

    private String name;

    private Integer age;

    private String address;

    private String university;

    private LocalDateTime graduateTime;
}
