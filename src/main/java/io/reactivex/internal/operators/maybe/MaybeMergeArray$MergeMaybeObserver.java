/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.t;
import e.a.w0.i.b;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeMergeArray$a;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;

public final class MaybeMergeArray$MergeMaybeObserver
extends BasicIntQueueSubscription
implements t {
    private static final long serialVersionUID = -660395290758764731L;
    public volatile boolean cancelled;
    public long consumed;
    public final d downstream;
    public final AtomicThrowable error;
    public boolean outputFused;
    public final MaybeMergeArray$a queue;
    public final AtomicLong requested;
    public final e.a.s0.a set;
    public final int sourceCount;

    public MaybeMergeArray$MergeMaybeObserver(d object, int n10, MaybeMergeArray$a maybeMergeArray$a) {
        this.downstream = object;
        this.sourceCount = n10;
        this.set = object = new e.a.s0.a();
        this.requested = object = new AtomicLong();
        this.error = object = new AtomicThrowable();
        this.queue = maybeMergeArray$a;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.set;
            ((e.a.s0.a)object).dispose();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.queue;
                object.clear();
            }
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = (int)(this.outputFused ? 1 : 0);
        if (n10 != 0) {
            this.drainFused();
        } else {
            this.drainNormal();
        }
    }

    public void drainFused() {
        int n10;
        d d10 = this.downstream;
        MaybeMergeArray$a maybeMergeArray$a = this.queue;
        int n11 = n10 = 1;
        do {
            int n12;
            int n13;
            if ((n13 = this.cancelled) != 0) {
                maybeMergeArray$a.clear();
                return;
            }
            Throwable throwable = (Throwable)this.error.get();
            if (throwable != null) {
                maybeMergeArray$a.clear();
                d10.onError(throwable);
                return;
            }
            n13 = maybeMergeArray$a.producerIndex();
            if (n13 == (n12 = this.sourceCount)) {
                n13 = n10;
            } else {
                n13 = 0;
                throwable = null;
            }
            n12 = (int)(maybeMergeArray$a.isEmpty() ? 1 : 0);
            if (n12 == 0) {
                n12 = 0;
                d10.onNext(null);
            }
            if (n13 != 0) {
                d10.onComplete();
                return;
            }
            n11 = -n11;
        } while ((n11 = this.addAndGet(n11)) != 0);
    }

    public void drainNormal() {
        d d10 = this.downstream;
        Object object = this.queue;
        long l10 = this.consumed;
        int n10 = 1;
        do {
            long l11;
            Object object2 = this.requested;
            long l12 = ((AtomicLong)object2).get();
            while ((l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) != false) {
                int n11;
                int n12 = this.cancelled;
                if (n12 != 0) {
                    object.clear();
                    return;
                }
                Object object3 = (Throwable)this.error.get();
                if (object3 != null) {
                    object.clear();
                    object = this.error.terminate();
                    d10.onError((Throwable)object);
                    return;
                }
                n12 = object.consumerIndex();
                if (n12 == (n11 = this.sourceCount)) {
                    d10.onComplete();
                    return;
                }
                object3 = object.poll();
                if (object3 == null) break;
                NotificationLite notificationLite = NotificationLite.COMPLETE;
                if (object3 == notificationLite) continue;
                d10.onNext(object3);
                long l13 = 1L;
                l10 += l13;
            }
            if (l11 == false) {
                int n13;
                NotificationLite notificationLite;
                object2 = (Throwable)this.error.get();
                if (object2 != null) {
                    object.clear();
                    object = this.error.terminate();
                    d10.onError((Throwable)object);
                    return;
                }
                while ((object2 = object.peek()) == (notificationLite = NotificationLite.COMPLETE)) {
                    object.drop();
                }
                int n14 = object.consumerIndex();
                if (n14 == (n13 = this.sourceCount)) {
                    d10.onComplete();
                    return;
                }
            }
            this.consumed = l10;
            n10 = -n10;
        } while ((n10 = this.addAndGet(n10)) != 0);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        MaybeMergeArray$a maybeMergeArray$a = this.queue;
        NotificationLite notificationLite = NotificationLite.COMPLETE;
        maybeMergeArray$a.offer((Object)notificationLite);
        this.drain();
    }

    public void onError(Throwable object) {
        Object object2 = this.error;
        boolean bl2 = object2.addThrowable((Throwable)object);
        if (bl2) {
            this.set.dispose();
            object = this.queue;
            object2 = NotificationLite.COMPLETE;
            object.offer(object2);
            this.drain();
        } else {
            a.Y((Throwable)object);
        }
    }

    public void onSubscribe(e.a.s0.b b10) {
        this.set.b(b10);
    }

    public void onSuccess(Object object) {
        this.queue.offer(object);
        this.drain();
    }

    public Object poll() {
        NotificationLite notificationLite;
        Object object;
        while ((object = this.queue.poll()) == (notificationLite = NotificationLite.COMPLETE)) {
        }
        return object;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }
}

