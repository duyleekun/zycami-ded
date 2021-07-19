/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty.b;

import com.tencent.liteav.beauty.b.w;

public class w$1
implements Runnable {
    public final /* synthetic */ w a;

    public w$1(w w10) {
        this.a = w10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = w.a(this.a);
        synchronized (object) {
            Object object2 = this.a;
            w.b((w)object2);
            object2 = this.a;
            object2 = w.a((w)object2);
            object2.notify();
            return;
        }
    }
}

