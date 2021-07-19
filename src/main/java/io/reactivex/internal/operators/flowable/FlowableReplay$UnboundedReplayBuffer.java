/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

public final class FlowableReplay$UnboundedReplayBuffer
extends ArrayList
implements FlowableReplay$d {
    private static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public FlowableReplay$UnboundedReplayBuffer(int n10) {
        super(n10);
    }

    public void complete() {
        int n10;
        Object object = NotificationLite.complete();
        this.add(object);
        this.size = n10 = this.size + 1;
    }

    public void error(Throwable object) {
        int n10;
        object = NotificationLite.error((Throwable)object);
        this.add(object);
        this.size = n10 = this.size + 1;
    }

    public void next(Object object) {
        int n10;
        object = NotificationLite.next(object);
        this.add(object);
        this.size = n10 = this.size + 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void replay(FlowableReplay$InnerSubscription flowableReplay$InnerSubscription) {
        int n10;
        synchronized (flowableReplay$InnerSubscription) {
            boolean bl2 = flowableReplay$InnerSubscription.emitting;
            n10 = 1;
            if (bl2) {
                flowableReplay$InnerSubscription.missed = n10;
                return;
            }
            flowableReplay$InnerSubscription.emitting = n10;
        }
        d d10 = flowableReplay$InnerSubscription.child;
        while ((n10 = flowableReplay$InnerSubscription.isDisposed()) == 0) {
            long l10;
            int n11;
            n10 = this.size;
            Integer n12 = (Integer)flowableReplay$InnerSubscription.index();
            if (n12 != null) {
                n11 = n12;
            } else {
                n11 = 0;
                n12 = null;
            }
            long l11 = flowableReplay$InnerSubscription.get();
            long l12 = 0L;
            long l13 = l11;
            long l14 = l12;
            while ((l10 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1)) != false && n11 < n10) {
                Object e10 = this.get(n11);
                try {
                    l10 = (long)NotificationLite.accept(e10, d10);
                    if (l10 != false) {
                        return;
                    }
                }
                catch (Throwable throwable) {
                    a.b(throwable);
                    flowableReplay$InnerSubscription.dispose();
                    boolean bl3 = NotificationLite.isError(e10);
                    if (!bl3 && !(bl3 = NotificationLite.isComplete(e10))) {
                        d10.onError(throwable);
                    }
                    return;
                }
                l10 = (long)flowableReplay$InnerSubscription.isDisposed();
                if (l10 != false) {
                    return;
                }
                ++n11;
                long l15 = 1L;
                l13 -= l15;
                l14 += l15;
            }
            n10 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1));
            if (n10 != 0) {
                Integer n13 = n11;
                flowableReplay$InnerSubscription.index = n13;
                long l16 = Long.MAX_VALUE;
                long l17 = l11 - l16;
                n10 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                if (n10 != 0) {
                    flowableReplay$InnerSubscription.produced(l14);
                }
            }
            synchronized (flowableReplay$InnerSubscription) {
                n10 = (int)(flowableReplay$InnerSubscription.missed ? 1 : 0);
                if (n10 == 0) {
                    flowableReplay$InnerSubscription.emitting = false;
                    return;
                }
                flowableReplay$InnerSubscription.missed = false;
            }
        }
        return;
    }
}

