package cn.caber.app.server.account.handler;

import cn.caber.app.server.account.entity.Account;
import cn.caber.app.server.account.mapper.AccountMapper;
import cn.caber.app.server.common.ann.BusinessFetcher;
import cn.caber.app.server.common.ann.BusinessHandler;
import org.springframework.beans.factory.annotation.Autowired;

@BusinessHandler
public class AccountHandler {

    @Autowired
    private AccountMapper accountMapper;

    public String save(Account account) {
        int insert = accountMapper.insert(account);
        return account.getId();
    }

}
