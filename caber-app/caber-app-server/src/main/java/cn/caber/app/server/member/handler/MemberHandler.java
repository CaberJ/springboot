package cn.caber.app.server.member.handler;

import cn.caber.app.server.common.ann.BusinessHandler;
import cn.caber.app.server.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@BusinessHandler
public class MemberHandler {

    @Autowired
    private MemberMapper memberMapper;

}
