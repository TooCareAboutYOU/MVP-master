package com.mymvp.main;

/**
 * Created by admin on 2017/12/13.
 */

public class GetTradeDetailRequest {

    private int page;
    private int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "GetTradeDetailRequest{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
