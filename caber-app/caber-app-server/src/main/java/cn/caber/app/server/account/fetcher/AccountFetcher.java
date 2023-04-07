package cn.caber.app.server.account.fetcher;

import cn.caber.app.server.account.entity.Account;
import cn.caber.app.server.account.mapper.AccountMapper;
import cn.caber.app.server.common.ann.BusinessFetcher;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

@BusinessFetcher
public class AccountFetcher {

    @Autowired
    private AccountMapper accountMapper;

    public Account getByAccount(String accountStr) {
        QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
        accountQueryWrapper.eq("account", accountStr);
        return accountMapper.selectOne(accountQueryWrapper);
    }

    public Account getByEmail(String email) {
        QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
        accountQueryWrapper.eq("email", email);
        return accountMapper.selectOne(accountQueryWrapper);
    }

    public Account getByPhone(String phoneNumber) {
        QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
        accountQueryWrapper.eq("phone_number", phoneNumber);
        return accountMapper.selectOne(accountQueryWrapper);
    }


}
