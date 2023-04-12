package cn.caber.app.web.controller.account;

import cn.caber.app.common.base.Result;
import cn.caber.app.common.base.ResultUtil;
import cn.caber.app.server.account.AccountCmd;
import cn.caber.app.server.customer.service.AccountService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
        String s = accountService.signup(cmd);
        return ResultUtil.success(s);
    }

    @PostMapping("/login")
    Result<String> login(@Valid @RequestBody AccountCmd cmd) {
        String s = accountService.login(cmd);
        return ResultUtil.success(s);
    }

    @GetMapping("/logout")
    Result<Void> login(@RequestHeader("token") String token) {
        accountService.logout(token);
        return ResultUtil.success();
    }

    @PostMapping("/checkAccount")
    Result<Void> checkAccount(@Valid @RequestBody AccountCmd cmd) {
        accountService.checkAccount(cmd);
        return ResultUtil.success();
    }

    @PostMapping("/resetPassword")
    Result<Void> resetPassword(@Valid @RequestBody AccountCmd cmd) {
        accountService.resetPassword(cmd);
        return ResultUtil.success();
    }

    @PostMapping("/updatePassword")
    Result<Void> updatePassword(@Valid @RequestBody AccountCmd cmd) {
        accountService.updatePassword(cmd);
        return ResultUtil.success();
    }

    @PostMapping("/closeAccount")
    Result<Void> closeAccount(@Valid @RequestBody AccountCmd cmd) {
        accountService.closeAccount(cmd);
        return ResultUtil.success();
    }


}
