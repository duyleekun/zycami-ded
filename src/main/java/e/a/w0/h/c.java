/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import e.a.o;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class c
extends CountDownLatch
implements o {
    public Object a;
    public Throwable b;
    public e c;
    public volatile boolean d;

    public c() {
        super(1);
    }

    public final Object a() {
        Throwable throwable;
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            try {
                e.a.w0.i.c.b();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                e e10 = this.c;
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                this.c = subscriptionHelper;
                if (e10 != null) {
                    e10.cancel();
                }
                throw ExceptionHelper.f(interruptedException);
            }
        }
        if ((throwable = this.b) == null) {
            return this.a;
        }
        throw ExceptionHelper.f(throwable);
    }

    public final void onComplete() {
        this.countDown();
    }

    public final void onSubscribe(e e10) {
        e e11 = this.c;
        boolean bl2 = SubscriptionHelper.validate(e11, e10);
        if (bl2) {
            this.c = e10;
            bl2 = this.d;
            if (!bl2) {
                long l10 = Long.MAX_VALUE;
                e10.request(l10);
                bl2 = this.d;
                if (bl2) {
                    this.c = e11 = SubscriptionHelper.CANCELLED;
                    e10.cancel();
                }
            }
        }
    }
}

