/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.beauty.d;

public class d$6
implements Runnable {
    public final /* synthetic */ com.tencent.liteav.d a;

    public d$6(com.tencent.liteav.d d10) {
        this.a = d10;
    }

    public void run() {
        d d10 = com.tencent.liteav.d.l(this.a);
        if (d10 != null) {
            d10 = com.tencent.liteav.d.l(this.a);
            d10.b();
        }
    }
}

