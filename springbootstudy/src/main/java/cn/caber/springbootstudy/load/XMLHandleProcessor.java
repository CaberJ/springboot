package cn.caber.springbootstudy.load;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/5 10:07
 */
public class XMLHandleProcessor implements InitializingBean, ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }
}
