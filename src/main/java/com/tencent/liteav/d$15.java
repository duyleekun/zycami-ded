/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.d;

public class d$15
implements Runnable {
    public final /* synthetic */ d a;

    public d$15(d d10) {
        this.a = d10;
    }

    public void run() {
        int n10;
        Object object = d.e(this.a);
        if (object != null) {
            object = d.e(this.a);
            n10 = 1;
            object.b(n10 != 0);
        }
        object = this.a;
        n10 = d.c((d)object).width;
        int n11 = d.c((d)this.a).height;
        d.a((d)object, n10, n11);
        object = this.a;
        n10 = d.i((d)object);
        ((d)object).a(n10);
    }
}

