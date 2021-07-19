/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import e.a.w0.c.l;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public abstract class a
implements e.a.w0.c.a,
l {
    public final e.a.w0.c.a a;
    public e b;
    public l c;
    public boolean d;
    public int e;

    public a(e.a.w0.c.a a10) {
        this.a = a10;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable throwable) {
        e.a.t0.a.b(throwable);
        this.b.cancel();
        this.onError(throwable);
    }

    public void cancel() {
        this.b.cancel();
    }

    public void clear() {
        this.c.clear();
    }

    public final int d(int n10) {
        int n11;
        l l10 = this.c;
        if (l10 != null && (n11 = n10 & 4) == 0) {
            if ((n10 = l10.requestFusion(n10)) != 0) {
                this.e = n10;
            }
            return n10;
        }
        return 0;
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public final boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public final boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.a.onError(throwable);
    }

    public final void onSubscribe(e object) {
        e e10 = this.b;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            boolean bl3;
            this.b = object;
            bl2 = object instanceof l;
            if (bl2) {
                object = (l)object;
                this.c = object;
            }
            if (bl3 = this.b()) {
                object = this.a;
                object.onSubscribe(this);
                this.a();
            }
        }
    }

    public void request(long l10) {
        this.b.request(l10);
    }
}

