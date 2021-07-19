/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.txcvodplayer.a;

public class a {
    public String a;
    public String b;
    public String c;

    public a(String string2, String string3, String string4) {
        this.a = string3;
        this.b = string2;
        this.c = string4;
    }

    public String a() {
        String string2 = "mp4";
        String string3 = this.c;
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return this.c();
        }
        return null;
    }

    public String b() {
        String string2 = "m3u8";
        String string3 = this.c;
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return this.c();
        }
        return null;
    }

    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append("/");
        string2 = this.b;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public String d() {
        return this.b;
    }
}

