/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.videoencoder.a;

public class a$3
implements Runnable {
    public final /* synthetic */ a a;

    public a$3(a a10) {
        this.a = a10;
    }

    public void run() {
        a a10 = this.a;
        long l10 = System.currentTimeMillis();
        com.tencent.liteav.videoencoder.a.b(a10, l10);
        com.tencent.liteav.videoencoder.a.f(this.a);
        com.tencent.liteav.videoencoder.a.g(this.a);
        com.tencent.liteav.videoencoder.a.h(this.a);
    }
}

