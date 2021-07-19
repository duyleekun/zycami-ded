/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class f1$a
implements g0,
b {
    public final l0 a;
    public final c b;
    public Object c;
    public b d;

    public f1$a(l0 l02, c c10, Object object) {
        this.a = l02;
        this.c = object;
        this.b = c10;
    }

    public void dispose() {
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
    }

    public void onComplete() {
        Object object = this.c;
        if (object != null) {
            this.c = null;
            l0 l02 = this.a;
            l02.onSuccess(object);
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.c;
        if (object != null) {
            this.c = null;
            object = this.a;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        Object object2 = this.c;
        if (object2 != null) {
            c c10 = this.b;
            object = c10.apply(object2, object);
            object2 = "The reducer returned a null value";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                this.c = object;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.d;
                object2.dispose();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.d;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

