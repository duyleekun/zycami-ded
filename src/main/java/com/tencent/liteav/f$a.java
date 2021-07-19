/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.f;
import java.lang.ref.WeakReference;

public class f$a
implements Runnable {
    private WeakReference a;

    public f$a(f f10) {
        WeakReference<f> weakReference;
        this.a = weakReference = new WeakReference<f>(f10);
    }

    public void run() {
        f f10 = (f)this.a.get();
        if (f10 == null) {
            return;
        }
        f10.h();
        f.e(f10);
    }
}

