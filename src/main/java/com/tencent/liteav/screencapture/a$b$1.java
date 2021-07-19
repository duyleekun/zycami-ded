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

public class a$b$1
implements Runnable {
    public final /* synthetic */ a$b a;

    public a$b$1(a$b b10) {
        this.a = b10;
    }

    public void run() {
        c c10 = c.a(com.tencent.liteav.screencapture.a.g(this.a.n));
        Surface surface = this.a.c;
        c10.a(surface);
    }
}

