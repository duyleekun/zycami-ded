/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.basic.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.util.f$1;
import java.util.concurrent.CountDownLatch;

public class f
extends Handler {
    public f(Looper looper) {
        super(looper);
    }

    public boolean a(Runnable runnable) {
        int n10 = 1;
        Object object = new CountDownLatch(n10);
        f$1 f$1 = new f$1(this, runnable, (CountDownLatch)object);
        boolean bl2 = this.post(f$1);
        if (bl2) {
            try {
                ((CountDownLatch)object).await();
            }
            catch (InterruptedException interruptedException) {
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
        }
        return bl2;
    }
}

