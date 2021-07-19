/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.o;
import e.a.w0.e.f.i;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class i$a
implements o,
e {
    public final d a;
    public final i b;
    public e c;
    public boolean d;

    public i$a(d d10, i i10) {
        this.a = d10;
        this.b = i10;
    }

    public void cancel() {
        Object object = this.b;
        object = ((i)object).i;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
        this.c.cancel();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        Object object;
        boolean bl2 = this.d;
        if (bl2) return;
        this.d = bl2 = true;
        try {
            object = this.b;
            object = ((i)object).e;
            object.run();
            object = this.a;
            object.onComplete();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            d d10 = this.a;
            d10.onError(throwable);
            return;
        }
        try {
            object = this.b;
            object = ((i)object).f;
            object.run();
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
            return;
        }
    }

    public void onError(Throwable object) {
        int n10 = (int)(this.d ? 1 : 0);
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        n10 = 1;
        this.d = n10;
        Object object2 = this.b;
        object2 = ((i)object2).d;
        try {
            object2.accept(object);
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
        d d10 = this.a;
        d10.onError((Throwable)object);
        object = this.b;
        object = ((i)object).f;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.d;
        if (bl2) return;
        try {
            object2 = this.b;
            object2 = ((i)object2).b;
            object2.accept(object);
            object2 = this.a;
            object2.onNext(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.onError(throwable);
            return;
        }
        try {
            object2 = this.b;
            object2 = ((i)object2).c;
            object2.accept(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.onError(throwable);
            return;
        }
    }

    public void onSubscribe(e object) {
        Object object2 = this.c;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            this.c = object;
            object2 = this.b;
            object2 = ((i)object2).g;
            try {
                object2.accept(object);
                object = this.a;
                object.onSubscribe(this);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object.cancel();
                object = this.a;
                EmptySubscription emptySubscription = EmptySubscription.INSTANCE;
                object.onSubscribe(emptySubscription);
                this.onError(throwable);
            }
        }
    }

    public void request(long l10) {
        Object object = this.b;
        object = ((i)object).h;
        try {
            object.a(l10);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
        this.c.request(l10);
    }
}

