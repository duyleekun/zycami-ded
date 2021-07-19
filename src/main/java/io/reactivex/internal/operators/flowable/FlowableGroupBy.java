/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$GroupBySubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupBy$a;
import io.reactivex.internal.util.EmptyComponent;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class FlowableGroupBy
extends a {
    public final o c;
    public final o d;
    public final int e;
    public final boolean f;
    public final o g;

    public FlowableGroupBy(j j10, o o10, o o11, int n10, boolean bl2, o o12) {
        super(j10);
        this.c = o10;
        this.d = o11;
        this.e = n10;
        this.f = bl2;
        this.g = o12;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d d10) {
        try {
            FlowableGroupBy$GroupBySubscriber flowableGroupBy$GroupBySubscriber;
            void var2_4;
            Object object;
            Object object2;
            o o10 = this.g;
            if (o10 == null) {
                Object var2_3 = null;
                object2 = new ConcurrentHashMap();
            } else {
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                object2 = new FlowableGroupBy$a(concurrentLinkedQueue);
                object = this.g;
                object2 = object.apply(object2);
                object2 = (Map)object2;
            }
            void var4_11 = var2_4;
            o o11 = this.c;
            o o12 = this.d;
            int n10 = this.e;
            boolean bl2 = this.f;
            object = flowableGroupBy$GroupBySubscriber;
            flowableGroupBy$GroupBySubscriber = new FlowableGroupBy$GroupBySubscriber(d10, o11, o12, n10, bl2, (Map)object2, (Queue)var4_11);
            this.b.l6(flowableGroupBy$GroupBySubscriber);
            return;
        }
        catch (Exception exception) {
            e.a.t0.a.b(exception);
            EmptyComponent emptyComponent = EmptyComponent.INSTANCE;
            d10.onSubscribe(emptyComponent);
            d10.onError(exception);
            return;
        }
    }
}

