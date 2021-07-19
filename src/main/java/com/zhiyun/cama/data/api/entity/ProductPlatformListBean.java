/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.net.BaseEntity;
import java.util.List;

public class ProductPlatformListBean
extends BaseEntity {
    private List data;
    private String ts;

    public List getData() {
        return this.data;
    }

    public String getTs() {
        return this.ts;
    }

    public void setData(List list) {
        this.data = list;
    }

    public void setTs(String string2) {
        this.ts = string2;
    }
}

