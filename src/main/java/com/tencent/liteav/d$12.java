/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.n;

public class d$12
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ d b;

    public d$12(d d10, boolean bl2) {
        this.b = d10;
        this.a = bl2;
    }

    public void run() {
        boolean bl2;
        n n10 = d.e(this.b);
        if (n10 == null) {
            return;
        }
        int bl22 = d.d((d)this.b).h;
        n10.f(bl22);
        int n11 = d.d((d)this.b).l;
        n10.e(n11);
        Object object = d.d((d)this.b).k;
        n10.a((c)((Object)object));
        int n12 = d.d((d)this.b).a;
        g g10 = d.d(this.b);
        int n13 = g10.b;
        n10.a(n12, n13);
        object = d.d(this.b);
        boolean bl3 = ((g)object).U;
        n10.e(bl3);
        boolean bl4 = this.a;
        if (bl4 && (bl2 = n10.d())) {
            boolean bl5 = false;
            object = null;
            n10.b(false);
        }
    }
}

