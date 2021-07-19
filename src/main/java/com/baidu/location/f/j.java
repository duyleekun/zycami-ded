/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.f;

import com.baidu.location.b.ad;
import com.baidu.location.b.o;
import com.baidu.location.b.y;
import com.baidu.location.f.i;
import com.baidu.location.f.i$a;
import com.baidu.location.indoor.g;

public class j
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ i$a b;

    public j(i$a i$a, boolean bl2) {
        this.b = i$a;
        this.a = bl2;
    }

    public void run() {
        int n10;
        Object object = this.b.a;
        Object object2 = i.a((i)object);
        if (object2 == 0) {
            object = this.b.a;
            n10 = this.a;
            i.a((i)object, n10 != 0);
        }
        i.b(this.b.a);
        o.c().j();
        object = g.a();
        object2 = ((g)object).e();
        if (object2 != 0) {
            object = g.a().a;
            n10 = 41;
            object = object.obtainMessage(n10);
            object.sendToTarget();
        }
        long l10 = System.currentTimeMillis();
        long l11 = y.b();
        long l12 = (l10 -= l11) - (l11 = 5000L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 <= 0) {
            object = ad.a();
            ((ad)object).c();
        }
    }
}

