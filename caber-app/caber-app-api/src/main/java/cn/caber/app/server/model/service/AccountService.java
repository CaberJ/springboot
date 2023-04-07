package cn.caber.app.server.model.service;

import cn.caber.app.server.account.AccountCmd;

public interface AccountService {

    String signIn(AccountCmd cmd);

    String login(AccountCmd cmd);
}
