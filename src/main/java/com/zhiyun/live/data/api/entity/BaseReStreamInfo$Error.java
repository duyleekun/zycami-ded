/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

public class BaseReStreamInfo$Error {
    public String code;
    public String message;
    public String name;
    public String status;
    public String statusCode;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error{statusCode='");
        String string2 = this.statusCode;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", status='");
        String string3 = this.status;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", code='");
        string3 = this.code;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", message='");
        string3 = this.message;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", name='");
        string3 = this.name;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

