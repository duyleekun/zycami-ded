/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class h1$a
implements g0,
b {
    public final g0 a;
    public final c b;
    public b c;
    public Object d;
    public boolean e;

    public h1$a(g0 g02, c c10) {
        this.a = g02;
        this.b = c10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.a.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        g0 g02 = this.a;
        Object object2 = this.d;
        if (object2 == null) {
            this.d = object;
            g02.onNext(object);
            return;
        }
        try {
            c c10 = this.b;
            object = c10.apply(object2, object);
            object2 = "The value returned by the accumulator is null";
            this.d = object = e.a.w0.b.a.g(object, (String)object2);
            g02.onNext(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.dispose();
            this.onError(throwable);
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

