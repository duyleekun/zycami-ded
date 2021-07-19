/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.t;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class e1$a
implements g0,
b {
    public final t a;
    public final c b;
    public boolean c;
    public Object d;
    public b e;

    public e1$a(t t10, c c10) {
        this.a = t10;
        this.b = c10;
    }

    public void dispose() {
        this.e.dispose();
    }

    public boolean isDisposed() {
        return this.e.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = bl2 = true;
        Object object = this.d;
        t t10 = null;
        this.d = null;
        if (object != null) {
            t10 = this.a;
            t10.onSuccess(object);
        } else {
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.d = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.c;
        if (!bl2) {
            Object object2 = this.d;
            if (object2 == null) {
                this.d = object;
            } else {
                c c10 = this.b;
                object = c10.apply(object2, object);
                object2 = "The reducer returned a null value";
                object = e.a.w0.b.a.g(object, (String)object2);
                try {
                    this.d = object;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    object2 = this.e;
                    object2.dispose();
                    this.onError(throwable);
                }
            }
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.e;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.e = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

