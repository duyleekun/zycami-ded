/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.a0;
import h.o0;
import java.util.Objects;
import java.util.concurrent.Executor;
import k.d;
import k.f;
import k.i$b$a;
import k.r;

public final class i$b
implements d {
    public final Executor a;
    public final d b;

    public i$b(Executor executor, d d10) {
        this.a = executor;
        this.b = d10;
    }

    public a0 C() {
        return this.b.C();
    }

    public boolean D() {
        return this.b.D();
    }

    public void cancel() {
        this.b.cancel();
    }

    public d clone() {
        Executor executor = this.a;
        d d10 = this.b.clone();
        i$b i$b = new i$b(executor, d10);
        return i$b;
    }

    public r execute() {
        return this.b.execute();
    }

    public void h(f f10) {
        Objects.requireNonNull(f10, "callback == null");
        d d10 = this.b;
        i$b$a i$b$a = new i$b$a(this, f10);
        d10.h(i$b$a);
    }

    public boolean isCanceled() {
        return this.b.isCanceled();
    }

    public o0 timeout() {
        return this.b.timeout();
    }
}

