/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.filter;

import com.zhiyun.net.BaseEntity;
import java.util.List;

public class FilterListBean
extends BaseEntity {
    private int count;
    private List list;

    public int getCount() {
        return this.count;
    }

    public List getList() {
        return this.list;
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public void setList(List list) {
        this.list = list;
    }
}

