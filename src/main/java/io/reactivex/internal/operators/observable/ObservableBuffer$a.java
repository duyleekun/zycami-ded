/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBuffer$a
implements g0,
b {
    public final g0 a;
    public final int b;
    public final Callable c;
    public Collection d;
    public int e;
    public b f;

    public ObservableBuffer$a(g0 g02, int n10, Callable callable) {
        this.a = g02;
        this.b = n10;
        this.c = callable;
    }

    public boolean a() {
        Object object;
        Object object2;
        try {
            object2 = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.d = null;
            object = this.f;
            if (object == null) {
                object = this.a;
                EmptyDisposable.error(throwable, (g0)object);
            } else {
                object.dispose();
                object = this.a;
                object.onError(throwable);
            }
            return false;
        }
        object2 = object2.call();
        object = "Empty buffer supplied";
        object2 = e.a.w0.b.a.g(object2, (String)object);
        this.d = object2 = (Collection)object2;
        return true;
    }

    public void dispose() {
        this.f.dispose();
    }

    public boolean isDisposed() {
        return this.f.isDisposed();
    }

    public void onComplete() {
        Object object = this.d;
        if (object != null) {
            g0 g02 = null;
            this.d = null;
            boolean bl2 = object.isEmpty();
            if (!bl2) {
                g02 = this.a;
                g02.onNext(object);
            }
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.d = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Collection collection = this.d;
        if (collection != null) {
            int n10;
            collection.add(object);
            this.e = n10 = this.e + 1;
            int n11 = this.b;
            if (n10 >= n11) {
                this.a.onNext(collection);
                n10 = 0;
                object = null;
                this.e = 0;
                this.a();
            }
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.f;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.f = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

