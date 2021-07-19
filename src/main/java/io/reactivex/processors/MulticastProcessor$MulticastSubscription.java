/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.MulticastProcessor;
import java.util.concurrent.atomic.AtomicLong;

public final class MulticastProcessor$MulticastSubscription
extends AtomicLong
implements e {
    private static final long serialVersionUID = -363282618957264509L;
    public final d downstream;
    public long emitted;
    public final MulticastProcessor parent;

    public MulticastProcessor$MulticastSubscription(d d10, MulticastProcessor multicastProcessor) {
        this.downstream = d10;
        this.parent = multicastProcessor;
    }

    public void cancel() {
        long l10 = Long.MIN_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            MulticastProcessor multicastProcessor = this.parent;
            multicastProcessor.W8(this);
        }
    }

    public void onComplete() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            d d10 = this.downstream;
            d10.onError(throwable);
        }
    }

    public void onNext(Object object) {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            l11 = this.emitted;
            l10 = 1L;
            this.emitted = l11 += l10;
            d d10 = this.downstream;
            d10.onNext(object);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            long l11;
            long l12;
            long l13;
            long l14;
            long l15;
            long l16;
            while ((l16 = (l15 = (l14 = this.get()) - (l13 = Long.MIN_VALUE)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false && (l12 = (l11 = l14 - (l13 = Long.MAX_VALUE)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
                long l17 = l14 + l10;
                long l18 = 0L;
                long l19 = l17 - l18;
                Object object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object >= 0) {
                    l13 = l17;
                }
                if (!(bl2 = this.compareAndSet(l14, l13))) continue;
                MulticastProcessor multicastProcessor = this.parent;
                multicastProcessor.U8();
                break;
            }
        }
    }
}

