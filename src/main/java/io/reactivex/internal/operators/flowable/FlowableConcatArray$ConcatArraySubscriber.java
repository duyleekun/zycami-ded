/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableConcatArray$ConcatArraySubscriber
extends SubscriptionArbiter
implements o {
    private static final long serialVersionUID = -8158322871608889516L;
    public final boolean delayError;
    public final d downstream;
    public List errors;
    public int index;
    public long produced;
    public final c[] sources;
    public final AtomicInteger wip;

    public FlowableConcatArray$ConcatArraySubscriber(c[] object, boolean bl2, d d10) {
        super(false);
        this.downstream = d10;
        this.sources = object;
        this.delayError = bl2;
        super();
        this.wip = object;
    }

    public void onComplete() {
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            object = this.sources;
            int n11 = ((c[])object).length;
            int n12 = this.index;
            while (true) {
                int n13 = 1;
                if (n12 == n11) {
                    object = this.errors;
                    if (object != null) {
                        n11 = object.size();
                        if (n11 == n13) {
                            d d10 = this.downstream;
                            n12 = 0;
                            Object var7_15 = null;
                            object = (Throwable)object.get(0);
                            d10.onError((Throwable)object);
                        } else {
                            d d11 = this.downstream;
                            CompositeException compositeException = new CompositeException((Iterable)object);
                            d11.onError(compositeException);
                        }
                    } else {
                        object = this.downstream;
                        object.onComplete();
                    }
                    return;
                }
                Object object2 = object[n12];
                if (object2 == null) {
                    List<Object> list = "A Publisher entry is null";
                    object2 = new NullPointerException((String)((Object)list));
                    boolean bl2 = this.delayError;
                    if (bl2) {
                        list = this.errors;
                        if (list == null) {
                            int n14 = n11 - n12 + n13;
                            this.errors = list = new List<Object>(n14);
                        }
                        list.add(object2);
                        ++n12;
                        continue;
                    }
                    this.downstream.onError((Throwable)object2);
                    return;
                }
                long l10 = this.produced;
                long l11 = 0L;
                long l12 = l10 - l11;
                n13 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n13 != 0) {
                    this.produced = l11;
                    this.produced(l10);
                }
                object2.subscribe(this);
                this.index = ++n12;
                AtomicInteger atomicInteger = this.wip;
                n13 = atomicInteger.decrementAndGet();
                if (n13 == 0) break;
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.delayError;
        if (bl2) {
            ArrayList<Throwable> arrayList = this.errors;
            if (arrayList == null) {
                c[] cArray = this.sources;
                int n10 = cArray.length;
                int n11 = this.index;
                n10 = n10 - n11 + 1;
                this.errors = arrayList = new ArrayList<Throwable>(n10);
            }
            arrayList.add(throwable);
            this.onComplete();
        } else {
            d d10 = this.downstream;
            d10.onError(throwable);
        }
    }

    public void onNext(Object object) {
        long l10;
        this.produced = l10 = this.produced + 1L;
        this.downstream.onNext(object);
    }

    public void onSubscribe(e e10) {
        this.setSubscription(e10);
    }
}

