/*
 * Decompiled with CFR 0.151.
 */
package e.a.e1;

import e.a.a1.a;
import e.a.o;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class d
implements o,
e {
    public final i.g.d a;
    public e b;
    public boolean c;

    public d(i.g.d d10) {
        this.a = d10;
    }

    public void a() {
        Object object;
        i.g.d d10;
        String string2 = "Subscription not set!";
        NullPointerException nullPointerException = new NullPointerException(string2);
        int n10 = 1;
        int n11 = 2;
        try {
            d10 = this.a;
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
        object = EmptySubscription.INSTANCE;
        d10.onSubscribe((e)object);
        d10 = this.a;
        try {
            d10.onError(nullPointerException);
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
        i.g.d d10;
        int n10 = 1;
        this.c = n10;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        int n11 = 2;
        try {
            d10 = this.a;
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
        object = EmptySubscription.INSTANCE;
        d10.onSubscribe((e)object);
        d10 = this.a;
        try {
            d10.onError(nullPointerException);
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

    public void cancel() {
        e e10 = this.b;
        try {
            e10.cancel();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
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
            i.g.d d10;
            Throwable[] throwableArray = "Subscription not set!";
            object = new NullPointerException((String)throwableArray);
            int n12 = 3;
            try {
                d10 = this.a;
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
            object2 = EmptySubscription.INSTANCE;
            d10.onSubscribe((e)object2);
            d10 = this.a;
            Throwable[] throwableArray2 = new Throwable[n11];
            throwableArray2[0] = throwable;
            throwableArray2[n10] = object;
            object2 = new CompositeException(throwableArray2);
            try {
                d10.onError((Throwable)object2);
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
        e e10 = this.b;
        if (e10 == null) {
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
                object2.cancel();
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
            i.g.d object3 = this.a;
            object3.onNext(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            try {
                e throwable2 = this.b;
                throwable2.cancel();
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

    public void onSubscribe(e e10) {
        Object object = this.b;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.b = e10;
            object = this.a;
            try {
                object.onSubscribe(this);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                int n10 = 1;
                this.c = n10;
                try {
                    e10.cancel();
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void request(long l10) {
        try {
            e object = this.b;
            object.request(l10);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            try {
                e throwable2 = this.b;
                throwable2.cancel();
            }
            catch (Throwable throwable3) {
                e.a.t0.a.b(throwable3);
                Throwable[] throwableArray = new Throwable[]{throwable, throwable3};
                CompositeException compositeException = new CompositeException(throwableArray);
                e.a.a1.a.Y(compositeException);
                return;
            }
            e.a.a1.a.Y(throwable);
        }
    }
}

