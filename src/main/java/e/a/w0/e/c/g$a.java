/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import e.a.v0.g;
import io.reactivex.internal.disposables.DisposableHelper;

public final class g$a
implements t,
b {
    public final t a;
    public final g b;
    public b c;

    public g$a(t t10, g g10) {
        this.a = t10;
        this.b = g10;
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

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        Object object2 = this.a;
        object2.onSuccess(object);
        object2 = this.b;
        try {
            object2.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }
}

