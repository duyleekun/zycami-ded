/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Collection;

public final class v1$a
implements g0,
b {
    public final g0 a;
    public b b;
    public Collection c;

    public v1$a(g0 g02, Collection collection) {
        this.a = g02;
        this.c = collection;
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        Collection collection = this.c;
        this.c = null;
        this.a.onNext(collection);
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.c = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.c.add(object);
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

