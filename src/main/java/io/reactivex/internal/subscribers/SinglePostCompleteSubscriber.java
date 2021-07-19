/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public abstract class SinglePostCompleteSubscriber
extends AtomicLong
implements o,
e {
    public static final long COMPLETE_MASK = Long.MIN_VALUE;
    public static final long REQUEST_MASK = Long.MAX_VALUE;
    private static final long serialVersionUID = 7917814472626990048L;
    public final d downstream;
    public long produced;
    public e upstream;
    public Object value;

    public SinglePostCompleteSubscriber(d d10) {
        this.downstream = d10;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public final void complete(Object object) {
        long l10 = this.produced;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            b.e(this, l10);
        }
        while (true) {
            long l13;
            long l14;
            long l15;
            long l16;
            if ((l16 = (l15 = (l14 = (l10 = this.get()) & (l13 = Long.MIN_VALUE)) - l11) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) {
                this.onDrop(object);
                return;
            }
            l14 = Long.MAX_VALUE;
            long l17 = (l10 &= l14) - l11;
            Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object3 != false) {
                this.lazySet(-9223372036854775807L);
                this.downstream.onNext(object);
                this.downstream.onComplete();
                return;
            }
            this.value = object;
            object3 = this.compareAndSet(l11, l13);
            if (object3 != false) {
                return;
            }
            object3 = 0;
            this.value = null;
        }
    }

    public void onDrop(Object object) {
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public final void request(long l10) {
        block3: {
            boolean bl2 = SubscriptionHelper.validate(l10);
            if (bl2) {
                long l11;
                long l12;
                do {
                    long l13;
                    long l14;
                    long l15;
                    long l16;
                    if ((l16 = (l15 = (l14 = (l12 = this.get()) & (l11 = Long.MIN_VALUE)) - (l13 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false) continue;
                    l10 = -9223372036854775807L;
                    boolean bl3 = this.compareAndSet(l11, l10);
                    if (bl3) {
                        d d10 = this.downstream;
                        Object object = this.value;
                        d10.onNext(object);
                        d10 = this.downstream;
                        d10.onComplete();
                    }
                    break block3;
                } while (!(bl2 = this.compareAndSet(l12, l11 = b.c(l12, l10))));
                e e10 = this.upstream;
                e10.request(l10);
            }
        }
    }
}

