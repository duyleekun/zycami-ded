/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.indoor.q;

public class s
implements Runnable {
    public final /* synthetic */ q a;

    public s(q q10) {
        this.a = q10;
    }

    public void run() {
        Object object;
        Object object2 = q.h(this.a);
        if (object2 != null && (object2 = q.b(this.a)) != null) {
            object = q.e(this.a);
            object2 = new BDLocation((BDLocation)object);
            double d10 = q.h(this.a).getLatitude();
            ((BDLocation)object2).setLatitude(d10);
            d10 = q.h(this.a).getLongitude();
            ((BDLocation)object2).setLongitude(d10);
            object = q.b(this.a);
            object.a((BDLocation)object2);
        }
        object2 = q.g(this.a);
        object = q.f(this.a);
        long l10 = q.d(this.a);
        object2.postDelayed((Runnable)object, l10);
    }
}

