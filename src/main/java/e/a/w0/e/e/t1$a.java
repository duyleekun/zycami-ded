/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.v0.r;
import io.reactivex.internal.disposables.DisposableHelper;

public final class t1$a
implements g0,
b {
    public final g0 a;
    public final r b;
    public b c;
    public boolean d;

    public t1$a(g0 g02, r r10) {
        this.a = g02;
        this.b = r10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        r r10;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        try {
            r10 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.dispose();
            this.onError(throwable);
            return;
        }
        bl2 = r10.test(object);
        if (!bl2) {
            this.d = true;
            this.c.dispose();
            this.a.onComplete();
            return;
        }
        this.a.onNext(object);
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

