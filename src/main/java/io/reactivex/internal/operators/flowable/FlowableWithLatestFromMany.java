/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.p0;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestFromSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$a;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Arrays;
import java.util.Iterator;

public final class FlowableWithLatestFromMany
extends a {
    public final c[] c;
    public final Iterable d;
    public final o e;

    public FlowableWithLatestFromMany(j j10, Iterable iterable, o o10) {
        super(j10);
        this.c = null;
        this.d = iterable;
        this.e = o10;
    }

    public FlowableWithLatestFromMany(j j10, c[] cArray, o o10) {
        super(j10);
        this.c = cArray;
        this.d = null;
        this.e = o10;
    }

    public void m6(d d10) {
        Object object;
        FlowableWithLatestFromMany$a flowableWithLatestFromMany$a;
        int n10;
        Iterator iterator2;
        Object object2;
        block13: {
            object2 = this.c;
            if (object2 == null) {
                int n11 = 8;
                object2 = new c[n11];
                iterator2 = this.d;
                try {
                    iterator2 = iterator2.iterator();
                    n10 = 0;
                    flowableWithLatestFromMany$a = null;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    EmptySubscription.error(throwable, d10);
                    return;
                }
                while (true) {
                    boolean bl2 = iterator2.hasNext();
                    if (!bl2) break block13;
                    break;
                }
                {
                    int n12;
                    block14: {
                        object = iterator2.next();
                        object = (c)object;
                        n12 = ((Object)object2).length;
                        if (n10 != n12) break block14;
                        n12 = (n10 >> 1) + n10;
                        object2 = Arrays.copyOf(object2, n12);
                        object2 = (c[])object2;
                    }
                    n12 = n10 + 1;
                    object2[n10] = object;
                    n10 = n12;
                    continue;
                }
            }
            n10 = ((c[])object2).length;
        }
        if (n10 == 0) {
            iterator2 = this.b;
            flowableWithLatestFromMany$a = new FlowableWithLatestFromMany$a(this);
            object2 = new p0((j)((Object)iterator2), flowableWithLatestFromMany$a);
            ((p0)object2).m6(d10);
            return;
        }
        object = this.e;
        iterator2 = new Iterator(d10, (o)object, n10);
        d10.onSubscribe((e)((Object)iterator2));
        ((FlowableWithLatestFromMany$WithLatestFromSubscriber)((Object)iterator2)).subscribe((c[])object2, n10);
        this.b.l6((e.a.o)((Object)iterator2));
    }
}

