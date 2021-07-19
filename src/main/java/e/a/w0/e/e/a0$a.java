/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.a;
import e.a.v0.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

public final class a0$a
implements g0,
b {
    public final g0 a;
    public final g b;
    public final g c;
    public final a d;
    public final a e;
    public b f;
    public boolean g;

    public a0$a(g0 g02, g g10, g g11, a a10, a a11) {
        this.a = g02;
        this.b = g10;
        this.c = g11;
        this.d = a10;
        this.e = a11;
    }

    public void dispose() {
        this.f.dispose();
    }

    public boolean isDisposed() {
        return this.f.isDisposed();
    }

    public void onComplete() {
        Object object;
        boolean bl2 = this.g;
        if (bl2) {
            return;
        }
        try {
            object = this.d;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.onError(throwable);
            return;
        }
        object.run();
        this.g = bl2 = true;
        object = this.a;
        object.onComplete();
        object = this.e;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void onError(Throwable object) {
        int n10 = (int)(this.g ? 1 : 0);
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        n10 = 1;
        this.g = n10;
        g g10 = this.c;
        try {
            g10.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            int n11 = 2;
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = object;
            throwableArray[n10] = throwable;
            CompositeException compositeException = new CompositeException(throwableArray);
            object = compositeException;
        }
        g0 g02 = this.a;
        g02.onError((Throwable)object);
        object = this.e;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        g g10;
        boolean bl2 = this.g;
        if (bl2) {
            return;
        }
        try {
            g10 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.f.dispose();
            this.onError(throwable);
            return;
        }
        g10.accept(object);
        this.a.onNext(object);
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

