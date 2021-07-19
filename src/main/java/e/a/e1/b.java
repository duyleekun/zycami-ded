/*
 * Decompiled with CFR 0.151.
 */
package e.a.e1;

import e.a.o;
import e.a.w0.i.f;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b
implements o,
e.a.s0.b {
    public final AtomicReference a;

    public b() {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
    }

    public final void a() {
        this.dispose();
    }

    public void b() {
        ((e)this.a.get()).request(Long.MAX_VALUE);
    }

    public final void c(long l10) {
        ((e)this.a.get()).request(l10);
    }

    public final void dispose() {
        SubscriptionHelper.cancel(this.a);
    }

    public final boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.a.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public final void onSubscribe(e e10) {
        AtomicReference atomicReference = this.a;
        Class<?> clazz = this.getClass();
        boolean bl2 = f.d(atomicReference, e10, clazz);
        if (bl2) {
            this.b();
        }
    }
}

