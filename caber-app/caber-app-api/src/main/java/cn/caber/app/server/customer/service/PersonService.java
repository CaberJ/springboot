package cn.caber.app.server.customer.service;

import cn.caber.app.server.customer.command.CustomerCmd;
import cn.caber.app.server.customer.command.CustomerPageQmd;
import cn.caber.app.server.customer.result.CustomerVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface PersonService {

    List<CustomerVo> getList(CustomerCmd customerCmd);

    Page<CustomerVo> page(CustomerPageQmd qmd);
}
