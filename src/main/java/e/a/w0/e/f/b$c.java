/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.v0.c;
import e.a.v0.g;
import e.a.w0.e.f.b$a;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

public final class b$c
implements e.a.w0.c.a,
e {
    public final d a;
    public final g b;
    public final c c;
    public e d;
    public boolean e;

    public b$c(d d10, g g10, c c10) {
        this.a = d10;
        this.b = g10;
        this.c = c10;
    }

    public void cancel() {
        this.d.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.tryOnNext(object);
        if (!bl2) {
            object = this.d;
            long l10 = 1L;
            object.request(l10);
        }
    }

    public void onSubscribe(e object) {
        e e10 = this.d;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.d.request(l10);
    }

    public boolean tryOnNext(Object object) {
        int n10 = (int)(this.e ? 1 : 0);
        if (n10 != 0) {
            return false;
        }
        long l10 = 0L;
        while (true) {
            g g10;
            n10 = 1;
            try {
                g10 = this.b;
            }
            catch (Throwable throwable) {
                Object object2;
                e.a.t0.a.b(throwable);
                Object object3 = 2;
                try {
                    object2 = this.c;
                    long l11 = 1L;
                    l10 += l11;
                }
                catch (Throwable throwable2) {
                    e.a.t0.a.b(throwable2);
                    this.cancel();
                    Throwable[] throwableArray = new Throwable[object3];
                    throwableArray[0] = throwable;
                    throwableArray[n10] = throwable2;
                    CompositeException compositeException = new CompositeException(throwableArray);
                    this.onError(compositeException);
                    return false;
                }
                Object object4 = l10;
                object2 = object2.apply(object4, throwable);
                object4 = "The errorHandler returned a null item";
                object2 = e.a.w0.b.a.g(object2, (String)object4);
                object2 = (ParallelFailureHandling)object2;
                object4 = b$a.a;
                Object object5 = ((Enum)object2).ordinal();
                if ((object5 = (Object)object4[object5]) == n10) continue;
                if (object5 != object3) {
                    Object object6 = 3;
                    if (object5 != object6) {
                        this.cancel();
                        this.onError(throwable);
                        return false;
                    }
                    this.cancel();
                    this.onComplete();
                }
                return false;
            }
            g10.accept(object);
            this.a.onNext(object);
            return n10 != 0;
            break;
        }
    }
}

