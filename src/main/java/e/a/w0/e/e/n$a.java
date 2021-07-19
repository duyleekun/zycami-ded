/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.v0.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class n$a
implements g0,
e.a.s0.b {
    public final g0 a;
    public final b b;
    public final Object c;
    public e.a.s0.b d;
    public boolean e;

    public n$a(g0 g02, Object object, b b10) {
        this.a = g02;
        this.b = b10;
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
        g0 g02 = this.a;
        Object object = this.c;
        g02.onNext(object);
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
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        Object object2 = this.b;
        Object object3 = this.c;
        try {
            object2.accept(object3, object);
        }
        catch (Throwable throwable) {
            object2 = this.d;
            object2.dispose();
            this.onError(throwable);
        }
    }

    public void onSubscribe(e.a.s0.b object) {
        e.a.s0.b b10 = this.d;
        boolean bl2 = DisposableHelper.validate(b10, (e.a.s0.b)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

