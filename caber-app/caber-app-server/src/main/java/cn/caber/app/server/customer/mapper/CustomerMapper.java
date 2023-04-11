package cn.caber.app.server.customer.mapper;

import cn.caber.app.common.base.CaberMapper;
import cn.caber.app.server.common.page.PageEntry;
import cn.caber.app.server.customer.command.CustomerCmd;
import cn.caber.app.server.customer.command.CustomerPageQmd;
import cn.caber.app.server.customer.entity.Customer;
import cn.caber.app.server.customer.result.CustomerVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper extends CaberMapper {
    List<CustomerVo> getList(@Param("qmd") CustomerCmd cmd);

    Page<CustomerVo> getList(PageEntry<CustomerVo> page, @Param("qmd") CustomerPageQmd qmd);
}
