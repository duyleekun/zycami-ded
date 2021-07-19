/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.v0.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableZip$ZipSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableZip$ZipCoordinator
extends AtomicInteger
implements e {
    private static final long serialVersionUID = -2434867452883857743L;
    public volatile boolean cancelled;
    public final Object[] current;
    public final boolean delayErrors;
    public final d downstream;
    public final AtomicThrowable errors;
    public final AtomicLong requested;
    public final FlowableZip$ZipSubscriber[] subscribers;
    public final o zipper;

    public FlowableZip$ZipCoordinator(d object, o objectArray, int n10, int n11, boolean bl2) {
        this.downstream = object;
        this.zipper = objectArray;
        this.delayErrors = bl2;
        object = new FlowableZip$ZipSubscriber[n10];
        objectArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            FlowableZip$ZipSubscriber flowableZip$ZipSubscriber;
            object[i10] = flowableZip$ZipSubscriber = new FlowableZip$ZipSubscriber(this, n11);
        }
        objectArray = new Object[n10];
        this.current = objectArray;
        this.subscribers = object;
        this.requested = object;
        super();
        this.errors = object;
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            this.cancelAll();
        }
    }

    public void cancelAll() {
        for (FlowableZip$ZipSubscriber flowableZip$ZipSubscriber : this.subscribers) {
            flowableZip$ZipSubscriber.cancel();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void drain() {
        FlowableZip$ZipCoordinator flowableZip$ZipCoordinator = this;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        FlowableZip$ZipSubscriber[] flowableZip$ZipSubscriberArray = this.subscribers;
        int n11 = flowableZip$ZipSubscriberArray.length;
        Object[] objectArray = this.current;
        int n12 = 1;
        do {
            long l10;
            long l11;
            boolean bl2;
            boolean bl3;
            Object object;
            Object object2;
            int n13;
            Object object3;
            long l12;
            Object object4 = flowableZip$ZipCoordinator.requested;
            long l13 = ((AtomicLong)object4).get();
            long l14 = 0L;
            while ((l12 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1)) != false) {
                n10 = (int)(flowableZip$ZipCoordinator.cancelled ? 1 : 0);
                if (n10 != 0) {
                    return;
                }
                n10 = (int)(flowableZip$ZipCoordinator.delayErrors ? 1 : 0);
                if (n10 == 0 && (object4 = flowableZip$ZipCoordinator.errors.get()) != null) {
                    this.cancelAll();
                    object4 = flowableZip$ZipCoordinator.errors.terminate();
                    d10.onError((Throwable)object4);
                    return;
                }
                n10 = 0;
                object4 = null;
                object3 = null;
                for (n13 = 0; n13 < n11; ++n13) {
                    block28: {
                        object2 = flowableZip$ZipSubscriberArray[n13];
                        object = objectArray[n13];
                        if (object != null) continue;
                        try {
                            bl3 = ((FlowableZip$ZipSubscriber)object2).done;
                            object2 = ((FlowableZip$ZipSubscriber)object2).queue;
                            if (object2 != null) {
                                object2 = object2.poll();
                            } else {
                                bl2 = false;
                                object2 = null;
                            }
                            boolean bl4 = object2 == null;
                            if (bl3 && bl4) {
                                this.cancelAll();
                                object4 = flowableZip$ZipCoordinator.errors;
                                object4 = ((AtomicReference)object4).get();
                                object4 = (Throwable)object4;
                                if (object4 != null) {
                                    object4 = flowableZip$ZipCoordinator.errors;
                                    object4 = ((AtomicThrowable)object4).terminate();
                                    d10.onError((Throwable)object4);
                                    return;
                                }
                                d10.onComplete();
                                return;
                            }
                            if (!bl4) {
                                objectArray[n13] = object2;
                                continue;
                            }
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            object2 = flowableZip$ZipCoordinator.errors;
                            ((AtomicThrowable)object2).addThrowable(throwable);
                            n10 = (int)(flowableZip$ZipCoordinator.delayErrors ? 1 : 0);
                            if (n10 != 0) break block28;
                            this.cancelAll();
                            Throwable throwable2 = flowableZip$ZipCoordinator.errors.terminate();
                            d10.onError(throwable2);
                            return;
                        }
                    }
                    n10 = 1;
                }
                if (n10 != 0) break;
                try {
                    object4 = flowableZip$ZipCoordinator.zipper;
                    object3 = objectArray.clone();
                    object4 = object4.apply(object3);
                    object3 = "The zipper returned a null value";
                    object4 = e.a.w0.b.a.g(object4, (String)object3);
                    d10.onNext(object4);
                    l11 = 1L;
                    l14 += l11;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.cancelAll();
                    flowableZip$ZipCoordinator.errors.addThrowable(throwable);
                    Throwable throwable3 = flowableZip$ZipCoordinator.errors.terminate();
                    d10.onError(throwable3);
                    return;
                }
                Arrays.fill(objectArray, null);
            }
            if (l12 == false) {
                n10 = (int)(flowableZip$ZipCoordinator.cancelled ? 1 : 0);
                if (n10 != 0) {
                    return;
                }
                n10 = (int)(flowableZip$ZipCoordinator.delayErrors ? 1 : 0);
                if (n10 == 0 && (object4 = flowableZip$ZipCoordinator.errors.get()) != null) {
                    this.cancelAll();
                    object4 = flowableZip$ZipCoordinator.errors.terminate();
                    d10.onError((Throwable)object4);
                    return;
                }
                object3 = null;
                for (n13 = 0; n13 < n11; ++n13) {
                    object4 = flowableZip$ZipSubscriberArray[n13];
                    object2 = objectArray[n13];
                    if (object2 != null) continue;
                    try {
                        bl2 = ((FlowableZip$ZipSubscriber)object4).done;
                        object4 = ((FlowableZip$ZipSubscriber)object4).queue;
                        if (object4 != null) {
                            object4 = object4.poll();
                        } else {
                            n10 = 0;
                            object4 = null;
                        }
                        if (object4 == null) {
                            bl3 = true;
                        } else {
                            bl3 = false;
                            object = null;
                        }
                        if (bl2 && bl3) {
                            this.cancelAll();
                            object4 = flowableZip$ZipCoordinator.errors;
                            object4 = ((AtomicReference)object4).get();
                            object4 = (Throwable)object4;
                            if (object4 != null) {
                                object4 = flowableZip$ZipCoordinator.errors;
                                object4 = ((AtomicThrowable)object4).terminate();
                                d10.onError((Throwable)object4);
                                return;
                            }
                            d10.onComplete();
                            return;
                        }
                        if (bl3) continue;
                        objectArray[n13] = object4;
                        continue;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        object2 = flowableZip$ZipCoordinator.errors;
                        ((AtomicThrowable)object2).addThrowable(throwable);
                        n10 = (int)(flowableZip$ZipCoordinator.delayErrors ? 1 : 0);
                        if (n10 != 0) continue;
                        this.cancelAll();
                        Throwable throwable4 = flowableZip$ZipCoordinator.errors.terminate();
                        d10.onError(throwable4);
                        return;
                    }
                }
            }
            if ((n10 = (int)((l10 = l14 - (l11 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) == 0) continue;
            n10 = flowableZip$ZipSubscriberArray.length;
            object3 = null;
            for (n13 = 0; n13 < n10; ++n13) {
                object2 = flowableZip$ZipSubscriberArray[n13];
                ((FlowableZip$ZipSubscriber)object2).request(l14);
            }
            l11 = Long.MAX_VALUE;
            long l15 = l13 - l11;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 == 0) continue;
            object4 = flowableZip$ZipCoordinator.requested;
            l13 = -l14;
            ((AtomicLong)object4).addAndGet(l13);
        } while ((n12 = flowableZip$ZipCoordinator.addAndGet(n10 = -n12)) != 0);
    }

    public void error(FlowableZip$ZipSubscriber flowableZip$ZipSubscriber, Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3;
            flowableZip$ZipSubscriber.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public void subscribe(c[] cArray, int n10) {
        Object object;
        boolean bl2;
        FlowableZip$ZipSubscriber[] flowableZip$ZipSubscriberArray = this.subscribers;
        for (int i10 = 0; i10 < n10 && !(bl2 = this.cancelled) && ((bl2 = this.delayErrors) || (object = this.errors.get()) == null); ++i10) {
            object = cArray[i10];
            FlowableZip$ZipSubscriber flowableZip$ZipSubscriber = flowableZip$ZipSubscriberArray[i10];
            object.subscribe(flowableZip$ZipSubscriber);
        }
    }
}

