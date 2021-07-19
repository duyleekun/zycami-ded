/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import e.a.w0.e.a.w;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class w$a
implements d,
b {
    public final d a;
    public b b;
    public final /* synthetic */ w c;

    public w$a(w w10, d d10) {
        this.c = w10;
        this.a = d10;
    }

    public void a() {
        Object object = this.c;
        object = ((w)object).f;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void dispose() {
        Object object = this.c;
        object = ((w)object).g;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        Object object = this.b;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (object == disposableHelper) {
            return;
        }
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        object = ((w)object).d;
        object.run();
        object = this.c;
        object = ((w)object).e;
        object.run();
        this.a.onComplete();
        this.a();
    }

    public void onError(Throwable object) {
        Object object2 = this.b;
        Object object3 = DisposableHelper.DISPOSED;
        if (object2 == object3) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        object2 = this.c;
        object2 = ((w)object2).c;
        object2.accept(object);
        object2 = this.c;
        object2 = ((w)object2).e;
        try {
            object2.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            int n10 = 2;
            Throwable[] throwableArray = new Throwable[n10];
            throwableArray[0] = object;
            int n11 = 1;
            throwableArray[n11] = throwable;
            object = object3 = new CompositeException(throwableArray);
        }
        this.a.onError((Throwable)object);
        this.a();
    }

    public void onSubscribe(b object) {
        Object object2;
        try {
            object2 = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object.dispose();
            object = DisposableHelper.DISPOSED;
            this.b = object;
            object = this.a;
            EmptyDisposable.error(throwable, (d)object);
            return;
        }
        object2 = ((w)object2).b;
        object2.accept(object);
        object2 = this.b;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

