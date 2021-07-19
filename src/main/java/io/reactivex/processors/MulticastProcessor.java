/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.b1.a;
import e.a.j;
import e.a.w0.c.l;
import e.a.w0.c.o;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.MulticastProcessor$MulticastSubscription;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class MulticastProcessor
extends a {
    public static final MulticastProcessor$MulticastSubscription[] n = new MulticastProcessor$MulticastSubscription[0];
    public static final MulticastProcessor$MulticastSubscription[] o = new MulticastProcessor$MulticastSubscription[0];
    public final AtomicInteger b;
    public final AtomicReference c;
    public final AtomicReference d;
    public final AtomicBoolean e;
    public final int f;
    public final int g;
    public final boolean h;
    public volatile o i;
    public volatile boolean j;
    public volatile Throwable k;
    public int l;
    public int m;

    public MulticastProcessor(int n10, boolean bl2) {
        Serializable serializable;
        e.a.w0.b.a.h(n10, "bufferSize");
        this.f = n10;
        int n11 = n10 >> 2;
        this.g = n10 -= n11;
        this.b = serializable = new AtomicInteger();
        MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray = n;
        super(multicastProcessor$MulticastSubscriptionArray);
        this.d = serializable;
        super();
        this.c = serializable;
        this.h = bl2;
        super();
        this.e = serializable;
    }

    public static MulticastProcessor Q8() {
        int n10 = e.a.j.f0();
        MulticastProcessor multicastProcessor = new MulticastProcessor(n10, false);
        return multicastProcessor;
    }

    public static MulticastProcessor R8(int n10) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(n10, false);
        return multicastProcessor;
    }

    public static MulticastProcessor S8(int n10, boolean bl2) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(n10, bl2);
        return multicastProcessor;
    }

    public static MulticastProcessor T8(boolean bl2) {
        int n10 = e.a.j.f0();
        MulticastProcessor multicastProcessor = new MulticastProcessor(n10, bl2);
        return multicastProcessor;
    }

    public Throwable K8() {
        Serializable serializable = this.e;
        boolean bl2 = serializable.get();
        if (bl2) {
            serializable = this.k;
        } else {
            bl2 = false;
            serializable = null;
        }
        return serializable;
    }

    public boolean L8() {
        Serializable serializable = this.e;
        boolean bl2 = serializable.get();
        if (bl2 && (serializable = this.k) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            serializable = null;
        }
        return bl2;
    }

    public boolean M8() {
        MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray = (MulticastProcessor$MulticastSubscription[])this.d.get();
        boolean bl2 = multicastProcessor$MulticastSubscriptionArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            multicastProcessor$MulticastSubscriptionArray = null;
        }
        return bl2;
    }

    public boolean N8() {
        Serializable serializable = this.e;
        boolean bl2 = serializable.get();
        if (bl2 && (serializable = this.k) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            serializable = null;
        }
        return bl2;
    }

    public boolean P8(MulticastProcessor$MulticastSubscription multicastProcessor$MulticastSubscription) {
        MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray;
        MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((multicastProcessor$MulticastSubscriptionArray2 = (MulticastProcessor$MulticastSubscription[])this.d.get()) == (object = o)) {
                return false;
            }
            int n10 = multicastProcessor$MulticastSubscriptionArray2.length;
            int n11 = n10 + 1;
            multicastProcessor$MulticastSubscriptionArray = new MulticastProcessor$MulticastSubscription[n11];
            System.arraycopy(multicastProcessor$MulticastSubscriptionArray2, 0, multicastProcessor$MulticastSubscriptionArray, 0, n10);
            multicastProcessor$MulticastSubscriptionArray[n10] = multicastProcessor$MulticastSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.d)).compareAndSet(multicastProcessor$MulticastSubscriptionArray2, multicastProcessor$MulticastSubscriptionArray)));
        return true;
    }

    public void U8() {
        int n10;
        MulticastProcessor multicastProcessor = this;
        Object object = this.b;
        int n11 = ((AtomicInteger)object).getAndIncrement();
        if (n11 != 0) {
            return;
        }
        MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray = this.d;
        n11 = this.l;
        int n12 = this.g;
        int n13 = this.m;
        int n14 = n10 = 1;
        while (true) {
            Object object2;
            block29: {
                int n15;
                block30: {
                    MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray2;
                    int n16;
                    MulticastProcessor$MulticastSubscription multicastProcessor$MulticastSubscription;
                    block31: {
                        block28: {
                            long l10;
                            long l11;
                            long l12;
                            MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray3;
                            if ((object2 = multicastProcessor.i) == null || (n15 = (multicastProcessor$MulticastSubscriptionArray3 = (MulticastProcessor$MulticastSubscription[])multicastProcessor$MulticastSubscriptionArray.get()).length) == 0) break block29;
                            n15 = multicastProcessor$MulticastSubscriptionArray3.length;
                            long l13 = l12 = (long)-1;
                            int n17 = 0;
                            while (true) {
                                l11 = 0L;
                                if (n17 >= n15) break;
                                multicastProcessor$MulticastSubscription = multicastProcessor$MulticastSubscriptionArray3[n17];
                                long l14 = multicastProcessor$MulticastSubscription.get();
                                long l15 = l14 - l11;
                                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                                if (object3 >= 0) {
                                    object3 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                                    if (object3 == false) {
                                        l13 = multicastProcessor$MulticastSubscription.emitted;
                                        l13 = l14 - l13;
                                    } else {
                                        l12 = multicastProcessor$MulticastSubscription.emitted;
                                        l12 = l14 - l12;
                                        l13 = Math.min(l13, l12);
                                    }
                                }
                                ++n17;
                                l12 = -1;
                            }
                            n15 = n11;
                            while ((l10 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) > 0) {
                                Object object4;
                                object = (MulticastProcessor$MulticastSubscription[])multicastProcessor$MulticastSubscriptionArray.get();
                                if (object == (object4 = o)) {
                                    object2.clear();
                                    return;
                                }
                                if (multicastProcessor$MulticastSubscriptionArray3 != object) break block28;
                                n11 = (int)(multicastProcessor.j ? 1 : 0);
                                try {
                                    object4 = object2.poll();
                                }
                                catch (Throwable throwable) {
                                    object4 = throwable;
                                    e.a.t0.a.b(throwable);
                                    SubscriptionHelper.cancel(multicastProcessor.c);
                                    object = null;
                                    multicastProcessor.k = object4;
                                    multicastProcessor.j = n10;
                                    object4 = null;
                                    n11 = n10;
                                }
                                if (object4 == null) {
                                    n16 = n10;
                                } else {
                                    n16 = 0;
                                    multicastProcessor$MulticastSubscription = null;
                                }
                                if (n11 != 0 && n16 != 0) {
                                    object = multicastProcessor.k;
                                    if (object != null) {
                                        MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray4 = o;
                                        multicastProcessor$MulticastSubscriptionArray = multicastProcessor$MulticastSubscriptionArray.getAndSet(multicastProcessor$MulticastSubscriptionArray4);
                                        n12 = multicastProcessor$MulticastSubscriptionArray.length;
                                        multicastProcessor$MulticastSubscription = null;
                                        for (n16 = 0; n16 < n12; ++n16) {
                                            MulticastProcessor$MulticastSubscription multicastProcessor$MulticastSubscription2 = multicastProcessor$MulticastSubscriptionArray[n16];
                                            multicastProcessor$MulticastSubscription2.onError((Throwable)object);
                                        }
                                    } else {
                                        object = o;
                                        object = multicastProcessor$MulticastSubscriptionArray.getAndSet(object);
                                        int n18 = ((MulticastProcessor$MulticastSubscription[])object).length;
                                        multicastProcessor$MulticastSubscription = null;
                                        for (n16 = 0; n16 < n18; ++n16) {
                                            MulticastProcessor$MulticastSubscription multicastProcessor$MulticastSubscription3 = object[n16];
                                            multicastProcessor$MulticastSubscription3.onComplete();
                                        }
                                    }
                                    return;
                                }
                                if (n16 != 0) break;
                                n11 = multicastProcessor$MulticastSubscriptionArray3.length;
                                multicastProcessor$MulticastSubscriptionArray2 = null;
                                for (l10 = (long)0; l10 < n11; ++l10) {
                                    multicastProcessor$MulticastSubscription = multicastProcessor$MulticastSubscriptionArray3[l10];
                                    multicastProcessor$MulticastSubscription.onNext(object4);
                                }
                                l12 = 1L;
                                l13 -= l12;
                                if (n13 == n10 || ++n15 != n12) continue;
                                object = (e)multicastProcessor.c.get();
                                long l16 = n12;
                                object.request(l16);
                                n15 = 0;
                            }
                            if (l10 != false) break block30;
                            object = (MulticastProcessor$MulticastSubscription[])multicastProcessor$MulticastSubscriptionArray.get();
                            if (object == (multicastProcessor$MulticastSubscriptionArray2 = o)) {
                                object2.clear();
                                return;
                            }
                            if (multicastProcessor$MulticastSubscriptionArray3 == object) break block31;
                        }
                        n11 = n15;
                        continue;
                    }
                    n11 = (int)(multicastProcessor.j ? 1 : 0);
                    if (n11 != 0 && (n11 = (int)(object2.isEmpty() ? 1 : 0)) != 0) {
                        object = multicastProcessor.k;
                        if (object != null) {
                            multicastProcessor$MulticastSubscriptionArray = multicastProcessor$MulticastSubscriptionArray.getAndSet(multicastProcessor$MulticastSubscriptionArray2);
                            n12 = multicastProcessor$MulticastSubscriptionArray.length;
                            multicastProcessor$MulticastSubscription = null;
                            for (n16 = 0; n16 < n12; ++n16) {
                                MulticastProcessor$MulticastSubscription multicastProcessor$MulticastSubscription4 = multicastProcessor$MulticastSubscriptionArray[n16];
                                multicastProcessor$MulticastSubscription4.onError((Throwable)object);
                            }
                        } else {
                            object = multicastProcessor$MulticastSubscriptionArray.getAndSet(multicastProcessor$MulticastSubscriptionArray2);
                            int n19 = ((MulticastProcessor$MulticastSubscription[])object).length;
                            multicastProcessor$MulticastSubscription = null;
                            for (n16 = 0; n16 < n19; ++n16) {
                                MulticastProcessor$MulticastSubscription multicastProcessor$MulticastSubscription5 = object[n16];
                                multicastProcessor$MulticastSubscription5.onComplete();
                            }
                        }
                        return;
                    }
                }
                n11 = n15;
            }
            multicastProcessor.l = n11;
            object2 = multicastProcessor.b;
            n14 = -n14;
            if ((n14 = ((AtomicInteger)object2).addAndGet(n14)) == 0) break;
        }
    }

    public boolean V8(Object object) {
        boolean bl2;
        Object object2 = this.e;
        boolean n10 = ((AtomicBoolean)object2).get();
        if (n10) {
            return false;
        }
        object2 = "offer called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(object, (String)object2);
        int n11 = this.m;
        if (n11 == 0 && (bl2 = (object2 = this.i).offer(object))) {
            this.U8();
            return true;
        }
        return false;
    }

    public void W8(MulticastProcessor$MulticastSubscription serializable) {
        while (true) {
            boolean bl2;
            AtomicReference atomicReference;
            MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray;
            int n10;
            MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray2;
            int n11;
            if ((n11 = (multicastProcessor$MulticastSubscriptionArray2 = (MulticastProcessor$MulticastSubscription[])this.d.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                multicastProcessor$MulticastSubscriptionArray = multicastProcessor$MulticastSubscriptionArray2[n10];
                if (multicastProcessor$MulticastSubscriptionArray != serializable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) break;
            n10 = 1;
            if (n11 == n10) {
                MulticastProcessor$MulticastSubscription[] multicastProcessor$MulticastSubscriptionArray3;
                n11 = (int)(this.h ? 1 : 0);
                if (n11 != 0) {
                    atomicReference = this.d;
                    multicastProcessor$MulticastSubscriptionArray3 = o;
                    bl2 = atomicReference.compareAndSet(multicastProcessor$MulticastSubscriptionArray2, multicastProcessor$MulticastSubscriptionArray3);
                    if (!bl2) continue;
                    SubscriptionHelper.cancel(this.c);
                    serializable = this.e;
                    ((AtomicBoolean)serializable).set(n10 != 0);
                    break;
                }
                atomicReference = this.d;
                multicastProcessor$MulticastSubscriptionArray3 = n;
                bl2 = atomicReference.compareAndSet(multicastProcessor$MulticastSubscriptionArray2, multicastProcessor$MulticastSubscriptionArray3);
                if (!bl2) continue;
                break;
            }
            int n14 = n11 + -1;
            multicastProcessor$MulticastSubscriptionArray = new MulticastProcessor$MulticastSubscription[n14];
            System.arraycopy(multicastProcessor$MulticastSubscriptionArray2, 0, multicastProcessor$MulticastSubscriptionArray, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(multicastProcessor$MulticastSubscriptionArray2, n13, multicastProcessor$MulticastSubscriptionArray, n12, n11);
            atomicReference = this.d;
            bl2 = atomicReference.compareAndSet(multicastProcessor$MulticastSubscriptionArray2, multicastProcessor$MulticastSubscriptionArray);
            if (bl2) break;
        }
    }

    public void X8() {
        Serializable serializable = this.c;
        EmptySubscription emptySubscription = EmptySubscription.INSTANCE;
        boolean bl2 = SubscriptionHelper.setOnce(serializable, emptySubscription);
        if (bl2) {
            int n10 = this.f;
            serializable = new SpscArrayQueue(n10);
            this.i = serializable;
        }
    }

    public void Y8() {
        Object object = this.c;
        EmptySubscription emptySubscription = EmptySubscription.INSTANCE;
        boolean bl2 = SubscriptionHelper.setOnce((AtomicReference)object, emptySubscription);
        if (bl2) {
            int n10 = this.f;
            this.i = object = new e.a.w0.f.a(n10);
        }
    }

    public void m6(d d10) {
        Serializable serializable = new MulticastProcessor$MulticastSubscription(d10, this);
        d10.onSubscribe((e)((Object)serializable));
        boolean bl2 = this.P8((MulticastProcessor$MulticastSubscription)serializable);
        if (bl2) {
            long l10;
            long l11 = ((AtomicLong)serializable).get();
            long l12 = l11 - (l10 = Long.MIN_VALUE);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                this.W8((MulticastProcessor$MulticastSubscription)serializable);
            } else {
                this.U8();
            }
        } else {
            serializable = this.e;
            boolean bl3 = ((AtomicBoolean)serializable).get();
            if ((bl3 || !(bl3 = this.h)) && (serializable = this.k) != null) {
                d10.onError((Throwable)serializable);
                return;
            }
            d10.onComplete();
        }
    }

    public void onComplete() {
        AtomicBoolean atomicBoolean = this.e;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.compareAndSet(false, bl2);
        if (bl3) {
            this.j = bl2;
            this.U8();
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicBoolean atomicBoolean = this.e;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.compareAndSet(false, bl2);
        if (bl3) {
            this.k = throwable;
            this.j = bl2;
            this.U8();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        Object object2 = this.e;
        boolean n10 = ((AtomicBoolean)object2).get();
        if (n10) {
            return;
        }
        int n11 = this.m;
        if (n11 == 0) {
            e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            object2 = this.i;
            boolean bl2 = object2.offer(object);
            if (!bl2) {
                SubscriptionHelper.cancel(this.c);
                object = new MissingBackpressureException();
                this.onError((Throwable)object);
                return;
            }
        }
        this.U8();
    }

    public void onSubscribe(e e10) {
        Object object = this.c;
        int n10 = SubscriptionHelper.setOnce((AtomicReference)object, e10);
        if (n10 != 0) {
            int n11;
            n10 = e10 instanceof l;
            if (n10 != 0) {
                int n12;
                object = e10;
                object = (l)e10;
                n11 = object.requestFusion(3);
                if (n11 == (n12 = 1)) {
                    this.m = n11;
                    this.i = object;
                    this.j = n12;
                    this.U8();
                    return;
                }
                n12 = 2;
                if (n11 == n12) {
                    this.m = n11;
                    this.i = object;
                    long l10 = this.f;
                    e10.request(l10);
                    return;
                }
            }
            n11 = this.f;
            this.i = object = new SpscArrayQueue(n11);
            n10 = this.f;
            long l11 = n10;
            e10.request(l11);
        }
    }
}

