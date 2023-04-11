package cn.caber.app.server.customer.handler;

import cn.caber.app.server.common.ann.BusinessHandler;
import cn.caber.app.server.customer.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@BusinessHandler
public class CustomerHandler {

    @Autowired
    private CustomerMapper customerMapper;

}
