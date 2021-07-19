/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.tencent.liteav.beauty.a.a;

import android.view.Surface;
import com.tencent.liteav.beauty.a.a.a;
import com.tencent.liteav.beauty.a.a.b;

public class c
extends b {
    private Surface b;
    private boolean c;

    public c(a a10, int n10, int n11, boolean bl2) {
        super(a10);
        this.a(n10, n11);
        this.c = bl2;
    }

    public void c() {
        this.a();
        Surface surface = this.b;
        if (surface != null) {
            boolean bl2 = this.c;
            if (bl2) {
                surface.release();
            }
            surface = null;
            this.b = null;
        }
    }
}

