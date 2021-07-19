/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.util.h;

public class h$1
implements Runnable {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ h c;

    public h$1(h h10, Runnable runnable, boolean[] blArray) {
        this.c = h10;
        this.a = runnable;
        this.b = blArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        boolean bl2;
        this.a.run();
        Object object = this.b;
        h h10 = null;
        object[0] = bl2 = true;
        object = h.a(this.c);
        synchronized (object) {
            h10 = this.c;
            h10 = h.a(h10);
            h10.notifyAll();
            return;
        }
    }
}

