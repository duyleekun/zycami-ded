/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.o;
import e.a.z0.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;

public final class e
extends a {
    public final a a;
    public final o b;
    public final boolean c;
    public final int d;
    public final int e;

    public e(a a10, o o10, boolean bl2, int n10, int n11) {
        this.a = a10;
        this.b = o10;
        this.c = bl2;
        this.d = n10;
        this.e = n11;
    }

    public int G() {
        return this.a.G();
    }

    public void a(d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        d[] dArray2 = new d[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            d d10 = dArray[i10];
            o o10 = this.b;
            boolean bl2 = this.c;
            int n11 = this.d;
            int n12 = this.e;
            dArray2[i10] = d10 = FlowableFlatMap.K8(d10, o10, bl2, n11, n12);
        }
        this.a.a(dArray2);
    }
}

