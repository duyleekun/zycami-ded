/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity.speed;

import java.util.List;

public class CurveTemp {
    private List list;

    public CurveTemp(List list) {
        this.list = list;
    }

    public List getList() {
        return this.list;
    }

    public CurveTemp setList(List list) {
        this.list = list;
        return this;
    }
}

