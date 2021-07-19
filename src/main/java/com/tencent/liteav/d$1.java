/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.d;
import com.tencent.liteav.videoencoder.b;

public class d$1
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;

    public d$1(d d10, int n10) {
        this.b = d10;
        this.a = n10;
    }

    public void run() {
        int n10;
        b b10 = d.a(this.b);
        if (b10 != null) {
            b10 = d.a(this.b);
            n10 = this.a;
            b10.a(n10);
        }
        if ((b10 = d.b(this.b)) != null) {
            b10 = d.b(this.b);
            n10 = this.a;
            b10.a(n10);
        }
    }
}

