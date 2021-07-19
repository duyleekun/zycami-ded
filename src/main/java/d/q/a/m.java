/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposingSubscriberImpl;
import d.q.a.z;
import e.a.g;
import e.a.z0.a;
import i.g.d;

public final class m
extends a
implements z {
    private final a a;
    private final g b;

    public m(a a10, g g10) {
        this.a = a10;
        this.b = g10;
    }

    public int G() {
        return this.a.G();
    }

    public void a(d[] dArray) {
        int n10;
        int n11 = this.U(dArray);
        if (n11 == 0) {
            return;
        }
        n11 = dArray.length;
        d[] dArray2 = new d[n11];
        for (int i10 = 0; i10 < (n10 = dArray.length); ++i10) {
            g g10 = this.b;
            d d10 = dArray[i10];
            AutoDisposingSubscriberImpl autoDisposingSubscriberImpl = new AutoDisposingSubscriberImpl(g10, d10);
            dArray2[i10] = autoDisposingSubscriberImpl;
        }
        this.a.a(dArray2);
    }
}

