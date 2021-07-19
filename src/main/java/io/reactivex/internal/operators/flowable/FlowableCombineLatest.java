/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.c.l;
import e.a.w0.e.b.p0$b;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestCoordinator;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest$a;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;

public final class FlowableCombineLatest
extends j {
    public final c[] b;
    public final Iterable c;
    public final o d;
    public final int e;
    public final boolean f;

    public FlowableCombineLatest(Iterable iterable, o o10, int n10, boolean bl2) {
        this.b = null;
        this.c = iterable;
        this.d = o10;
        this.e = n10;
        this.f = bl2;
    }

    public FlowableCombineLatest(c[] cArray, o o10, int n10, boolean bl2) {
        this.b = cArray;
        this.c = null;
        this.d = o10;
        this.e = n10;
        this.f = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d d10) {
        int n10;
        Object object;
        int n11;
        Object object2;
        Object object3;
        l l10;
        Object object4;
        block12: {
            object4 = this.b;
            l10 = null;
            if (object4 == null) {
                int n12 = 8;
                object4 = new c[n12];
                try {
                    object3 = this.c;
                    object3 = object3.iterator();
                    object2 = "The iterator returned is null";
                    object3 = e.a.w0.b.a.g(object3, (String)object2);
                    object3 = (Iterator)object3;
                    n11 = 0;
                    object2 = null;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptySubscription.error(throwable, d10);
                    return;
                }
                while (true) {
                    c[] cArray;
                    block11: {
                        try {
                            boolean bl2 = object3.hasNext();
                            if (bl2) break block11;
                            break block12;
                        }
                        catch (Throwable throwable) {
                            e.a.t0.a.b(throwable);
                            EmptySubscription.error(throwable, d10);
                            return;
                        }
                    }
                    try {
                        object = object3.next();
                        cArray = "The publisher returned by the iterator is null";
                        object = e.a.w0.b.a.g(object, (String)cArray);
                        object = (c)object;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        EmptySubscription.error(throwable, d10);
                        return;
                    }
                    n10 = ((Object)object4).length;
                    if (n11 == n10) {
                        n10 = (n11 >> 2) + n11;
                        cArray = new c[n10];
                        System.arraycopy(object4, 0, cArray, 0, n11);
                        object4 = cArray;
                    }
                    n10 = n11 + 1;
                    object4[n11] = object;
                    n11 = n10;
                }
            }
            n11 = ((c[])object4).length;
        }
        if (n11 == 0) {
            EmptySubscription.complete(d10);
            return;
        }
        int n13 = 1;
        if (n11 == n13) {
            object4 = object4[0];
            object3 = new FlowableCombineLatest$a(this);
            l10 = new p0$b(d10, (o)object3);
            object4.subscribe((d)((Object)l10));
            return;
        }
        object = this.d;
        int n14 = this.e;
        boolean bl3 = this.f;
        object3 = l10;
        object2 = d10;
        n10 = n11;
        l10 = new FlowableCombineLatest$CombineLatestCoordinator(d10, (o)object, n11, n14, bl3);
        d10.onSubscribe(l10);
        ((FlowableCombineLatest$CombineLatestCoordinator)l10).subscribe((c[])object4, n11);
    }
}

