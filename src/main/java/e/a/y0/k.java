/*
 * Decompiled with CFR 0.151.
 */
package e.a.y0;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class k
implements g0,
b {
    public final g0 a;
    public b b;
    public boolean c;

    public k(g0 g02) {
        this.a = g02;
    }

    public void a() {
        Object object;
        g0 g02;
        String string2 = "Subscription not set!";
        NullPointerException nullPointerException = new NullPointerException(string2);
        int n10 = 1;
        int n11 = 2;
        try {
            g02 = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = nullPointerException;
            throwableArray[n10] = throwable;
            object = new CompositeException(throwableArray);
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        object = EmptyDisposable.INSTANCE;
        g02.onSubscribe((b)object);
        g02 = this.a;
        try {
            g02.onError(nullPointerException);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = nullPointerException;
            throwableArray[n10] = throwable;
            object = new CompositeException(throwableArray);
            e.a.a1.a.Y((Throwable)object);
        }
    }

    public void b() {
        Object object;
        g0 g02;
        int n10 = 1;
        this.c = n10;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        int n11 = 2;
        try {
            g02 = this.a;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = nullPointerException;
            throwableArray[n10] = throwable;
            object = new CompositeException(throwableArray);
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        object = EmptyDisposable.INSTANCE;
        g02.onSubscribe((b)object);
        g02 = this.a;
        try {
            g02.onError(nullPointerException);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = nullPointerException;
            throwableArray[n10] = throwable;
            object = new CompositeException(throwableArray);
            e.a.a1.a.Y((Throwable)object);
        }
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = bl2 = true;
        Object object = this.b;
        if (object == null) {
            this.a();
            return;
        }
        object = this.a;
        try {
            object.onComplete();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void onError(Throwable throwable) {
        int n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            e.a.a1.a.Y(throwable);
            return;
        }
        n10 = 1;
        this.c = n10;
        Object object = this.b;
        int n11 = 2;
        if (object == null) {
            Object object2;
            g0 g02;
            Throwable[] throwableArray = "Subscription not set!";
            object = new NullPointerException((String)throwableArray);
            int n12 = 3;
            try {
                g02 = this.a;
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                throwableArray = new Throwable[n12];
                throwableArray[0] = throwable;
                throwableArray[n10] = object;
                throwableArray[n11] = throwable2;
                object2 = new CompositeException(throwableArray);
                e.a.a1.a.Y((Throwable)object2);
                return;
            }
            object2 = EmptyDisposable.INSTANCE;
            g02.onSubscribe((b)object2);
            g02 = this.a;
            Throwable[] throwableArray2 = new Throwable[n11];
            throwableArray2[0] = throwable;
            throwableArray2[n10] = object;
            object2 = new CompositeException(throwableArray2);
            try {
                g02.onError((Throwable)object2);
            }
            catch (Throwable throwable3) {
                e.a.t0.a.b(throwable3);
                throwableArray = new Throwable[n12];
                throwableArray[0] = throwable;
                throwableArray[n10] = object;
                throwableArray[n11] = throwable3;
                object2 = new CompositeException(throwableArray);
                e.a.a1.a.Y((Throwable)object2);
            }
            return;
        }
        if (throwable == null) {
            object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
            throwable = new NullPointerException((String)object);
        }
        object = this.a;
        try {
            object.onError(throwable);
        }
        catch (Throwable throwable4) {
            e.a.t0.a.b(throwable4);
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable4;
            CompositeException compositeException = new CompositeException(throwableArray);
            e.a.a1.a.Y(compositeException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        int n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        b b10 = this.b;
        if (b10 == null) {
            this.b();
            return;
        }
        n10 = 1;
        int n11 = 2;
        if (object == null) {
            Object object2 = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
            object = new NullPointerException((String)object2);
            try {
                object2 = this.b;
                object2.dispose();
                this.onError((Throwable)object);
                return;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                Throwable[] throwableArray = new Throwable[n11];
                throwableArray[0] = object;
                throwableArray[n10] = throwable;
                CompositeException compositeException = new CompositeException(throwableArray);
                this.onError(compositeException);
                return;
            }
        }
        try {
            g0 object3 = this.a;
            object3.onNext(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            try {
                b throwable2 = this.b;
                throwable2.dispose();
                this.onError(throwable);
                return;
            }
            catch (Throwable throwable3) {
                e.a.t0.a.b(throwable3);
                Throwable[] throwableArray = new Throwable[n11];
                throwableArray[0] = throwable;
                throwableArray[n10] = throwable3;
                CompositeException compositeException = new CompositeException(throwableArray);
                this.onError(compositeException);
                return;
            }
        }
    }

    public void onSubscribe(b b10) {
        Object object = this.b;
        boolean bl2 = DisposableHelper.validate((b)object, b10);
        if (bl2) {
            this.b = b10;
            object = this.a;
            try {
                object.onSubscribe(this);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                int n10 = 1;
                this.c = n10;
                try {
                    b10.dispose();
                }
                catch (Throwable throwable2) {
                    e.a.t0.a.b(throwable2);
                    int n11 = 2;
                    Throwable[] throwableArray = new Throwable[n11];
                    throwableArray[0] = throwable;
                    throwableArray[n10] = throwable2;
                    CompositeException compositeException = new CompositeException(throwableArray);
                    e.a.a1.a.Y(compositeException);
                }
                e.a.a1.a.Y(throwable);
            }
        }
    }
}

