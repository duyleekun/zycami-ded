/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.c;
import com.tencent.liteav.g;

public class c$1
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ c b;

    public c$1(c c10, boolean bl2) {
        this.b = c10;
        this.a = bl2;
    }

    public void run() {
        boolean bl2;
        g g10 = c.a(this.b);
        g10.S = bl2 = this.a;
    }
}

