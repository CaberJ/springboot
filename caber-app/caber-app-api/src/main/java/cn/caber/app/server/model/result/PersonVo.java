package cn.caber.app.server.model.result;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PersonVo implements Serializable {
    private String name;

    private Integer age;

    private String address;

    private String university;

    private LocalDateTime graduateTime;
}
