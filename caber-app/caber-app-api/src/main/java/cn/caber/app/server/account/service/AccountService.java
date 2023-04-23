package cn.caber.app.server.account.service;

import cn.caber.app.server.account.command.AccountCmd;

public interface AccountService {

    String signup(AccountCmd cmd);

    String login(AccountCmd cmd);

    void logout(String token);

    String checkAccount(AccountCmd cmd);

    void resetPassword(AccountCmd cmd);

    void updatePassword(AccountCmd cmd);

    void closeAccount(AccountCmd cmd);
}
