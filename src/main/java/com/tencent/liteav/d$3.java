/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.basic.structs.b;
import com.tencent.liteav.d;

public class d$3
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ d c;

    public d$3(d d10, int n10, int n11) {
        this.c = d10;
        this.a = n10;
        this.b = n11;
    }

    public void run() {
        Object object = this.c;
        int n10 = this.a;
        d.a((d)object, n10);
        object = this.c;
        n10 = this.b;
        d.b((d)object, n10);
        object = d.j(this.c);
        if (object != null && (object = d.k(this.c)) != null) {
            object = this.c;
            b b10 = d.j((d)object);
            boolean bl2 = true;
            d.a((d)object, b10, bl2);
        }
    }
}

