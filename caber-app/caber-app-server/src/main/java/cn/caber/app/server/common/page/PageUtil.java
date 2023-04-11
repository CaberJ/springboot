package cn.caber.app.server.common.page;

import cn.caber.app.common.base.BasePageQmd;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageUtil {

    public static <T> Page<T> select(BasePageQmd qmd, PageFunction<T> function) {
        return function.select(of(qmd));
    }

    public static <T> PageEntry<T> of(BasePageQmd<T> basePageQmd) {
        return new PageEntry<T>(basePageQmd.current, basePageQmd.size);
    }

}
