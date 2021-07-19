/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.v0.c;
import e.a.v0.o;
import e.a.w0.e.f.h$a;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

public final class h$b
implements e.a.w0.c.a,
e {
    public final e.a.w0.c.a a;
    public final o b;
    public final c c;
    public e d;
    public boolean e;

    public h$b(e.a.w0.c.a a10, o o10, c c10) {
        this.a = a10;
        this.b = o10;
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
        if (!bl2 && !(bl2 = this.e)) {
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
        boolean bl2 = this.e;
        if (bl2) {
            return false;
        }
        long l10 = 0L;
        while (true) {
            Object object2;
            try {
                object2 = this.b;
            }
            catch (Throwable throwable) {
                Object object3;
                e.a.t0.a.b(throwable);
                Object object4 = 1;
                Object object5 = 2;
                try {
                    object3 = this.c;
                    long l11 = 1L;
                    l10 += l11;
                }
                catch (Throwable throwable2) {
                    e.a.t0.a.b(throwable2);
                    this.cancel();
                    Throwable[] throwableArray = new Throwable[object5];
                    throwableArray[0] = throwable;
                    throwableArray[object4] = throwable2;
                    CompositeException compositeException = new CompositeException(throwableArray);
                    this.onError(compositeException);
                    return false;
                }
                Object object6 = l10;
                object3 = object3.apply(object6, throwable);
                object6 = "The errorHandler returned a null item";
                object3 = e.a.w0.b.a.g(object3, (String)object6);
                object3 = (ParallelFailureHandling)object3;
                object6 = h$a.a;
                Object object7 = ((Enum)object3).ordinal();
                if ((object7 = (Object)object6[object7]) == object4) continue;
                if (object7 != object5) {
                    Object object8 = 3;
                    if (object7 != object8) {
                        this.cancel();
                        this.onError(throwable);
                        return false;
                    }
                    this.cancel();
                    this.onComplete();
                }
                return false;
            }
            object2 = object2.apply(object);
            String string2 = "The mapper returned a null value";
            object = e.a.w0.b.a.g(object2, string2);
            return this.a.tryOnNext(object);
            break;
        }
    }
}

