/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.tencent.liteav.screencapture;

import android.view.Surface;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a$b;
import com.tencent.liteav.screencapture.c;
import com.tencent.liteav.screencapture.c$b;

public class a$b$3
implements Runnable {
    public final /* synthetic */ a$b a;

    public a$b$3(a$b a$b) {
        this.a = a$b;
    }

    public void run() {
        c c10 = c.a(com.tencent.liteav.screencapture.a.g(this.a.n));
        Object object = this.a;
        Surface surface = object.c;
        int n10 = object.e;
        int n11 = object.f;
        object = com.tencent.liteav.screencapture.a.h(object.n);
        c10.a(surface, n10, n11, (c$b)object);
    }
}

