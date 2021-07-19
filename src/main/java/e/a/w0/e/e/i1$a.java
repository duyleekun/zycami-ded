/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class i1$a
implements g0,
b {
    public final g0 a;
    public final c b;
    public Object c;
    public b d;
    public boolean e;

    public i1$a(g0 g02, c c10, Object object) {
        this.a = g02;
        this.b = c10;
        this.c = object;
    }

    public void dispose() {
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
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

    public void onNext(Object object) {
        c c10;
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        Object object2 = this.c;
        try {
            c10 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.d.dispose();
            this.onError(throwable);
            return;
        }
        object = c10.apply(object2, object);
        object2 = "The accumulator returned a null value";
        this.c = object = e.a.w0.b.a.g(object, (String)object2);
        this.a.onNext(object);
    }

    public void onSubscribe(b object) {
        Object object2 = this.d;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.d = object;
            this.a.onSubscribe(this);
            object = this.a;
            object2 = this.c;
            object.onNext(object2);
        }
    }
}

