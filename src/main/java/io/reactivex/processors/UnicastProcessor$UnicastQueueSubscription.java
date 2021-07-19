/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.w0.f.a;
import e.a.w0.i.b;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastProcessor$UnicastQueueSubscription
extends BasicIntQueueSubscription {
    private static final long serialVersionUID = -4896760517184205454L;
    public final /* synthetic */ UnicastProcessor this$0;

    public UnicastProcessor$UnicastQueueSubscription(UnicastProcessor unicastProcessor) {
        this.this$0 = unicastProcessor;
    }

    public void cancel() {
        Object object = this.this$0;
        int n10 = ((UnicastProcessor)object).h;
        if (n10 != 0) {
            return;
        }
        this.this$0.h = true;
        this.this$0.V8();
        object = this.this$0.g;
        boolean bl2 = false;
        ((AtomicReference)object).lazySet(null);
        object = this.this$0.j;
        n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            this.this$0.g.lazySet(null);
            object = this.this$0;
            bl2 = ((UnicastProcessor)object).l;
            if (!bl2) {
                object = ((UnicastProcessor)object).b;
                ((a)object).clear();
            }
        }
    }

    public void clear() {
        this.this$0.b.clear();
    }

    public boolean isEmpty() {
        return this.this$0.b.isEmpty();
    }

    public Object poll() {
        return this.this$0.b.poll();
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.this$0.k;
            b.a(atomicLong, l10);
            UnicastProcessor unicastProcessor = this.this$0;
            unicastProcessor.W8();
        }
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.this$0.l = true;
            return n11;
        }
        return 0;
    }
}

