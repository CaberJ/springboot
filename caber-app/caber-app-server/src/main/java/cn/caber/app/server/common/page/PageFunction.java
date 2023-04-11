package cn.caber.app.server.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface PageFunction<T> {

    Page<T> select(PageEntry<T> pageEntry);
}
