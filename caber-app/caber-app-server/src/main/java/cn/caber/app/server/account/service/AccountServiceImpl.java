package cn.caber.app.server.account.service;

import cn.caber.app.common.constant.LogInConstant;
import cn.caber.app.common.exception.ServiceErrorCode;
import cn.caber.app.common.util.JwtUtil;
import cn.caber.app.common.util.Md5Util;
import cn.caber.app.server.account.AccountCmd;
import cn.caber.app.server.account.convert.AccountConvert;
import cn.caber.app.server.account.entity.Account;
import cn.caber.app.server.account.fetcher.AccountFetcher;
import cn.caber.app.server.account.handler.AccountHandler;
import cn.caber.app.server.customer.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@DubboService(interfaceClass = AccountService.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountFetcher accountFetcher;

    @Autowired
    private AccountHandler accountHandler;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${login.duration}")
    private Long duration = 12L;

    @Override
    public String signup(AccountCmd cmd) {
        if (StringUtils.isNotBlank(cmd.getPhoneNumber())) {
            Account byPhone = accountFetcher.getByPhone(cmd.getPhoneNumber());
            ServiceErrorCode.ACCOUNT_EXIST.throwIf(Objects.nonNull(byPhone));
            // todo 手机短信验证
        } else if (StringUtils.isNotBlank(cmd.getEmail())) {
            Account byEmail = accountFetcher.getByEmail(cmd.getEmail());
            ServiceErrorCode.ACCOUNT_EXIST.throwIf(Objects.nonNull(byEmail));
            //  todo  邮箱验证
        } else {
            ServiceErrorCode.ACCOUNT_SIGNUP_FAIL.fire();
        }
        Account account = AccountConvert.INSTANCE.convertToEntity(cmd);
        account.setOperatorId("");
        account.setPassword(Md5Util.encrypt(account.getPassword()));
        String id = accountHandler.save(account);
        account.setOperatorId(id);
        accountHandler.update(account);
        return id;
    }

    @Override
    public String login(AccountCmd cmd) {
        Account account = accountFetcher.getByAccount(cmd.getAccountNumber());
        ServiceErrorCode.ACCOUNT_NOT_EXIST.throwIf(Objects.isNull(account));
        String encrypt = Md5Util.encrypt(cmd.getPassword());
        ServiceErrorCode.ACCOUNT_PASSWORD_ERROR.throwIf(!account.getPassword().equals(encrypt));
        Map<String, Object> data = new HashMap<>();
        data.put(LogInConstant.NAME, account.getAccountNumber());
        data.put(LogInConstant.ACCOUNT, account.getAccountNumber());
        data.put(LogInConstant.OPERATOR, account.getId());
        String jwt = JwtUtil.createJwt(data, duration * 60L * 60L * 1000L);
        return jwt;
    }

    @Override
    public void logout(String token) {
        redisTemplate.boundValueOps(LogInConstant.REDIS_LOGOUT_PREFIX + token).set("1", duration, TimeUnit.HOURS);
    }

    @Override
    public String checkAccount(AccountCmd cmd) {
        if (StringUtils.isNotBlank(cmd.getPhoneNumber())) {
            Account byPhone = accountFetcher.getByPhone(cmd.getPhoneNumber());
            ServiceErrorCode.ACCOUNT_NOT_EXIST.throwIf(Objects.isNull(byPhone));
            return byPhone.getId();
            // todo 手机短信验证
        } else if (StringUtils.isNotBlank(cmd.getEmail())) {
            Account byEmail = accountFetcher.getByEmail(cmd.getEmail());
            ServiceErrorCode.ACCOUNT_NOT_EXIST.throwIf(Objects.isNull(byEmail));
            return byEmail.getId();
            //  todo  邮箱验证
        } else {
            ServiceErrorCode.ACCOUNT_VERIFICATION_ERROR.fire();
        }
        return null;
    }

    @Override
    public void resetPassword(AccountCmd cmd) {
        String id = checkAccount(cmd);
        Account account = new Account();
        account.setId(id);
        account.setPassword(Md5Util.encrypt(cmd.getPassword()));
        accountHandler.update(account);
    }

    @Override
    public void updatePassword(AccountCmd cmd) {
        Account byAccount = accountFetcher.getByAccount(cmd.getAccountNumber());
        ServiceErrorCode.ACCOUNT_NOT_EXIST.throwIf(Objects.isNull(byAccount));
        ServiceErrorCode.ACCOUNT_PASSWORD_ERROR.throwIf(!Md5Util.encrypt(cmd.getNewPassword()).equals(byAccount.getPassword()));
        Account account = new Account();
        account.setId(byAccount.getId());
        account.setPassword(Md5Util.encrypt(cmd.getNewPassword()));
        accountHandler.update(account);
    }

    @Override
    public void closeAccount(AccountCmd cmd) {
        Account byAccount = accountFetcher.getByAccount(cmd.getAccountNumber());
        ServiceErrorCode.ACCOUNT_NOT_EXIST.throwIf(Objects.isNull(byAccount));
        Account account = new Account();
        account.setId(byAccount.getId());
        account.setStatus(LogInConstant.STATUS_CLOSE);
        accountHandler.update(account);
    }


}
