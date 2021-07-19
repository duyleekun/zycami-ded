/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.b1.a;
import i.g.d;
import i.g.e;
import io.reactivex.processors.AsyncProcessor$AsyncSubscription;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncProcessor
extends a {
    public static final AsyncProcessor$AsyncSubscription[] e = new AsyncProcessor$AsyncSubscription[0];
    public static final AsyncProcessor$AsyncSubscription[] f = new AsyncProcessor$AsyncSubscription[0];
    public final AtomicReference b;
    public Throwable c;
    public Object d;

    public AsyncProcessor() {
        AtomicReference<AsyncProcessor$AsyncSubscription[]> atomicReference;
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray = e;
        this.b = atomicReference = new AtomicReference<AsyncProcessor$AsyncSubscription[]>(asyncSubscriptionArray);
    }

    public static AsyncProcessor Q8() {
        AsyncProcessor asyncProcessor = new AsyncProcessor();
        return asyncProcessor;
    }

    public Throwable K8() {
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        Object object = this.b.get();
        object = object == (asyncSubscriptionArray = f) ? this.c : null;
        return object;
    }

    public boolean L8() {
        boolean bl2;
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        Object object = this.b.get();
        if (object == (asyncSubscriptionArray = f) && (object = this.c) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean M8() {
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray = (AsyncProcessor$AsyncSubscription[])this.b.get();
        boolean bl2 = asyncSubscriptionArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            asyncSubscriptionArray = null;
        }
        return bl2;
    }

    public boolean N8() {
        boolean bl2;
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        Object object = this.b.get();
        if (object == (asyncSubscriptionArray = f) && (object = this.c) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean P8(AsyncProcessor$AsyncSubscription asyncSubscription) {
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((asyncSubscriptionArray2 = (AsyncProcessor$AsyncSubscription[])this.b.get()) == (object = f)) {
                return false;
            }
            int n10 = asyncSubscriptionArray2.length;
            int n11 = n10 + 1;
            asyncSubscriptionArray = new AsyncProcessor$AsyncSubscription[n11];
            System.arraycopy(asyncSubscriptionArray2, 0, asyncSubscriptionArray, 0, n10);
            asyncSubscriptionArray[n10] = asyncSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(asyncSubscriptionArray2, asyncSubscriptionArray)));
        return true;
    }

    public Object R8() {
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        Object object = this.b.get();
        object = object == (asyncSubscriptionArray = f) ? this.d : null;
        return object;
    }

    public Object[] S8() {
        Object[] objectArray;
        Object object = this.R8();
        if (object != null) {
            int n10 = 1;
            objectArray = new Object[n10];
            objectArray[0] = object;
        } else {
            objectArray = new Object[]{};
        }
        return objectArray;
    }

    public Object[] T8(Object[] objectArray) {
        Object object = this.R8();
        if (object == null) {
            int n10 = objectArray.length;
            if (n10 != 0) {
                objectArray[0] = null;
            }
            return objectArray;
        }
        int n11 = objectArray.length;
        int n12 = 1;
        if (n11 == 0) {
            objectArray = Arrays.copyOf(objectArray, n12);
        }
        objectArray[0] = object;
        int n13 = objectArray.length;
        if (n13 != n12) {
            objectArray[n12] = null;
        }
        return objectArray;
    }

    public boolean U8() {
        boolean bl2;
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        Object object = this.b.get();
        if (object == (asyncSubscriptionArray = f) && (object = this.d) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void V8(AsyncProcessor$AsyncSubscription asyncSubscription) {
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray;
        AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            AsyncProcessor$AsyncSubscription[] asyncSubscriptionArray3;
            int n10;
            int n11;
            if ((n11 = (asyncSubscriptionArray2 = (AsyncProcessor$AsyncSubscription[])this.b.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                asyncSubscriptionArray3 = asyncSubscriptionArray2[n10];
                if (asyncSubscriptionArray3 != asyncSubscription) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                asyncSubscriptionArray = e;
                continue;
            }
            int n14 = n11 + -1;
            asyncSubscriptionArray3 = new AsyncProcessor$AsyncSubscription[n14];
            System.arraycopy(asyncSubscriptionArray2, 0, asyncSubscriptionArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(asyncSubscriptionArray2, n13, asyncSubscriptionArray3, n12, n11);
            asyncSubscriptionArray = asyncSubscriptionArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(asyncSubscriptionArray2, asyncSubscriptionArray)));
    }

    public void m6(d object) {
        AsyncProcessor$AsyncSubscription asyncProcessor$AsyncSubscription = new AsyncProcessor$AsyncSubscription((d)object, this);
        object.onSubscribe(asyncProcessor$AsyncSubscription);
        boolean bl2 = this.P8(asyncProcessor$AsyncSubscription);
        if (bl2) {
            boolean bl3 = asyncProcessor$AsyncSubscription.isCancelled();
            if (bl3) {
                this.V8(asyncProcessor$AsyncSubscription);
            }
        } else {
            Throwable throwable = this.c;
            if (throwable != null) {
                object.onError(throwable);
            } else {
                object = this.d;
                if (object != null) {
                    asyncProcessor$AsyncSubscription.complete(object);
                } else {
                    asyncProcessor$AsyncSubscription.onComplete();
                }
            }
        }
    }

    public void onComplete() {
        AsyncProcessor$AsyncSubscription[] asyncProcessor$AsyncSubscriptionArray;
        Object object = this.b.get();
        if (object == (asyncProcessor$AsyncSubscriptionArray = f)) {
            return;
        }
        object = this.d;
        asyncProcessor$AsyncSubscriptionArray = this.b.getAndSet(asyncProcessor$AsyncSubscriptionArray);
        if (object == null) {
            for (AsyncProcessor$AsyncSubscription asyncProcessor$AsyncSubscription : asyncProcessor$AsyncSubscriptionArray) {
                asyncProcessor$AsyncSubscription.onComplete();
            }
        } else {
            int n10;
            int n11 = asyncProcessor$AsyncSubscriptionArray.length;
            while (n10 < n11) {
                AsyncProcessor$AsyncSubscription asyncProcessor$AsyncSubscription = asyncProcessor$AsyncSubscriptionArray[n10];
                asyncProcessor$AsyncSubscription.complete(object);
                ++n10;
            }
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object object = this.b.get();
        AsyncProcessor$AsyncSubscription[] asyncProcessor$AsyncSubscriptionArray = f;
        if (object == asyncProcessor$AsyncSubscriptionArray) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = null;
        this.c = throwable;
        for (AsyncProcessor$AsyncSubscription asyncProcessor$AsyncSubscription : this.b.getAndSet(asyncProcessor$AsyncSubscriptionArray)) {
            asyncProcessor$AsyncSubscription.onError(throwable);
        }
    }

    public void onNext(Object object) {
        e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object v10 = this.b.get();
        AsyncProcessor$AsyncSubscription[] asyncProcessor$AsyncSubscriptionArray = f;
        if (v10 == asyncProcessor$AsyncSubscriptionArray) {
            return;
        }
        this.d = object;
    }

    public void onSubscribe(e e10) {
        AsyncProcessor$AsyncSubscription[] asyncProcessor$AsyncSubscriptionArray;
        Object v10 = this.b.get();
        if (v10 == (asyncProcessor$AsyncSubscriptionArray = f)) {
            e10.cancel();
            return;
        }
        e10.request(Long.MAX_VALUE);
    }
}

