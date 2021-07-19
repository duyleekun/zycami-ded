/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.q;
import com.baidu.location.indoor.q$b;

public class r
implements Runnable {
    public final /* synthetic */ q a;

    public r(q q10) {
        this.a = q10;
    }

    public void run() {
        Object object = this.a;
        Object object2 = q.a((q)object);
        if ((object = q.a((q)object, (q$b)object2)) != null && (object2 = q.b(this.a)) != null) {
            object2 = this.a;
            q$b q$b = q.a((q)object2).b((q$b)object);
            q.b((q)object2, q$b);
            long l10 = System.currentTimeMillis();
            long l11 = 4521832792735477133L;
            double d10 = 2.0E-6;
            Object object3 = ((q$b)object).b(d10);
            if (object3 == 0) {
                l11 = q.c(this.a);
                object = this.a;
                long l12 = q.d((q)object);
                long l13 = (l11 = l10 - l11) - l12;
                object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object3 > 0) {
                    Object object4 = q.e(this.a);
                    object = new BDLocation((BDLocation)object4);
                    d10 = q.a((q)this.a).a;
                    ((BDLocation)object).setLatitude(d10);
                    d10 = q.a((q)this.a).b;
                    ((BDLocation)object).setLongitude(d10);
                    object4 = q.b(this.a);
                    object4.a((BDLocation)object);
                    object = this.a;
                    q.a((q)object, l10);
                }
            }
        }
        object = q.g(this.a);
        object2 = q.f(this.a);
        object.postDelayed((Runnable)object2, 450L);
    }
}

