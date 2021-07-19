/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net;

import com.zhiyun.net.Punish;

public class BaseEntity {
    public int errcode;
    public String errmsg = "";
    public Punish punish;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseEntity{errcode=");
        int n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        Object object = this.errmsg;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", result=");
        object = this.punish;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

