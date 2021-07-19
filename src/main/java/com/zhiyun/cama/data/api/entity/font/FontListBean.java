/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.font;

import com.zhiyun.net.BaseEntity;
import java.util.List;

public class FontListBean
extends BaseEntity {
    private int count;
    private List list;

    public int getCount() {
        return this.count;
    }

    public List getList() {
        return this.list;
    }

    public FontListBean setCount(int n10) {
        this.count = n10;
        return this;
    }

    public FontListBean setList(List list) {
        this.list = list;
        return this;
    }
}

