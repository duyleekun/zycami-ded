/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableZip$ZipCoordinator;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class FlowableZip
extends j {
    public final c[] b;
    public final Iterable c;
    public final o d;
    public final int e;
    public final boolean f;

    public FlowableZip(c[] cArray, Iterable iterable, o o10, int n10, boolean bl2) {
        this.b = cArray;
        this.c = iterable;
        this.d = o10;
        this.e = n10;
        this.f = bl2;
    }

    public void m6(d d10) {
        FlowableZip$ZipCoordinator flowableZip$ZipCoordinator;
        int n10;
        int n11;
        o o10;
        int n12;
        Object object;
        c[] cArray = this.b;
        if (cArray == null) {
            int n13 = 8;
            cArray = new c[n13];
            object = this.c.iterator();
            n12 = 0;
            o10 = null;
            while ((n11 = object.hasNext()) != 0) {
                c c10 = (c)object.next();
                n10 = cArray.length;
                if (n12 == n10) {
                    n10 = (n12 >> 2) + n12;
                    c[] cArray2 = new c[n10];
                    System.arraycopy(cArray, 0, cArray2, 0, n12);
                    cArray = cArray2;
                }
                n10 = n12 + 1;
                cArray[n12] = c10;
                n12 = n10;
            }
        } else {
            n12 = cArray.length;
        }
        if (n12 == 0) {
            EmptySubscription.complete(d10);
            return;
        }
        o10 = this.d;
        n10 = this.e;
        boolean bl2 = this.f;
        object = flowableZip$ZipCoordinator;
        n11 = n12;
        flowableZip$ZipCoordinator = new FlowableZip$ZipCoordinator(d10, o10, n12, n10, bl2);
        d10.onSubscribe(flowableZip$ZipCoordinator);
        flowableZip$ZipCoordinator.subscribe(cArray, n12);
    }
}

