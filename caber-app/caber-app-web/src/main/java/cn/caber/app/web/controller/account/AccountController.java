package cn.caber.app.web.controller.account;

import cn.caber.app.common.result.Result;
import cn.caber.app.common.result.ResultUtil;
import cn.caber.app.server.account.AccountCmd;
import cn.caber.app.server.model.service.AccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @DubboReference
    private AccountService accountService;

    @PostMapping("/signIn")
    Result<String> signIn(@Valid @RequestBody AccountCmd cmd) {
        String s = accountService.signIn(cmd);
        return ResultUtil.success(s);
    }

    @PostMapping("/login")
    Result<String> login(@Valid @RequestBody AccountCmd cmd) {
        String s = accountService.login(cmd);
        return ResultUtil.success(s);
    }

}
