/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.b1.a;
import e.a.h0;
import i.g.d;
import i.g.e;
import io.reactivex.processors.ReplayProcessor$ReplaySubscription;
import io.reactivex.processors.ReplayProcessor$a;
import io.reactivex.processors.ReplayProcessor$b;
import io.reactivex.processors.ReplayProcessor$c;
import io.reactivex.processors.ReplayProcessor$d;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplayProcessor
extends a {
    private static final Object[] e = new Object[0];
    public static final ReplayProcessor$ReplaySubscription[] f = new ReplayProcessor$ReplaySubscription[0];
    public static final ReplayProcessor$ReplaySubscription[] g = new ReplayProcessor$ReplaySubscription[0];
    public final ReplayProcessor$a b;
    public boolean c;
    public final AtomicReference d;

    public ReplayProcessor(ReplayProcessor$a atomicReference) {
        this.b = atomicReference;
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray = f;
        this.d = atomicReference = new AtomicReference<ReplayProcessor$ReplaySubscription[]>(replayProcessor$ReplaySubscriptionArray);
    }

    public static ReplayProcessor R8() {
        ReplayProcessor$d replayProcessor$d = new ReplayProcessor$d(16);
        ReplayProcessor replayProcessor = new ReplayProcessor(replayProcessor$d);
        return replayProcessor;
    }

    public static ReplayProcessor S8(int n10) {
        ReplayProcessor$d replayProcessor$d = new ReplayProcessor$d(n10);
        ReplayProcessor replayProcessor = new ReplayProcessor(replayProcessor$d);
        return replayProcessor;
    }

    public static ReplayProcessor T8() {
        ReplayProcessor$c replayProcessor$c = new ReplayProcessor$c(-1 >>> 1);
        ReplayProcessor replayProcessor = new ReplayProcessor(replayProcessor$c);
        return replayProcessor;
    }

    public static ReplayProcessor U8(int n10) {
        ReplayProcessor$c replayProcessor$c = new ReplayProcessor$c(n10);
        ReplayProcessor replayProcessor = new ReplayProcessor(replayProcessor$c);
        return replayProcessor;
    }

    public static ReplayProcessor V8(long l10, TimeUnit timeUnit, h0 h02) {
        ReplayProcessor$b replayProcessor$b = new ReplayProcessor$b(-1 >>> 1, l10, timeUnit, h02);
        ReplayProcessor replayProcessor = new ReplayProcessor(replayProcessor$b);
        return replayProcessor;
    }

    public static ReplayProcessor W8(long l10, TimeUnit timeUnit, h0 h02, int n10) {
        ReplayProcessor$b replayProcessor$b = new ReplayProcessor$b(n10, l10, timeUnit, h02);
        ReplayProcessor replayProcessor = new ReplayProcessor(replayProcessor$b);
        return replayProcessor;
    }

    public Throwable K8() {
        ReplayProcessor$a replayProcessor$a = this.b;
        boolean bl2 = replayProcessor$a.isDone();
        if (bl2) {
            return replayProcessor$a.getError();
        }
        return null;
    }

    public boolean L8() {
        boolean bl2;
        Object object = this.b;
        boolean bl3 = object.isDone();
        if (bl3 && (object = object.getError()) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean M8() {
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray = (ReplayProcessor$ReplaySubscription[])this.d.get();
        boolean bl2 = replayProcessor$ReplaySubscriptionArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            replayProcessor$ReplaySubscriptionArray = null;
        }
        return bl2;
    }

    public boolean N8() {
        boolean bl2;
        Object object = this.b;
        boolean bl3 = object.isDone();
        if (bl3 && (object = object.getError()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean P8(ReplayProcessor$ReplaySubscription replayProcessor$ReplaySubscription) {
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray;
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((replayProcessor$ReplaySubscriptionArray2 = (ReplayProcessor$ReplaySubscription[])this.d.get()) == (object = g)) {
                return false;
            }
            int n10 = replayProcessor$ReplaySubscriptionArray2.length;
            int n11 = n10 + 1;
            replayProcessor$ReplaySubscriptionArray = new ReplayProcessor$ReplaySubscription[n11];
            System.arraycopy(replayProcessor$ReplaySubscriptionArray2, 0, replayProcessor$ReplaySubscriptionArray, 0, n10);
            replayProcessor$ReplaySubscriptionArray[n10] = replayProcessor$ReplaySubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.d)).compareAndSet(replayProcessor$ReplaySubscriptionArray2, replayProcessor$ReplaySubscriptionArray)));
        return true;
    }

    public void Q8() {
        this.b.trimHead();
    }

    public Object X8() {
        return this.b.getValue();
    }

    public Object[] Y8() {
        Object[] objectArray = e;
        Object[] objectArray2 = this.Z8(objectArray);
        if (objectArray2 == objectArray) {
            return new Object[0];
        }
        return objectArray2;
    }

    public Object[] Z8(Object[] objectArray) {
        return this.b.getValues(objectArray);
    }

    public boolean a9() {
        ReplayProcessor$a replayProcessor$a = this.b;
        int n10 = replayProcessor$a.size();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            replayProcessor$a = null;
        }
        return n10 != 0;
    }

    public void b9(ReplayProcessor$ReplaySubscription replayProcessor$ReplaySubscription) {
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray;
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray2;
        while ((replayProcessor$ReplaySubscriptionArray2 = (ReplayProcessor$ReplaySubscription[])this.d.get()) != (replayProcessor$ReplaySubscriptionArray = g) && replayProcessor$ReplaySubscriptionArray2 != (replayProcessor$ReplaySubscriptionArray = f)) {
            AtomicReference atomicReference;
            boolean bl2;
            ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray3;
            int n10;
            int n11 = replayProcessor$ReplaySubscriptionArray2.length;
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                replayProcessor$ReplaySubscriptionArray3 = replayProcessor$ReplaySubscriptionArray2[n10];
                if (replayProcessor$ReplaySubscriptionArray3 != replayProcessor$ReplaySubscription) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                replayProcessor$ReplaySubscriptionArray = f;
            } else {
                int n14 = n11 + -1;
                replayProcessor$ReplaySubscriptionArray3 = new ReplayProcessor$ReplaySubscription[n14];
                System.arraycopy(replayProcessor$ReplaySubscriptionArray2, 0, replayProcessor$ReplaySubscriptionArray3, 0, n12);
                n13 = n12 + 1;
                n11 = n11 - n12 - n10;
                System.arraycopy(replayProcessor$ReplaySubscriptionArray2, n13, replayProcessor$ReplaySubscriptionArray3, n12, n11);
                replayProcessor$ReplaySubscriptionArray = replayProcessor$ReplaySubscriptionArray3;
            }
            if (!(bl2 = (atomicReference = this.d).compareAndSet(replayProcessor$ReplaySubscriptionArray2, replayProcessor$ReplaySubscriptionArray))) continue;
        }
    }

    public int c9() {
        return this.b.size();
    }

    public int d9() {
        return ((ReplayProcessor$ReplaySubscription[])this.d.get()).length;
    }

    public void m6(d d10) {
        ReplayProcessor$ReplaySubscription replayProcessor$ReplaySubscription = new ReplayProcessor$ReplaySubscription(d10, this);
        d10.onSubscribe(replayProcessor$ReplaySubscription);
        boolean bl2 = this.P8(replayProcessor$ReplaySubscription);
        if (bl2 && (bl2 = replayProcessor$ReplaySubscription.cancelled)) {
            this.b9(replayProcessor$ReplaySubscription);
            return;
        }
        this.b.a(replayProcessor$ReplaySubscription);
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = bl2 = true;
        ReplayProcessor$a replayProcessor$a = this.b;
        replayProcessor$a.complete();
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray = this.d;
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray2 = g;
        for (ReplayProcessor$ReplaySubscription replayProcessor$ReplaySubscription : replayProcessor$ReplaySubscriptionArray.getAndSet(replayProcessor$ReplaySubscriptionArray2)) {
            replayProcessor$a.a(replayProcessor$ReplaySubscription);
        }
    }

    public void onError(Throwable serializable) {
        Object object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(serializable, (String)object);
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y((Throwable)serializable);
            return;
        }
        this.c = bl2 = true;
        object = this.b;
        object.error((Throwable)serializable);
        serializable = this.d;
        ReplayProcessor$ReplaySubscription[] replayProcessor$ReplaySubscriptionArray = g;
        for (Serializable serializable2 : ((AtomicReference)serializable).getAndSet(replayProcessor$ReplaySubscriptionArray)) {
            object.a((ReplayProcessor$ReplaySubscription)serializable2);
        }
    }

    public void onNext(Object replayProcessor$ReplaySubscriptionArray) {
        Object object = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(replayProcessor$ReplaySubscriptionArray, (String)object);
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        object = this.b;
        object.next(replayProcessor$ReplaySubscriptionArray);
        for (ReplayProcessor$ReplaySubscription replayProcessor$ReplaySubscription : (ReplayProcessor$ReplaySubscription[])this.d.get()) {
            object.a(replayProcessor$ReplaySubscription);
        }
    }

    public void onSubscribe(e e10) {
        boolean bl2 = this.c;
        if (bl2) {
            e10.cancel();
            return;
        }
        e10.request(Long.MAX_VALUE);
    }
}

