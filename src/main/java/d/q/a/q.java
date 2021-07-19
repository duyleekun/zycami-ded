/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposableHelper;
import d.q.a.i;
import d.q.a.i0.a;
import d.q.a.q$a;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicReference;

public final class q
implements a {
    public final AtomicReference a;
    public final AtomicReference b;
    private final g c;
    private final d d;

    public q(g g10, d d10) {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
        this.b = atomicReference = new AtomicReference();
        this.c = g10;
        this.d = d10;
    }

    public d delegateObserver() {
        return this.d;
    }

    public void dispose() {
        AutoDisposableHelper.dispose(this.b);
        AutoDisposableHelper.dispose(this.a);
    }

    public boolean isDisposed() {
        boolean bl2;
        AutoDisposableHelper autoDisposableHelper;
        Object v10 = this.a.get();
        if (v10 == (autoDisposableHelper = AutoDisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object = this.a;
            AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
            ((AtomicReference)object).lazySet(autoDisposableHelper);
            AutoDisposableHelper.dispose(this.b);
            object = this.d;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object = this.a;
            AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
            ((AtomicReference)object).lazySet(autoDisposableHelper);
            AutoDisposableHelper.dispose(this.b);
            object = this.d;
            object.onError(throwable);
        }
    }

    public void onSubscribe(b b10) {
        Object object = this.b;
        Object object2 = new q$a(this);
        Class<q> clazz = q.class;
        boolean bl2 = i.c((AtomicReference)object, (b)object2, clazz);
        if (bl2) {
            this.d.onSubscribe(this);
            object = this.c;
            object.f((d)object2);
            object2 = this.a;
            i.c((AtomicReference)object2, b10, clazz);
        }
    }
}

