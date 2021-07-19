/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

public class gm {
    private String a;

    public gm(String string2) {
        this.a = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream:error (");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

