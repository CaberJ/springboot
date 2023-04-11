package cn.caber.app.server.customer.service;

import cn.caber.app.server.common.page.PageUtil;
import cn.caber.app.server.customer.command.CustomerCmd;
import cn.caber.app.server.customer.command.CustomerPageQmd;
import cn.caber.app.server.customer.fetcher.CustomerFetcher;
import cn.caber.app.server.customer.result.CustomerVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService(interfaceClass = PersonService.class)
public class CustomerServiceImpl implements PersonService {

    @Autowired
    private CustomerFetcher customerFetcher;

    @Override
    public List<CustomerVo> getList(CustomerCmd customerCmd) {
        List<CustomerVo> list = customerFetcher.getList(customerCmd);
        return list;
    }

    @Override
    public Page<CustomerVo> page(CustomerPageQmd qmd) {
        return PageUtil.select(qmd, (pageEntry) -> customerFetcher.page(qmd, pageEntry));
    }
}
