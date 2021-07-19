/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.o;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.util.ErrorMode;

public final class a
extends e.a.z0.a {
    public final e.a.z0.a a;
    public final o b;
    public final int c;
    public final ErrorMode d;

    public a(e.a.z0.a object, o o10, int n10, ErrorMode errorMode) {
        this.a = object;
        this.b = object = (o)e.a.w0.b.a.g(o10, "mapper");
        this.c = n10;
        object = (ErrorMode)((Object)e.a.w0.b.a.g((Object)errorMode, "errorMode"));
        this.d = object;
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
            int n11 = this.c;
            ErrorMode errorMode = this.d;
            dArray2[i10] = d10 = FlowableConcatMap.K8(d10, o10, n11, errorMode);
        }
        this.a.a(dArray2);
    }
}

