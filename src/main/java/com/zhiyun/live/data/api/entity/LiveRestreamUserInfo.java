/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

public class LiveRestreamUserInfo {
    public String email;
    public int id;
    public String userName;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LiveRestreamUserInfo{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", userName='");
        String string2 = this.userName;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", email='");
        String string3 = this.email;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

