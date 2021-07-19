/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.d;

public class d$3
implements Runnable {
    public final /* synthetic */ d a;

    public d$3(d d10) {
        this.a = d10;
    }

    public void run() {
        d d10 = this.a;
        int n10 = d.a(d10);
        int n11 = d.b(this.a);
        d.a(d10, n10, n11);
        d10 = this.a;
        n10 = d.c(d10);
        d10.b(n10);
        d10 = this.a;
        n10 = d.d(d10);
        d10.d(n10);
    }
}

