package cn.caber.app.server.customer.fetcher;

import cn.caber.app.server.common.ann.BusinessFetcher;
import cn.caber.app.server.common.page.PageEntry;
import cn.caber.app.server.customer.command.CustomerCmd;
import cn.caber.app.server.customer.command.CustomerPageQmd;
import cn.caber.app.server.customer.mapper.CustomerMapper;
import cn.caber.app.server.customer.result.CustomerVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@BusinessFetcher
public class CustomerFetcher {

    @Autowired
    private CustomerMapper customerMapper;

    public List<CustomerVo> getList(CustomerCmd cmd) {
        return customerMapper.getList(cmd);
    }

    public Page<CustomerVo> page(CustomerPageQmd qmd, PageEntry<CustomerVo> pageEntry) {
        return customerMapper.getList(pageEntry, qmd);
    }

}
