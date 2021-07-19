/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.b1.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.BehaviorProcessor$BehaviorSubscription;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class BehaviorProcessor
extends a {
    public static final Object[] i = new Object[0];
    public static final BehaviorProcessor$BehaviorSubscription[] j = new BehaviorProcessor$BehaviorSubscription[0];
    public static final BehaviorProcessor$BehaviorSubscription[] k = new BehaviorProcessor$BehaviorSubscription[0];
    public final AtomicReference b;
    public final ReadWriteLock c;
    public final Lock d;
    public final Lock e;
    public final AtomicReference f;
    public final AtomicReference g;
    public long h;

    public BehaviorProcessor() {
        AtomicReference atomicReference = new AtomicReference();
        this.f = atomicReference;
        this.c = atomicReference;
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray = atomicReference.readLock();
        this.d = behaviorProcessor$BehaviorSubscriptionArray;
        atomicReference = atomicReference.writeLock();
        this.e = atomicReference;
        behaviorProcessor$BehaviorSubscriptionArray = j;
        this.b = atomicReference = new AtomicReference(behaviorProcessor$BehaviorSubscriptionArray);
        this.g = atomicReference = new AtomicReference();
    }

    public BehaviorProcessor(Object object) {
        this();
        AtomicReference atomicReference = this.f;
        object = e.a.w0.b.a.g(object, "defaultValue is null");
        atomicReference.lazySet(object);
    }

    public static BehaviorProcessor Q8() {
        BehaviorProcessor behaviorProcessor = new BehaviorProcessor();
        return behaviorProcessor;
    }

    public static BehaviorProcessor R8(Object object) {
        e.a.w0.b.a.g(object, "defaultValue is null");
        BehaviorProcessor behaviorProcessor = new BehaviorProcessor(object);
        return behaviorProcessor;
    }

    public Throwable K8() {
        Object v10 = this.f.get();
        boolean bl2 = NotificationLite.isError(v10);
        if (bl2) {
            return NotificationLite.getError(v10);
        }
        return null;
    }

    public boolean L8() {
        return NotificationLite.isComplete(this.f.get());
    }

    public boolean M8() {
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray = (BehaviorProcessor$BehaviorSubscription[])this.b.get();
        boolean bl2 = behaviorProcessor$BehaviorSubscriptionArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            behaviorProcessor$BehaviorSubscriptionArray = null;
        }
        return bl2;
    }

    public boolean N8() {
        return NotificationLite.isError(this.f.get());
    }

    public boolean P8(BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription) {
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray;
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((behaviorProcessor$BehaviorSubscriptionArray2 = (BehaviorProcessor$BehaviorSubscription[])this.b.get()) == (object = k)) {
                return false;
            }
            int n10 = behaviorProcessor$BehaviorSubscriptionArray2.length;
            int n11 = n10 + 1;
            behaviorProcessor$BehaviorSubscriptionArray = new BehaviorProcessor$BehaviorSubscription[n11];
            System.arraycopy(behaviorProcessor$BehaviorSubscriptionArray2, 0, behaviorProcessor$BehaviorSubscriptionArray, 0, n10);
            behaviorProcessor$BehaviorSubscriptionArray[n10] = behaviorProcessor$BehaviorSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(behaviorProcessor$BehaviorSubscriptionArray2, behaviorProcessor$BehaviorSubscriptionArray)));
        return true;
    }

    public Object S8() {
        Object v10 = this.f.get();
        boolean bl2 = NotificationLite.isComplete(v10);
        if (!bl2 && !(bl2 = NotificationLite.isError(v10))) {
            return NotificationLite.getValue(v10);
        }
        return null;
    }

    public Object[] T8() {
        Object[] objectArray = i;
        Object[] objectArray2 = this.U8(objectArray);
        if (objectArray2 == objectArray) {
            return new Object[0];
        }
        return objectArray2;
    }

    public Object[] U8(Object[] objectArray) {
        int n10;
        Object object = this.f.get();
        if (object != null && (n10 = NotificationLite.isComplete(object)) == 0 && (n10 = NotificationLite.isError(object)) == 0) {
            object = NotificationLite.getValue(object);
            n10 = objectArray.length;
            int n11 = 1;
            if (n10 != 0) {
                objectArray[0] = object;
                int n12 = objectArray.length;
                if (n12 != n11) {
                    objectArray[n11] = null;
                }
            } else {
                objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n11);
                objectArray[0] = object;
            }
            return objectArray;
        }
        int n13 = objectArray.length;
        if (n13 != 0) {
            objectArray[0] = null;
        }
        return objectArray;
    }

    public boolean V8() {
        boolean bl2;
        boolean bl3;
        Object v10 = this.f.get();
        if (v10 != null && !(bl3 = NotificationLite.isComplete(v10)) && !(bl2 = NotificationLite.isError(v10))) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public boolean W8(Object object) {
        boolean bl2 = true;
        if (object == null) {
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.onError((Throwable)object);
            return bl2;
        }
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray = (BehaviorProcessor$BehaviorSubscription[])this.b.get();
        int n10 = behaviorProcessor$BehaviorSubscriptionArray.length;
        int n11 = 0;
        BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription2 = behaviorProcessor$BehaviorSubscriptionArray[i10];
            boolean bl3 = behaviorProcessor$BehaviorSubscription2.isFull();
            if (!bl3) continue;
            return false;
        }
        object = NotificationLite.next(object);
        this.Y8(object);
        n10 = behaviorProcessor$BehaviorSubscriptionArray.length;
        while (n11 < n10) {
            behaviorProcessor$BehaviorSubscription = behaviorProcessor$BehaviorSubscriptionArray[n11];
            long l10 = this.h;
            behaviorProcessor$BehaviorSubscription.emitNext(object, l10);
            ++n11;
        }
        return bl2;
    }

    public void X8(BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription) {
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray;
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray3;
            int n10;
            int n11;
            if ((n11 = (behaviorProcessor$BehaviorSubscriptionArray2 = (BehaviorProcessor$BehaviorSubscription[])this.b.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                behaviorProcessor$BehaviorSubscriptionArray3 = behaviorProcessor$BehaviorSubscriptionArray2[n10];
                if (behaviorProcessor$BehaviorSubscriptionArray3 != behaviorProcessor$BehaviorSubscription) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                behaviorProcessor$BehaviorSubscriptionArray = j;
                continue;
            }
            int n14 = n11 + -1;
            behaviorProcessor$BehaviorSubscriptionArray3 = new BehaviorProcessor$BehaviorSubscription[n14];
            System.arraycopy(behaviorProcessor$BehaviorSubscriptionArray2, 0, behaviorProcessor$BehaviorSubscriptionArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(behaviorProcessor$BehaviorSubscriptionArray2, n13, behaviorProcessor$BehaviorSubscriptionArray3, n12, n11);
            behaviorProcessor$BehaviorSubscriptionArray = behaviorProcessor$BehaviorSubscriptionArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(behaviorProcessor$BehaviorSubscriptionArray2, behaviorProcessor$BehaviorSubscriptionArray)));
    }

    public void Y8(Object object) {
        long l10;
        Lock lock = this.e;
        lock.lock();
        this.h = l10 = this.h + 1L;
        this.f.lazySet(object);
        lock.unlock();
    }

    public int Z8() {
        return ((BehaviorProcessor$BehaviorSubscription[])this.b.get()).length;
    }

    public BehaviorProcessor$BehaviorSubscription[] a9(Object object) {
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray;
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray2 = (BehaviorProcessor$BehaviorSubscription[])this.b.get();
        if (behaviorProcessor$BehaviorSubscriptionArray2 != (behaviorProcessor$BehaviorSubscriptionArray = k) && (behaviorProcessor$BehaviorSubscriptionArray2 = this.b.getAndSet(behaviorProcessor$BehaviorSubscriptionArray)) != behaviorProcessor$BehaviorSubscriptionArray) {
            this.Y8(object);
        }
        return behaviorProcessor$BehaviorSubscriptionArray2;
    }

    public void m6(d d10) {
        Serializable serializable = new BehaviorProcessor$BehaviorSubscription(d10, this);
        d10.onSubscribe((e)((Object)serializable));
        boolean bl2 = this.P8((BehaviorProcessor$BehaviorSubscription)serializable);
        if (bl2) {
            boolean bl3 = ((BehaviorProcessor$BehaviorSubscription)serializable).cancelled;
            if (bl3) {
                this.X8((BehaviorProcessor$BehaviorSubscription)serializable);
            } else {
                ((BehaviorProcessor$BehaviorSubscription)serializable).emitFirst();
            }
        } else {
            Throwable throwable;
            serializable = (Throwable)this.g.get();
            if (serializable == (throwable = ExceptionHelper.a)) {
                d10.onComplete();
            } else {
                d10.onError((Throwable)serializable);
            }
        }
    }

    public void onComplete() {
        Object object = this.g;
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray = ExceptionHelper.a;
        int n10 = 0;
        boolean bl2 = ((AtomicReference)object).compareAndSet(null, behaviorProcessor$BehaviorSubscriptionArray);
        if (!bl2) {
            return;
        }
        object = NotificationLite.complete();
        for (BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription : this.a9(object)) {
            long l10 = this.h;
            behaviorProcessor$BehaviorSubscription.emitNext(object, l10);
        }
    }

    public void onError(Throwable object) {
        e.a.w0.b.a.g(object, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        BehaviorProcessor$BehaviorSubscription[] behaviorProcessor$BehaviorSubscriptionArray = this.g;
        int n10 = 0;
        boolean bl2 = behaviorProcessor$BehaviorSubscriptionArray.compareAndSet(null, object);
        if (!bl2) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        object = NotificationLite.error((Throwable)object);
        for (BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription : this.a9(object)) {
            long l10 = this.h;
            behaviorProcessor$BehaviorSubscription.emitNext(object, l10);
        }
    }

    public void onNext(Object object) {
        e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object object2 = this.g.get();
        if (object2 != null) {
            return;
        }
        object = NotificationLite.next(object);
        this.Y8(object);
        for (BehaviorProcessor$BehaviorSubscription behaviorProcessor$BehaviorSubscription : (BehaviorProcessor$BehaviorSubscription[])this.b.get()) {
            long l10 = this.h;
            behaviorProcessor$BehaviorSubscription.emitNext(object, l10);
        }
    }

    public void onSubscribe(e e10) {
        Object v10 = this.g.get();
        if (v10 != null) {
            e10.cancel();
            return;
        }
        e10.request(Long.MAX_VALUE);
    }
}

