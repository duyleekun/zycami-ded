/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposableHelper;
import d.q.a.i;
import d.q.a.i0.b;
import d.q.a.r$a;
import e.a.d;
import e.a.g;
import e.a.t;
import java.util.concurrent.atomic.AtomicReference;

public final class r
implements b {
    public final AtomicReference a;
    public final AtomicReference b;
    private final g c;
    private final t d;

    public r(g g10, t t10) {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
        this.b = atomicReference = new AtomicReference();
        this.c = g10;
        this.d = t10;
    }

    public t delegateObserver() {
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

    public void onSubscribe(e.a.s0.b b10) {
        Object object = this.b;
        Object object2 = new r$a(this);
        Class<r> clazz = r.class;
        boolean bl2 = i.c((AtomicReference)object, (e.a.s0.b)object2, clazz);
        if (bl2) {
            this.d.onSubscribe(this);
            object = this.c;
            object.f((d)object2);
            object2 = this.a;
            i.c((AtomicReference)object2, b10, clazz);
        }
    }

    public void onSuccess(Object object) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            Object object2 = this.a;
            AutoDisposableHelper autoDisposableHelper = AutoDisposableHelper.DISPOSED;
            ((AtomicReference)object2).lazySet(autoDisposableHelper);
            AutoDisposableHelper.dispose(this.b);
            object2 = this.d;
            object2.onSuccess(object);
        }
    }
}

