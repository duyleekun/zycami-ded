/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.r;
import io.reactivex.internal.disposables.DisposableHelper;

public final class o1$a
implements g0,
b {
    public final g0 a;
    public final r b;
    public b c;
    public boolean d;

    public o1$a(g0 g02, r r10) {
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
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (bl2) {
            g0 g02 = this.a;
            g02.onNext(object);
            return;
        }
        try {
            Object object2 = this.b;
            bl2 = object2.test(object);
            if (bl2) return;
            this.d = bl2 = true;
            object2 = this.a;
            object2.onNext(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.dispose();
            this.a.onError(throwable);
            return;
        }
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

