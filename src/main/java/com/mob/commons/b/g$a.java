/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.b;

public class g$a {
    private String a;
    private long b;
    private String c;

    public g$a(String string2) {
        this.a = string2;
    }

    public static /* synthetic */ String a(g$a g$a) {
        return g$a.c;
    }

    public static /* synthetic */ String b(g$a g$a) {
        return g$a.a;
    }

    public String a() {
        return this.c;
    }

    public void a(long l10) {
        this.b = l10;
    }

    public void a(String string2) {
        this.c = string2;
    }

    public boolean b() {
        long l10 = this.b;
        long l11 = System.currentTimeMillis();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

