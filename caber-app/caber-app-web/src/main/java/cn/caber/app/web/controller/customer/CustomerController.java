package cn.caber.app.web.controller.customer;

import cn.caber.app.server.customer.command.CustomerCmd;
import cn.caber.app.server.customer.command.CustomerPageQmd;
import cn.caber.app.server.customer.result.CustomerVo;
import cn.caber.app.server.customer.service.PersonService;
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
    private PersonService personService;

    @PostMapping("/getList")
    List<CustomerVo> getList(@RequestBody CustomerCmd cmd) {
        return personService.getList(cmd);
    }

    @PostMapping("/page")
    Page<CustomerVo> page(@RequestBody CustomerPageQmd qmd) {
        return personService.page(qmd);
    }

}
