/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.j$1;
import com.tencent.liteav.j$a;

public class j$1$1
implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ j$1 b;

    public j$1$1(j$1 var1_1, long l10) {
        this.b = var1_1;
        this.a = l10;
    }

    public void run() {
        j$a j$a = this.b.d;
        long l10 = this.a;
        j$a.a(l10);
    }
}

