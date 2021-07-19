/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.util.f;
import java.util.concurrent.CountDownLatch;

public class f$1
implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ CountDownLatch b;
    public final /* synthetic */ f c;

    public f$1(f f10, Runnable runnable, CountDownLatch countDownLatch) {
        this.c = f10;
        this.a = runnable;
        this.b = countDownLatch;
    }

    public void run() {
        this.a.run();
        this.b.countDown();
    }
}

