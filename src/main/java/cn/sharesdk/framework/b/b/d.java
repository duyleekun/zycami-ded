/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b.b;

import cn.sharesdk.framework.b.b.c;

public class d
extends c {
    private static int d;
    private static long m;
    public String a;
    public int b;
    public String c = "";

    public String a() {
        return "[EVT]";
    }

    public void a(long l10) {
        m = l10;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 30;
    }

    public long d() {
        return d;
    }

    public long e() {
        return m;
    }

    public void f() {
        ++d;
    }

    public String toString() {
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder(string2);
        char c10 = '|';
        stringBuilder.append(c10);
        String string3 = this.a;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        string2 = this.c;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

