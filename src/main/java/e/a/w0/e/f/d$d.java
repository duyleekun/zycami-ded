/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.v0.c;
import e.a.v0.r;
import e.a.w0.e.f.d$a;
import e.a.w0.e.f.d$b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

public final class d$d
extends d$b {
    public final d e;

    public d$d(d d10, r r10, c c10) {
        super(r10, c10);
        this.e = d10;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            d d10 = this.e;
            d10.onComplete();
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
        int n10 = (int)(this.d ? 1 : 0);
        if (n10 == 0) {
            long l10 = 0L;
            while (true) {
                n10 = 1;
                r r10 = this.a;
                try {
                    boolean bl2 = r10.test(object);
                    if (bl2) {
                        this.e.onNext(object);
                        return n10 != 0;
                    }
                    return false;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    Object object2 = 2;
                    Object object3 = this.b;
                    long l11 = 1L;
                    l10 += l11;
                    Object object4 = l10;
                    object3 = object3.apply(object4, throwable);
                    object4 = "The errorHandler returned a null item";
                    object3 = e.a.w0.b.a.g(object3, (String)object4);
                    try {
                        object3 = (ParallelFailureHandling)object3;
                    }
                    catch (Throwable throwable2) {
                        e.a.t0.a.b(throwable2);
                        this.cancel();
                        Throwable[] throwableArray = new Throwable[object2];
                        throwableArray[0] = throwable;
                        throwableArray[n10] = throwable2;
                        CompositeException compositeException = new CompositeException(throwableArray);
                        this.onError(compositeException);
                    }
                    object4 = d$a.a;
                    Object object5 = ((Enum)object3).ordinal();
                    if ((object5 = (Object)object4[object5]) == n10) continue;
                    if (object5 != object2) {
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
                break;
            }
        }
        return false;
    }
}

