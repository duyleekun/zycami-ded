/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

import com.tencent.liteav.beauty.c;

public class c$2
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ c b;

    public c$2(c c10, int n10) {
        this.b = c10;
        this.a = n10;
    }

    public void run() {
        c c10 = this.b;
        int n10 = c.f(c10);
        int n11 = c.g(this.b);
        int n12 = this.a;
        c.a(c10, n10, n11, n12);
    }
}

