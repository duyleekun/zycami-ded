/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

public class LiveKwaiUserInfo$UserInfo {
    public String bigHead;
    public String city;
    public String head;
    public String name;
    public String sex;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserInfo{name='");
        String string2 = this.name;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", sex='");
        String string3 = this.sex;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", head='");
        string3 = this.head;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", bigHead='");
        string3 = this.bigHead;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", city='");
        string3 = this.city;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

