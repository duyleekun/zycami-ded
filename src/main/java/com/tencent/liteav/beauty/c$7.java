/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

import com.tencent.liteav.beauty.c;

public class c$7
implements Runnable {
    public final /* synthetic */ float[] a;
    public final /* synthetic */ c b;

    public c$7(c c10, float[] fArray) {
        this.b = c10;
        this.a = fArray;
    }

    public void run() {
        c c10 = this.b;
        float[] fArray = this.a;
        c.a(c10, fArray);
    }
}

