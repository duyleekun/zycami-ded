/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

public final class l1$a
implements g0,
b {
    public final l0 a;
    public final Object b;
    public b c;
    public Object d;
    public boolean e;

    public l1$a(l0 l02, Object object) {
        this.a = l02;
        this.b = object;
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
        this.e = bl2 = true;
        Object object = this.d;
        Object object2 = null;
        this.d = null;
        if (object == null) {
            object = this.b;
        }
        if (object != null) {
            object2 = this.a;
            object2.onSuccess(object);
        } else {
            object = this.a;
            object2 = new NoSuchElementException();
            object.onError((Throwable)object2);
        }
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
        Object object2 = this.d;
        if (object2 != null) {
            this.e = true;
            this.c.dispose();
            object = this.a;
            object2 = new IllegalArgumentException("Sequence contains more than one element!");
            object.onError((Throwable)object2);
            return;
        }
        this.d = object;
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

