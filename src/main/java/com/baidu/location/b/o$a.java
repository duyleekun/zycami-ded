/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.b.o;
import com.baidu.location.b.p;
import com.baidu.location.f.f;

public class o$a
implements Runnable {
    public final /* synthetic */ o a;

    private o$a(o o10) {
        this.a = o10;
    }

    public /* synthetic */ o$a(o o10, p p10) {
        this(o10);
    }

    public void run() {
        boolean bl2;
        Object object = this.a;
        boolean bl3 = o.c((o)object);
        if (bl3 == (bl2 = true)) {
            object = this.a;
            bl2 = false;
            o.c((o)object, false);
            object = this.a;
            bl3 = o.d((o)object);
            if (!bl3 && !(bl3 = ((f)(object = f.a())).k())) {
                object = this.a;
                ((o)object).a(false, false);
            }
        }
    }
}

