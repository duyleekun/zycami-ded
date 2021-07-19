/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.d;

public class d$13
implements Runnable {
    public final /* synthetic */ d a;

    public d$13(d d10) {
        this.a = d10;
    }

    public void run() {
        d d10 = this.a;
        int n10 = d.c((d)d10).width;
        int n11 = d.c((d)this.a).height;
        d.a(d10, n10, n11);
    }
}

