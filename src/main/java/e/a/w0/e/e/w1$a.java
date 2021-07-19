/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;

public final class w1$a
implements g0,
b {
    public final l0 a;
    public Collection b;
    public b c;

    public w1$a(l0 l02, Collection collection) {
        this.a = l02;
        this.b = collection;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        Collection collection = this.b;
        this.b = null;
        this.a.onSuccess(collection);
    }

    public void onError(Throwable throwable) {
        this.b = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.b.add(object);
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

