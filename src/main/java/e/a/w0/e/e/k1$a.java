/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;

public final class k1$a
implements g0,
b {
    public final t a;
    public b b;
    public Object c;
    public boolean d;

    public k1$a(t t10) {
        this.a = t10;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = bl2 = true;
        Object object = this.c;
        t t10 = null;
        this.c = null;
        if (object == null) {
            object = this.a;
            object.onComplete();
        } else {
            t10 = this.a;
            t10.onSuccess(object);
        }
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
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        Object object2 = this.c;
        if (object2 != null) {
            this.d = true;
            this.b.dispose();
            object = this.a;
            object2 = new IllegalArgumentException("Sequence contains more than one element!");
            object.onError((Throwable)object2);
            return;
        }
        this.c = object;
    }

    public void onSubscribe(b object) {
        b b10 = this.b;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

