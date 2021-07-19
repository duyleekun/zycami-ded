/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import e.a.w0.c.l;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class j0$a
implements o,
l {
    public final d a;
    public e b;

    public j0$a(d d10) {
        this.a = d10;
    }

    public void cancel() {
        this.b.cancel();
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
    }

    public void onSubscribe(e e10) {
        Object object = this.b;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.b = e10;
            object = this.a;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public Object poll() {
        return null;
    }

    public void request(long l10) {
    }

    public int requestFusion(int n10) {
        return n10 & 2;
    }
}

