/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b.b;

import cn.sharesdk.framework.b.b.c;

public class a
extends c {
    private static int c;
    private static long d;
    public int a;
    public String b;

    public String a() {
        return "[API]";
    }

    public void a(long l10) {
        d = l10;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 50;
    }

    public long d() {
        return c;
    }

    public long e() {
        return d;
    }

    public void f() {
        ++c;
    }

    public String toString() {
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder(string2);
        char c10 = '|';
        stringBuilder.append(c10);
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        string2 = this.b;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

