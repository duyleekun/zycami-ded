/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

public class QiniuAccessor$QiniuMKFileResponseData {
    public String hash;
    public String key;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QiniuMKFileResponseData{key='");
        String string2 = this.key;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", hash='");
        String string3 = this.hash;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

