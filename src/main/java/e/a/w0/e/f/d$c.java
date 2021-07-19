/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.v0.c;
import e.a.v0.r;
import e.a.w0.e.f.d$a;
import e.a.w0.e.f.d$b;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

public final class d$c
extends d$b {
    public final e.a.w0.c.a e;

    public d$c(e.a.w0.c.a a10, r r10, c c10) {
        super(r10, c10);
        this.e = a10;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            e.a.w0.c.a a10 = this.e;
            a10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.e.onError(throwable);
    }

    public void onSubscribe(e object) {
        e e10 = this.c;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.c = object;
            object = this.e;
            object.onSubscribe(this);
        }
    }

    public boolean tryOnNext(Object object) {
        boolean n10 = this.d;
        boolean bl2 = false;
        if (!n10) {
            long l10 = 0L;
            while (true) {
                Object object2 = 1;
                r r10 = this.a;
                try {
                    Object object3;
                    e.a.w0.c.a a10;
                    boolean bl3;
                    boolean bl4 = r10.test(object);
                    if (bl4 && (bl3 = (a10 = this.e).tryOnNext(object))) {
                        object3 = object2;
                    }
                    return (boolean)object3;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    Object object4 = 2;
                    Object object5 = this.b;
                    long l11 = 1L;
                    l10 += l11;
                    Object object6 = l10;
                    object5 = object5.apply(object6, throwable);
                    object6 = "The errorHandler returned a null item";
                    object5 = e.a.w0.b.a.g(object5, (String)object6);
                    try {
                        object5 = (ParallelFailureHandling)object5;
                    }
                    catch (Throwable throwable2) {
                        e.a.t0.a.b(throwable2);
                        this.cancel();
                        Throwable[] throwableArray = new Throwable[object4];
                        throwableArray[0] = throwable;
                        throwableArray[object2] = throwable2;
                        CompositeException compositeException = new CompositeException(throwableArray);
                        this.onError(compositeException);
                    }
                    object6 = d$a.a;
                    Object object7 = ((Enum)object5).ordinal();
                    if ((object7 = (Object)object6[object7]) == object2) continue;
                    if (object7 != object4) {
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
                break;
            }
        }
        return false;
    }
}

