/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.o;
import com.baidu.location.b.p;

public class o$b
implements Runnable {
    public final /* synthetic */ o a;

    private o$b(o o10) {
        this.a = o10;
    }

    public /* synthetic */ o$b(o o10, p p10) {
        this(o10);
    }

    public void run() {
        boolean bl2;
        o o10 = this.a;
        boolean bl3 = o.a(o10);
        if (bl3) {
            o10 = this.a;
            o.a(o10, false);
        }
        if ((bl3 = o.b(o10 = this.a)) == (bl2 = true)) {
            o.b(this.a, false);
            o10 = this.a;
            o.b(o10, null);
        }
    }
}

