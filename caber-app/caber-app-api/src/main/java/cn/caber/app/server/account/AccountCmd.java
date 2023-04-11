package cn.caber.app.server.account;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class AccountCmd implements Serializable {


    @NotBlank
    private String accountNumber;

    @NotBlank
    private String password;

    @NotBlank
    private String name;
    private String phoneNumber;

    @Email
    private String email;

}
