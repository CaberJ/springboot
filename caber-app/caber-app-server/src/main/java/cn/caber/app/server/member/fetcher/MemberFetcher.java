package cn.caber.app.server.member.fetcher;

import cn.caber.app.server.common.ann.BusinessFetcher;
import cn.caber.app.server.common.page.PageEntry;
import cn.caber.app.server.member.command.MemberCmd;
import cn.caber.app.server.member.command.MemberPageQmd;
import cn.caber.app.server.member.mapper.MemberMapper;
import cn.caber.app.server.member.result.MemberVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@BusinessFetcher
public class MemberFetcher {

    @Autowired
    private MemberMapper memberMapper;

    public List<MemberVo> getList(MemberCmd cmd) {
        return memberMapper.getList(cmd);
    }

    public Page<MemberVo> page(MemberPageQmd qmd, PageEntry<MemberVo> pageEntry) {
        return memberMapper.getList(pageEntry, qmd);
    }

}
