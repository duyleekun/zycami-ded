/*
 * Decompiled with CFR 0.151.
 */
package e.a.u0;

import e.a.c1.b;
import e.a.h0;
import e.a.j;
import e.a.v0.g;
import e.a.w0.e.b.s0;
import e.a.w0.i.e;
import i.g.c;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import java.util.concurrent.TimeUnit;

public abstract class a
extends j {
    private a P8() {
        int n10 = this instanceof s0;
        if (n10 != 0) {
            Object object = this;
            object = (s0)((Object)this);
            c c10 = object.g();
            n10 = object.k();
            FlowablePublishAlt flowablePublishAlt = new FlowablePublishAlt(c10, n10);
            return e.a.a1.a.T(flowablePublishAlt);
        }
        return this;
    }

    public j K8() {
        return this.L8(1);
    }

    public j L8(int n10) {
        g g10 = Functions.h();
        return this.M8(n10, g10);
    }

    public j M8(int n10, g g10) {
        if (n10 <= 0) {
            this.O8(g10);
            return e.a.a1.a.T(this);
        }
        e.a.w0.e.b.g g11 = new e.a.w0.e.b.g(this, n10, g10);
        return e.a.a1.a.P(g11);
    }

    public final e.a.s0.b N8() {
        e e10 = new e();
        this.O8(e10);
        return e10.a;
    }

    public abstract void O8(g var1);

    public j Q8() {
        a a10 = this.P8();
        FlowableRefCount flowableRefCount = new FlowableRefCount(a10);
        return e.a.a1.a.P(flowableRefCount);
    }

    public final j R8(int n10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        h0 h02 = b.i();
        return this.T8(n10, 0L, timeUnit, h02);
    }

    public final j S8(int n10, long l10, TimeUnit timeUnit) {
        h0 h02 = b.a();
        return this.T8(n10, l10, timeUnit, h02);
    }

    public final j T8(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.h(n10, "subscriberCount");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        a a10 = this.P8();
        FlowableRefCount flowableRefCount = new FlowableRefCount(a10, n10, l10, timeUnit, h02);
        return e.a.a1.a.P(flowableRefCount);
    }

    public final j U8(long l10, TimeUnit timeUnit) {
        h0 h02 = b.a();
        return this.T8(1, l10, timeUnit, h02);
    }

    public final j V8(long l10, TimeUnit timeUnit, h0 h02) {
        return this.T8(1, l10, timeUnit, h02);
    }
}

