/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import d.n.a.q0.w.j;
import e.a.b0;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.f;
import java.util.concurrent.atomic.AtomicBoolean;

public class x
implements g0,
f {
    private final AtomicBoolean a;
    private final b0 b;
    private final j c;

    public x(b0 b02, j j10) {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean(false);
        this.b = b02;
        this.c = j10;
        b02.setCancellable(this);
    }

    public boolean a() {
        synchronized (this) {
            AtomicBoolean atomicBoolean = this.a;
            boolean bl2 = atomicBoolean.get();
            return bl2;
        }
    }

    public void cancel() {
        synchronized (this) {
            AtomicBoolean atomicBoolean = this.a;
            boolean bl2 = true;
            atomicBoolean.set(bl2);
            return;
        }
    }

    public void onComplete() {
        this.c.release();
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.c.release();
        this.b.tryOnError(throwable);
    }

    public void onNext(Object object) {
        this.b.onNext(object);
    }

    public void onSubscribe(b b10) {
    }
}

