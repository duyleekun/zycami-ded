/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.c;

public class c$1
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ c b;

    public c$1(c c10, float f10) {
        this.b = c10;
        this.a = f10;
    }

    public void run() {
        m m10 = c.a(this.b);
        if (m10 != null) {
            m10 = c.a(this.b);
            float f10 = this.a;
            m10.a(f10);
        }
    }
}

