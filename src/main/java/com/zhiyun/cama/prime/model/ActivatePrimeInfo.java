/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.model;

import com.zhiyun.net.BaseEntity;

public class ActivatePrimeInfo
extends BaseEntity {
    private int count;

    public int getCount() {
        return this.count;
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivatePrimeInfo{, count=");
        int n10 = this.count;
        stringBuilder.append(n10);
        stringBuilder.append(", errcode=");
        n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        String string2 = this.errmsg;
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

