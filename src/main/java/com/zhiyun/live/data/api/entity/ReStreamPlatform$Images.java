/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

public class ReStreamPlatform$Images {
    public String png;
    public String svg;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Images{png='");
        String string2 = this.png;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", svg='");
        String string3 = this.svg;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

