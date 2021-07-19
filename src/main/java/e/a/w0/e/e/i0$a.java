/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class i0$a
implements g0,
b {
    public final g0 a;
    public final o b;
    public b c;

    public i0$a(g0 g02, o o10) {
        this.a = g02;
        this.b = o10;
    }

    public void dispose() {
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        b b10 = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (b10 == disposableHelper) {
            return;
        }
        this.c = disposableHelper;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        b b10 = this.c;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (b10 == disposableHelper) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = disposableHelper;
        this.a.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object iterator2) {
        Object object = this.c;
        Object object2 = DisposableHelper.DISPOSED;
        if (object == object2) {
            return;
        }
        try {
            object = this.b;
            iterator2 = object.apply(iterator2);
            iterator2 = (Iterable)((Object)iterator2);
            iterator2 = iterator2.iterator();
            object = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.dispose();
            this.onError(throwable);
            return;
        }
        while (true) {
            try {
                boolean bl2 = iterator2.hasNext();
                if (!bl2) return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.c.dispose();
                this.onError(throwable);
                return;
            }
            try {
                object2 = iterator2.next();
                String string2 = "The iterator returned a null value";
                object2 = e.a.w0.b.a.g(object2, string2);
                object.onNext(object2);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object = this.c;
                object.dispose();
                this.onError(throwable);
                return;
            }
        }
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

