/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.h0$c;
import e.a.w0.c.a;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelRunOn$BaseRunOnSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class ParallelRunOn$RunOnConditionalSubscriber
extends ParallelRunOn$BaseRunOnSubscriber {
    private static final long serialVersionUID = 1075119423897941642L;
    public final a downstream;

    public ParallelRunOn$RunOnConditionalSubscriber(a a10, int n10, SpscArrayQueue spscArrayQueue, h0$c h0$c) {
        super(n10, spscArrayQueue, h0$c);
        this.downstream = a10;
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        int n10 = SubscriptionHelper.validate((e)object, e10);
        if (n10 != 0) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            n10 = this.prefetch;
            long l10 = n10;
            e10.request(l10);
        }
    }

    public void run() {
        int n10;
        ParallelRunOn$RunOnConditionalSubscriber parallelRunOn$RunOnConditionalSubscriber = this;
        int n11 = this.consumed;
        SpscArrayQueue spscArrayQueue = this.queue;
        a a10 = this.downstream;
        int n12 = this.limit;
        int n13 = n10 = 1;
        while (true) {
            long l10;
            int n14;
            long l11;
            Object object;
            long l12;
            long l13;
            AtomicLong atomicLong = parallelRunOn$RunOnConditionalSubscriber.requested;
            long l14 = atomicLong.get();
            long l15 = l13 = 0L;
            while ((l12 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) != false) {
                Object object2;
                boolean bl2 = parallelRunOn$RunOnConditionalSubscriber.cancelled;
                if (bl2) {
                    spscArrayQueue.clear();
                    return;
                }
                bl2 = parallelRunOn$RunOnConditionalSubscriber.done;
                if (bl2 && (object2 = parallelRunOn$RunOnConditionalSubscriber.error) != null) {
                    spscArrayQueue.clear();
                    a10.onError((Throwable)object2);
                    parallelRunOn$RunOnConditionalSubscriber.worker.dispose();
                    return;
                }
                object2 = spscArrayQueue.poll();
                int n15 = object2 == null ? n10 : 0;
                if (bl2 && n15 != 0) {
                    a10.onComplete();
                    parallelRunOn$RunOnConditionalSubscriber.worker.dispose();
                    return;
                }
                if (n15 != 0) break;
                l12 = (long)a10.tryOnNext(object2);
                if (l12 != false) {
                    long l16 = 1L;
                    l15 += l16;
                }
                if (++n11 != n12) continue;
                object = parallelRunOn$RunOnConditionalSubscriber.upstream;
                long l17 = n11;
                object.request(l17);
                n11 = 0;
            }
            if (l12 == false) {
                l12 = (long)parallelRunOn$RunOnConditionalSubscriber.cancelled;
                if (l12 != false) {
                    spscArrayQueue.clear();
                    return;
                }
                l12 = (long)parallelRunOn$RunOnConditionalSubscriber.done;
                if (l12 != false) {
                    object = parallelRunOn$RunOnConditionalSubscriber.error;
                    if (object != null) {
                        spscArrayQueue.clear();
                        a10.onError((Throwable)object);
                        parallelRunOn$RunOnConditionalSubscriber.worker.dispose();
                        return;
                    }
                    l12 = (long)spscArrayQueue.isEmpty();
                    if (l12 != false) {
                        a10.onComplete();
                        parallelRunOn$RunOnConditionalSubscriber.worker.dispose();
                        return;
                    }
                }
            }
            if ((l11 = l15 == l13 ? 0 : (l15 < l13 ? -1 : 1)) != false && (n14 = (int)((l10 = l14 - (l13 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
                atomicLong = parallelRunOn$RunOnConditionalSubscriber.requested;
                long l18 = -l15;
                atomicLong.addAndGet(l18);
            }
            if ((n14 = this.get()) == n13) {
                parallelRunOn$RunOnConditionalSubscriber.consumed = n11;
                n13 = -n13;
                if ((n13 = parallelRunOn$RunOnConditionalSubscriber.addAndGet(n13)) != 0) continue;
                return;
            }
            n13 = n14;
        }
    }
}

