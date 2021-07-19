/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.b1.a;
import i.g.d;
import i.g.e;
import io.reactivex.processors.PublishProcessor$PublishSubscription;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

public final class PublishProcessor
extends a {
    public static final PublishProcessor$PublishSubscription[] d = new PublishProcessor$PublishSubscription[0];
    public static final PublishProcessor$PublishSubscription[] e = new PublishProcessor$PublishSubscription[0];
    public final AtomicReference b;
    public Throwable c;

    public PublishProcessor() {
        AtomicReference<PublishProcessor$PublishSubscription[]> atomicReference;
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray = e;
        this.b = atomicReference = new AtomicReference<PublishProcessor$PublishSubscription[]>(publishProcessor$PublishSubscriptionArray);
    }

    public static PublishProcessor Q8() {
        PublishProcessor publishProcessor = new PublishProcessor();
        return publishProcessor;
    }

    public Throwable K8() {
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        Object v10 = this.b.get();
        if (v10 == (publishProcessor$PublishSubscriptionArray = d)) {
            return this.c;
        }
        return null;
    }

    public boolean L8() {
        boolean bl2;
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        Object object = this.b.get();
        if (object == (publishProcessor$PublishSubscriptionArray = d) && (object = this.c) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean M8() {
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray = (PublishProcessor$PublishSubscription[])this.b.get();
        boolean bl2 = publishProcessor$PublishSubscriptionArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            publishProcessor$PublishSubscriptionArray = null;
        }
        return bl2;
    }

    public boolean N8() {
        boolean bl2;
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        Object object = this.b.get();
        if (object == (publishProcessor$PublishSubscriptionArray = d) && (object = this.c) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean P8(PublishProcessor$PublishSubscription publishProcessor$PublishSubscription) {
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray2;
        Object object;
        boolean bl2;
        do {
            if ((publishProcessor$PublishSubscriptionArray2 = (PublishProcessor$PublishSubscription[])this.b.get()) == (object = d)) {
                return false;
            }
            int n10 = publishProcessor$PublishSubscriptionArray2.length;
            int n11 = n10 + 1;
            publishProcessor$PublishSubscriptionArray = new PublishProcessor$PublishSubscription[n11];
            System.arraycopy(publishProcessor$PublishSubscriptionArray2, 0, publishProcessor$PublishSubscriptionArray, 0, n10);
            publishProcessor$PublishSubscriptionArray[n10] = publishProcessor$PublishSubscription;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(publishProcessor$PublishSubscriptionArray2, publishProcessor$PublishSubscriptionArray)));
        return true;
    }

    public boolean R8(Object object) {
        boolean bl2 = true;
        if (object == null) {
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.onError((Throwable)object);
            return bl2;
        }
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray = (PublishProcessor$PublishSubscription[])this.b.get();
        int n10 = publishProcessor$PublishSubscriptionArray.length;
        int n11 = 0;
        PublishProcessor$PublishSubscription publishProcessor$PublishSubscription = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            PublishProcessor$PublishSubscription publishProcessor$PublishSubscription2 = publishProcessor$PublishSubscriptionArray[i10];
            boolean bl3 = publishProcessor$PublishSubscription2.isFull();
            if (!bl3) continue;
            return false;
        }
        n10 = publishProcessor$PublishSubscriptionArray.length;
        while (n11 < n10) {
            publishProcessor$PublishSubscription = publishProcessor$PublishSubscriptionArray[n11];
            publishProcessor$PublishSubscription.onNext(object);
            ++n11;
        }
        return bl2;
    }

    public void S8(PublishProcessor$PublishSubscription publishProcessor$PublishSubscription) {
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray2;
        while ((publishProcessor$PublishSubscriptionArray2 = (PublishProcessor$PublishSubscription[])this.b.get()) != (publishProcessor$PublishSubscriptionArray = d) && publishProcessor$PublishSubscriptionArray2 != (publishProcessor$PublishSubscriptionArray = e)) {
            AtomicReference atomicReference;
            boolean bl2;
            PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray3;
            int n10;
            int n11 = publishProcessor$PublishSubscriptionArray2.length;
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                publishProcessor$PublishSubscriptionArray3 = publishProcessor$PublishSubscriptionArray2[n10];
                if (publishProcessor$PublishSubscriptionArray3 != publishProcessor$PublishSubscription) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                publishProcessor$PublishSubscriptionArray = e;
            } else {
                int n14 = n11 + -1;
                publishProcessor$PublishSubscriptionArray3 = new PublishProcessor$PublishSubscription[n14];
                System.arraycopy(publishProcessor$PublishSubscriptionArray2, 0, publishProcessor$PublishSubscriptionArray3, 0, n12);
                n13 = n12 + 1;
                n11 = n11 - n12 - n10;
                System.arraycopy(publishProcessor$PublishSubscriptionArray2, n13, publishProcessor$PublishSubscriptionArray3, n12, n11);
                publishProcessor$PublishSubscriptionArray = publishProcessor$PublishSubscriptionArray3;
            }
            if (!(bl2 = (atomicReference = this.b).compareAndSet(publishProcessor$PublishSubscriptionArray2, publishProcessor$PublishSubscriptionArray))) continue;
        }
    }

    public void m6(d d10) {
        Serializable serializable = new PublishProcessor$PublishSubscription(d10, this);
        d10.onSubscribe((e)((Object)serializable));
        boolean bl2 = this.P8((PublishProcessor$PublishSubscription)serializable);
        if (bl2) {
            boolean bl3 = serializable.isCancelled();
            if (bl3) {
                this.S8((PublishProcessor$PublishSubscription)serializable);
            }
        } else {
            serializable = this.c;
            if (serializable != null) {
                d10.onError((Throwable)serializable);
            } else {
                d10.onComplete();
            }
        }
    }

    public void onComplete() {
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        Object object = this.b.get();
        if (object == (publishProcessor$PublishSubscriptionArray = d)) {
            return;
        }
        for (PublishProcessor$PublishSubscription publishProcessor$PublishSubscription : this.b.getAndSet(publishProcessor$PublishSubscriptionArray)) {
            publishProcessor$PublishSubscription.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object object = this.b.get();
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray = d;
        if (object == publishProcessor$PublishSubscriptionArray) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = throwable;
        for (PublishProcessor$PublishSubscription publishProcessor$PublishSubscription : this.b.getAndSet(publishProcessor$PublishSubscriptionArray)) {
            publishProcessor$PublishSubscription.onError(throwable);
        }
    }

    public void onNext(Object object) {
        e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishProcessor$PublishSubscription publishProcessor$PublishSubscription : (PublishProcessor$PublishSubscription[])this.b.get()) {
            publishProcessor$PublishSubscription.onNext(object);
        }
    }

    public void onSubscribe(e e10) {
        PublishProcessor$PublishSubscription[] publishProcessor$PublishSubscriptionArray;
        Object v10 = this.b.get();
        if (v10 == (publishProcessor$PublishSubscriptionArray = d)) {
            e10.cancel();
            return;
        }
        e10.request(Long.MAX_VALUE);
    }
}

