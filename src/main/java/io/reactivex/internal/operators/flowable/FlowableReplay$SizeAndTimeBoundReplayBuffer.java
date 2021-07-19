/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.c1.d;
import e.a.h0;
import io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer;
import io.reactivex.internal.operators.flowable.FlowableReplay$Node;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;

public final class FlowableReplay$SizeAndTimeBoundReplayBuffer
extends FlowableReplay$BoundedReplayBuffer {
    private static final long serialVersionUID = 3457957419649567404L;
    public final int limit;
    public final long maxAge;
    public final h0 scheduler;
    public final TimeUnit unit;

    public FlowableReplay$SizeAndTimeBoundReplayBuffer(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.scheduler = h02;
        this.limit = n10;
        this.maxAge = l10;
        this.unit = timeUnit;
    }

    public Object enterTransform(Object object) {
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        TimeUnit timeUnit2 = this.unit;
        d d10 = new d(object, l10, timeUnit2);
        return d10;
    }

    public FlowableReplay$Node getHead() {
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        long l11 = this.maxAge;
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node)this.get();
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node.get();
        while (true) {
            long l12;
            long l13;
            long l14;
            d d10;
            Object object;
            boolean bl2;
            FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node;
            flowableReplay$Node = flowableReplay$Node3;
            if (flowableReplay$Node3 == null || (bl2 = NotificationLite.isComplete(object = (d10 = (d)flowableReplay$Node3.value).d())) || (bl2 = NotificationLite.isError(object = d10.d())) || (l14 = (l13 = (l12 = d10.a()) - (l10 -= l11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) break;
            flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node3.get();
        }
        return flowableReplay$Node2;
    }

    public Object leaveTransform(Object object) {
        return ((d)object).d();
    }

    public void truncate() {
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        long l11 = this.maxAge;
        l10 -= l11;
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node)this.get();
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node.get();
        int n10 = 0;
        while (true) {
            int n11;
            FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node;
            flowableReplay$Node = flowableReplay$Node3;
            if (flowableReplay$Node3 == null) break;
            int n12 = this.size;
            int n13 = this.limit;
            int n14 = 1;
            if (n12 > n13 && n12 > n14) {
                ++n10;
                this.size = n12 += -1;
                flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node3.get();
                continue;
            }
            d d10 = (d)flowableReplay$Node.value;
            long l12 = d10.a();
            long l13 = l12 - l10;
            n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n12 > 0) break;
            ++n10;
            this.size = n11 = this.size - n14;
            flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node.get();
        }
        if (n10 != 0) {
            this.setFirst(flowableReplay$Node2);
        }
    }

    public void truncateFinal() {
        h0 h02 = this.scheduler;
        TimeUnit timeUnit = this.unit;
        long l10 = h02.d(timeUnit);
        long l11 = this.maxAge;
        FlowableReplay$Node flowableReplay$Node = (FlowableReplay$Node)this.get();
        FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node.get();
        int n10 = 0;
        while (true) {
            int n11;
            d d10;
            long l12;
            long l13;
            int n12;
            int n13;
            FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node;
            flowableReplay$Node = flowableReplay$Node3;
            if (flowableReplay$Node3 == null || (n13 = this.size) <= (n12 = 1) || (n13 = (int)((l13 = (l12 = (d10 = (d)flowableReplay$Node3.value).a()) - (l10 -= l11)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) > 0) break;
            ++n10;
            this.size = n11 = this.size - n12;
            flowableReplay$Node2 = (FlowableReplay$Node)flowableReplay$Node3.get();
        }
        if (n10 != 0) {
            this.setFirst(flowableReplay$Node2);
        }
    }
}

