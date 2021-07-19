/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.v0.c;
import e.a.v0.g;
import e.a.w0.e.f.b$a;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

public final class b$b
implements e.a.w0.c.a,
e {
    public final e.a.w0.c.a a;
    public final g b;
    public final c c;
    public e d;
    public boolean e;

    public b$b(e.a.w0.c.a a10, g g10, c c10) {
        this.a = a10;
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
            g g10;
            try {
                g10 = this.b;
            }
            catch (Throwable throwable) {
                Object object2;
                e.a.t0.a.b(throwable);
                Object object3 = 1;
                Object object4 = 2;
                try {
                    object2 = this.c;
                    long l11 = 1L;
                    l10 += l11;
                }
                catch (Throwable throwable2) {
                    e.a.t0.a.b(throwable2);
                    this.cancel();
                    Throwable[] throwableArray = new Throwable[object4];
                    throwableArray[0] = throwable;
                    throwableArray[object3] = throwable2;
                    CompositeException compositeException = new CompositeException(throwableArray);
                    this.onError(compositeException);
                    return false;
                }
                Object object5 = l10;
                object2 = object2.apply(object5, throwable);
                object5 = "The errorHandler returned a null item";
                object2 = e.a.w0.b.a.g(object2, (String)object5);
                object2 = (ParallelFailureHandling)object2;
                object5 = b$a.a;
                Object object6 = ((Enum)object2).ordinal();
                if ((object6 = (Object)object5[object6]) == object3) continue;
                if (object6 != object4) {
                    Object object7 = 3;
                    if (object6 != object7) {
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
            return this.a.tryOnNext(object);
            break;
        }
    }
}

