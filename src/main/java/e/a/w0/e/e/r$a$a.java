/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.w0.e.e.r$a;
import e.a.y0.d;
import java.util.concurrent.atomic.AtomicBoolean;

public final class r$a$a
extends d {
    public final r$a b;
    public final long c;
    public final Object d;
    public boolean e;
    public final AtomicBoolean f;

    public r$a$a(r$a r$a, long l10, Object object) {
        AtomicBoolean atomicBoolean;
        this.f = atomicBoolean = new AtomicBoolean();
        this.b = r$a;
        this.c = l10;
        this.d = object;
    }

    public void b() {
        Object object = this.f;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.b;
            long l10 = this.c;
            Object object2 = this.d;
            ((r$a)object).a(l10, object2);
        }
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.b();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.dispose();
        this.b();
    }
}

