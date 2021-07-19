/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.d;

public class b {
    private long a;
    private long b;
    private String c;
    private String d;
    private String e;

    public b() {
    }

    public b(String string2, long l10, String string3) {
        this.c = string2;
        this.b = l10;
        this.d = string3;
    }

    public long a() {
        return this.a;
    }

    public void a(int n10) {
        long l10;
        this.a = l10 = (long)n10;
    }

    public void a(long l10) {
        this.b = l10;
    }

    public void a(String string2) {
        this.e = string2;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.d;
    }

    public long e() {
        return this.b;
    }
}

