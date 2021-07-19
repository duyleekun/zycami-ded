/*
 * Decompiled with CFR 0.151.
 */
package e.a.e1;

import e.a.o;
import e.a.w0.i.f;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public abstract class a
implements o {
    public e a;

    public final void a() {
        e e10 = this.a;
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.a = subscriptionHelper;
        e10.cancel();
    }

    public void b() {
        this.c(Long.MAX_VALUE);
    }

    public final void c(long l10) {
        e e10 = this.a;
        if (e10 != null) {
            e10.request(l10);
        }
    }

    public final void onSubscribe(e e10) {
        e e11 = this.a;
        Class<?> clazz = this.getClass();
        boolean bl2 = f.f(e11, e10, clazz);
        if (bl2) {
            this.a = e10;
            this.b();
        }
    }
}

