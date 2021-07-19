/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.f;

import com.huawei.updatesdk.a.b.b.b;
import com.huawei.updatesdk.b.f.a;
import com.huawei.updatesdk.b.f.c$a;

public final class c {
    private static c a;
    private static a b;

    static {
        Object object = new c();
        a = object;
        b = object = new c$a();
    }

    private c() {
    }

    public static a a() {
        return b;
    }

    public static c b() {
        return a;
    }

    public void a(b b10) {
        b.a(1, b10);
    }

    public void b(b b10) {
        b.a(0, b10);
    }

    public void c(b b10) {
        b.a(2, b10);
    }
}

