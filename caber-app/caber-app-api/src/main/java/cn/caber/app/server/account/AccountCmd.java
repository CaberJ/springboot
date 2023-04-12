package cn.caber.app.server.account;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

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

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String phoneNumber;

    @Email
    private String email;

    private String newPassword;

}
