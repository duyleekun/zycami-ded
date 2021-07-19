/*
 * Decompiled with CFR 0.151.
 */
package e.a.e1;

import e.a.o;
import e.a.w0.a.b;
import e.a.w0.b.a;
import e.a.w0.i.f;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public abstract class c
implements o,
e.a.s0.b {
    private final AtomicReference a;
    private final b b;
    private final AtomicLong c;

    public c() {
        Object object = new AtomicReference();
        this.a = object;
        this.b = object = new b();
        this.c = object = new AtomicLong();
    }

    public final void a(e.a.s0.b b10) {
        e.a.w0.b.a.g(b10, "resource is null");
        this.b.b(b10);
    }

    public void b() {
        this.c(Long.MAX_VALUE);
    }

    public final void c(long l10) {
        AtomicReference atomicReference = this.a;
        AtomicLong atomicLong = this.c;
        SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
    }

    public final void dispose() {
        Object object = this.a;
        boolean bl2 = SubscriptionHelper.cancel((AtomicReference)object);
        if (bl2) {
            object = this.b;
            ((b)object).dispose();
        }
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
        Serializable serializable = this.a;
        Class<?> clazz = this.getClass();
        Object object = f.d((AtomicReference)serializable, e10, clazz);
        if (object) {
            serializable = this.c;
            long l10 = 0L;
            long l11 = ((AtomicLong)serializable).getAndSet(l10);
            long l12 = l11 - l10;
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object) {
                e10.request(l11);
            }
            this.b();
        }
    }
}

