package cn.caber.app.server.member.mapper;

import cn.caber.app.common.base.CaberMapper;
import cn.caber.app.server.common.page.PageEntry;
import cn.caber.app.server.member.command.MemberCmd;
import cn.caber.app.server.member.command.MemberPageQmd;
import cn.caber.app.server.member.result.MemberVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper extends CaberMapper {
    List<MemberVo> getList(@Param("qmd") MemberCmd cmd);

    Page<MemberVo> getList(PageEntry<MemberVo> page, @Param("qmd") MemberPageQmd qmd);
}
