/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class w$a
implements g0,
b {
    public g0 a;
    public b b;

    public w$a(g0 g02) {
        this.a = g02;
    }

    public void dispose() {
        b b10 = this.b;
        g0 g02 = EmptyComponent.INSTANCE;
        this.b = g02;
        g02 = EmptyComponent.asObserver();
        this.a = g02;
        b10.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        g0 g02 = this.a;
        g0 g03 = EmptyComponent.INSTANCE;
        this.b = g03;
        g03 = EmptyComponent.asObserver();
        this.a = g03;
        g02.onComplete();
    }

    public void onError(Throwable throwable) {
        g0 g02 = this.a;
        g0 g03 = EmptyComponent.INSTANCE;
        this.b = g03;
        g03 = EmptyComponent.asObserver();
        this.a = g03;
        g02.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
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

