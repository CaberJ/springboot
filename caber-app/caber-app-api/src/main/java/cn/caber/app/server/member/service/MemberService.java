package cn.caber.app.server.member.service;

import cn.caber.app.server.member.command.MemberCmd;
import cn.caber.app.server.member.command.MemberPageQmd;
import cn.caber.app.server.member.result.MemberVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface MemberService {

    List<MemberVo> getList(MemberCmd memberCmd);

    Page<MemberVo> page(MemberPageQmd qmd);
}
