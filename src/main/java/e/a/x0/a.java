/*
 * Decompiled with CFR 0.151.
 */
package e.a.x0;

import e.a.c1.b;
import e.a.e0;
import e.a.h0;
import e.a.v0.g;
import e.a.w0.e.e.d1;
import e.a.w0.e.e.i;
import e.a.w0.i.e;
import e.a.z;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservablePublishAlt;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import java.util.concurrent.TimeUnit;

public abstract class a
extends z {
    private a m8() {
        boolean bl2 = this instanceof d1;
        if (bl2) {
            e0 e02 = this;
            e02 = ((d1)((Object)this)).g();
            ObservablePublishAlt observablePublishAlt = new ObservablePublishAlt(e02);
            return e.a.a1.a.U(observablePublishAlt);
        }
        return this;
    }

    public z h8() {
        return this.i8(1);
    }

    public z i8(int n10) {
        g g10 = Functions.h();
        return this.j8(n10, g10);
    }

    public z j8(int n10, g g10) {
        if (n10 <= 0) {
            this.l8(g10);
            return e.a.a1.a.U(this);
        }
        i i10 = new i(this, n10, g10);
        return e.a.a1.a.R(i10);
    }

    public final e.a.s0.b k8() {
        e e10 = new e();
        this.l8(e10);
        return e10.a;
    }

    public abstract void l8(g var1);

    public z n8() {
        a a10 = this.m8();
        ObservableRefCount observableRefCount = new ObservableRefCount(a10);
        return e.a.a1.a.R(observableRefCount);
    }

    public final z o8(int n10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        h0 h02 = b.i();
        return this.q8(n10, 0L, timeUnit, h02);
    }

    public final z p8(int n10, long l10, TimeUnit timeUnit) {
        h0 h02 = b.a();
        return this.q8(n10, l10, timeUnit, h02);
    }

    public final z q8(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.h(n10, "subscriberCount");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        a a10 = this.m8();
        ObservableRefCount observableRefCount = new ObservableRefCount(a10, n10, l10, timeUnit, h02);
        return e.a.a1.a.R(observableRefCount);
    }

    public final z r8(long l10, TimeUnit timeUnit) {
        h0 h02 = b.a();
        return this.q8(1, l10, timeUnit, h02);
    }

    public final z s8(long l10, TimeUnit timeUnit, h0 h02) {
        return this.q8(1, l10, timeUnit, h02);
    }
}

