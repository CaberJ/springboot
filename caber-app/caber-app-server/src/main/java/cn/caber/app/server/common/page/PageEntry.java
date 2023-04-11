package cn.caber.app.server.common.page;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class PageEntry<T> extends Page<T> {

    public PageEntry() {
    }

    public PageEntry(long current, long size) {
        super(current, size);
    }

    public PageEntry(long current, long size, long total) {
        super(current, size, total);
    }

    public PageEntry(long current, long size, boolean isSearchCount) {
        super(current, size, isSearchCount);
    }

    public PageEntry(long current, long size, long total, boolean isSearchCount) {
        super(current, size, total, isSearchCount);
    }

}
