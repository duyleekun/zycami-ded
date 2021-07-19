/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.renderer.d;

public class d$1
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;

    public d$1(d d10, int n10) {
        this.b = d10;
        this.a = n10;
    }

    public void run() {
        d d10 = this.b;
        int n10 = this.a;
        d10.b(n10);
    }
}

