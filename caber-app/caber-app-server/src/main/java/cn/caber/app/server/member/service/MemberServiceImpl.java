package cn.caber.app.server.member.service;

import cn.caber.app.server.common.page.PageUtil;
import cn.caber.app.server.member.command.MemberCmd;
import cn.caber.app.server.member.command.MemberPageQmd;
import cn.caber.app.server.member.fetcher.MemberFetcher;
import cn.caber.app.server.member.result.MemberVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService(interfaceClass = MemberService.class)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberFetcher memberFetcher;

    @Override
    public List<MemberVo> getList(MemberCmd memberCmd) {
        List<MemberVo> list = memberFetcher.getList(memberCmd);
        return list;
    }

    @Override
    public Page<MemberVo> page(MemberPageQmd qmd) {
        return PageUtil.select(qmd, (pageEntry) -> memberFetcher.page(qmd, pageEntry));
    }
}
