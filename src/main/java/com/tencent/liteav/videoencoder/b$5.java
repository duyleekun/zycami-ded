/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.videoencoder.b;
import com.tencent.liteav.videoencoder.c;

public class b$5
implements Runnable {
    public final /* synthetic */ b a;

    public b$5(b b10) {
        this.a = b10;
    }

    public void run() {
        c c10 = b.d(this.a);
        if (c10 != null) {
            c10 = b.d(this.a);
            b b10 = this.a;
            int n10 = b.f(b10);
            c10.setBitrate(n10);
        }
    }
}

