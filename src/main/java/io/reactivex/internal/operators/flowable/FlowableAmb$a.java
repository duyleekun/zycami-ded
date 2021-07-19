/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableAmb$AmbInnerSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableAmb$a
implements e {
    public final d a;
    public final FlowableAmb$AmbInnerSubscriber[] b;
    public final AtomicInteger c;

    public FlowableAmb$a(d ambInnerSubscriberArray, int n10) {
        AtomicInteger atomicInteger;
        this.c = atomicInteger = new AtomicInteger();
        this.a = ambInnerSubscriberArray;
        ambInnerSubscriberArray = new FlowableAmb$AmbInnerSubscriber[n10];
        this.b = ambInnerSubscriberArray;
    }

    public void a(c[] cArray) {
        FlowableAmb$AmbInnerSubscriber flowableAmb$AmbInnerSubscriber;
        FlowableAmb$AmbInnerSubscriber[] flowableAmb$AmbInnerSubscriberArray = this.b;
        int n10 = flowableAmb$AmbInnerSubscriberArray.length;
        int n11 = 0;
        int n12 = 0;
        Object object = null;
        while (n12 < n10) {
            int n13 = n12 + 1;
            d d10 = this.a;
            flowableAmb$AmbInnerSubscriberArray[n12] = flowableAmb$AmbInnerSubscriber = new FlowableAmb$AmbInnerSubscriber(this, n13, d10);
            n12 = n13;
        }
        this.c.lazySet(0);
        object = this.a;
        object.onSubscribe(this);
        while (n11 < n10) {
            object = this.c;
            n12 = ((AtomicInteger)object).get();
            if (n12 != 0) {
                return;
            }
            object = cArray[n11];
            flowableAmb$AmbInnerSubscriber = flowableAmb$AmbInnerSubscriberArray[n11];
            object.subscribe(flowableAmb$AmbInnerSubscriber);
            ++n11;
        }
    }

    public boolean b(int n10) {
        FlowableAmb$AmbInnerSubscriber[] flowableAmb$AmbInnerSubscriberArray = this.c;
        int n11 = flowableAmb$AmbInnerSubscriberArray.get();
        int n12 = 0;
        FlowableAmb$AmbInnerSubscriber flowableAmb$AmbInnerSubscriber = null;
        if (n11 == 0 && (n11 = (int)((flowableAmb$AmbInnerSubscriberArray = this.c).compareAndSet(0, n10) ? 1 : 0)) != 0) {
            flowableAmb$AmbInnerSubscriberArray = this.b;
            int n13 = flowableAmb$AmbInnerSubscriberArray.length;
            while (n12 < n13) {
                int n14 = n12 + 1;
                if (n14 != n10) {
                    flowableAmb$AmbInnerSubscriber = flowableAmb$AmbInnerSubscriberArray[n12];
                    flowableAmb$AmbInnerSubscriber.cancel();
                }
                n12 = n14;
            }
            return true;
        }
        return false;
    }

    public void cancel() {
        int n10;
        FlowableAmb$AmbInnerSubscriber[] flowableAmb$AmbInnerSubscriberArray = this.c;
        int n11 = flowableAmb$AmbInnerSubscriberArray.get();
        if (n11 != (n10 = -1)) {
            this.c.lazySet(n10);
            for (FlowableAmb$AmbInnerSubscriber flowableAmb$AmbInnerSubscriber : this.b) {
                flowableAmb$AmbInnerSubscriber.cancel();
            }
        }
    }

    public void request(long l10) {
        int n10 = SubscriptionHelper.validate(l10);
        if (n10 != 0) {
            Object object = this.c;
            n10 = ((AtomicInteger)object).get();
            if (n10 > 0) {
                FlowableAmb$AmbInnerSubscriber[] flowableAmb$AmbInnerSubscriberArray = this.b;
                object = flowableAmb$AmbInnerSubscriberArray[n10 += -1];
                ((FlowableAmb$AmbInnerSubscriber)object).request(l10);
            } else if (n10 == 0) {
                for (FlowableAmb$AmbInnerSubscriber flowableAmb$AmbInnerSubscriber : this.b) {
                    flowableAmb$AmbInnerSubscriber.request(l10);
                }
            }
        }
    }
}

