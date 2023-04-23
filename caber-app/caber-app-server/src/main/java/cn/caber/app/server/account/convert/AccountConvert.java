package cn.caber.app.server.account.convert;

import cn.caber.app.server.account.command.AccountCmd;
import cn.caber.app.server.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountConvert {

    AccountConvert INSTANCE = Mappers.getMapper(AccountConvert.class);

    Account convertToEntity(AccountCmd cmd);
}
