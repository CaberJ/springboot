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
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@DubboService(interfaceClass = AccountService.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountFetcher accountFetcher;

    @Autowired
    private AccountHandler accountHandler;

    @Override
    public String signIn(AccountCmd cmd) {
        if (StringUtils.isNotBlank(cmd.getPhoneNumber())) {
            // 优先手机注册
            Account byPhone = accountFetcher.getByPhone(cmd.getPhoneNumber());
            ServiceErrorCode.ACCOUNT_EXIST.throwIf(Objects.nonNull(byPhone));
            // todo 手机短信验证
        } else if (StringUtils.isNotBlank(cmd.getEmail())) {
            Account byEmail = accountFetcher.getByEmail(cmd.getEmail());
            ServiceErrorCode.ACCOUNT_EXIST.throwIf(Objects.nonNull(byEmail));
            //  todo  邮箱验证
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
        String jwt = JwtUtil.createJwt(data, 12L * 60L * 60L * 1000L);
        return jwt;
    }

    @Override
    public void logout() {
    }

}
