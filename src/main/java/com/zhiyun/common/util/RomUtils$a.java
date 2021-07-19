/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.common.util;

public class RomUtils$a {
    private String a;
    private String b;

    public static /* synthetic */ String a(RomUtils$a romUtils$a) {
        return romUtils$a.a;
    }

    public static /* synthetic */ String b(RomUtils$a romUtils$a, String string2) {
        romUtils$a.a = string2;
        return string2;
    }

    public static /* synthetic */ String c(RomUtils$a romUtils$a, String string2) {
        romUtils$a.b = string2;
        return string2;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RomInfo{name=");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append(", version=");
        string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

