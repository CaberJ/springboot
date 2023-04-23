package cn.caber.app.web.controller.customer;

import cn.caber.app.server.member.command.MemberCmd;
import cn.caber.app.server.member.command.MemberPageQmd;
import cn.caber.app.server.member.result.MemberVo;
import cn.caber.app.server.member.service.MemberService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class CustomerController {

    @DubboReference
    private MemberService memberService;

    @PostMapping("/getList")
    List<MemberVo> getList(@RequestBody MemberCmd cmd) {
        return memberService.getList(cmd);
    }

    @PostMapping("/page")
    Page<MemberVo> page(@RequestBody MemberPageQmd qmd) {
        return memberService.page(qmd);
    }

}
