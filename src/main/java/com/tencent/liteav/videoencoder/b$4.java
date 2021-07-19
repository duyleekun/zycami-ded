/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.videoencoder.b;
import com.tencent.liteav.videoencoder.c;
import com.tencent.liteav.videoencoder.d;

public class b$4
implements Runnable {
    public final /* synthetic */ b a;

    public b$4(b b10) {
        this.a = b10;
    }

    public void run() {
        c c10 = b.d(this.a);
        if (c10 != null) {
            c10 = b.d(this.a);
            d d10 = b.e(this.a);
            c10.setListener(d10);
        }
    }
}

