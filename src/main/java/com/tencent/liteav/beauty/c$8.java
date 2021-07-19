/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.c;

public class c$8
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ c d;

    public c$8(c c10, float f10, float f11, float f12) {
        this.d = c10;
        this.a = f10;
        this.b = f11;
        this.c = f12;
    }

    public void run() {
        m m10 = com.tencent.liteav.beauty.c.a(this.d);
        float f10 = this.a;
        float f11 = this.b;
        float f12 = this.c;
        m10.a(f10, f11, f12);
    }
}

