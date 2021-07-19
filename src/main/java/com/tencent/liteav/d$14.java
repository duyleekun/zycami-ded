/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.videoencoder.b;

public class d$14
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ d d;

    public d$14(d d10, int n10, int n11, int n12) {
        this.d = d10;
        this.a = n10;
        this.b = n11;
        this.c = n12;
    }

    public void run() {
        int n10;
        Object object;
        int n11 = this.a;
        if (n11 != 0 && (n11 = this.b) != 0) {
            object = com.tencent.liteav.d.d(this.d);
            ((g)object).a = n10 = this.a;
            object = com.tencent.liteav.d.d(this.d);
            ((g)object).b = n10 = this.b;
            object = com.tencent.liteav.d.e(this.d);
            if (object != null) {
                object = com.tencent.liteav.d.e(this.d);
                c c10 = com.tencent.liteav.basic.a.c.a;
                object.a(c10);
                object = com.tencent.liteav.d.e(this.d);
                n10 = this.a;
                int n12 = this.b;
                object.a(n10, n12);
            }
        }
        if ((n11 = this.c) != 0 && (object = com.tencent.liteav.d.a(this.d)) != null) {
            object = com.tencent.liteav.d.d(this.d);
            ((g)object).c = n10 = this.c;
            object = com.tencent.liteav.d.a(this.d);
            n10 = this.c;
            ((b)object).b(n10);
        }
    }
}

