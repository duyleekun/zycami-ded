/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

import com.tencent.liteav.beauty.a;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.c;

public class c$5
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ c b;

    public c$5(c c10, int n10) {
        this.b = c10;
        this.a = n10;
    }

    public void run() {
        Object object;
        int n10 = this.a;
        if (n10 > 0) {
            object = com.tencent.liteav.beauty.a.a();
            ((a)object).d();
        }
        if ((object = c.e(this.b)) != null && (n10 = this.a) >= 0) {
            object = c.e(this.b);
            int n11 = this.a;
            ((b)object).e(n11);
        }
    }
}

