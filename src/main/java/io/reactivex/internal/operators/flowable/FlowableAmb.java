/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.t0.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableAmb$a;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class FlowableAmb
extends j {
    public final c[] b;
    public final Iterable c;

    public FlowableAmb(c[] cArray, Iterable iterable) {
        this.b = cArray;
        this.c = iterable;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d d10) {
        void var2_8;
        int n10;
        c[] cArray = this.b;
        Object object = null;
        if (cArray == null) {
            int n11 = 8;
            c[] cArray2 = new c[n11];
            try {
                boolean bl2;
                Object object2 = this.c;
                object2 = object2.iterator();
                n10 = 0;
                while (bl2 = object2.hasNext()) {
                    void var2_4;
                    Object e10 = object2.next();
                    c c10 = (c)e10;
                    if (c10 == null) {
                        object = "One of the sources is null";
                        NullPointerException nullPointerException = new NullPointerException((String)object);
                        EmptySubscription.error(nullPointerException, d10);
                        return;
                    }
                    int n12 = ((void)var2_4).length;
                    if (n10 == n12) {
                        n12 = (n10 >> 2) + n10;
                        c[] cArray3 = new c[n12];
                        System.arraycopy(var2_4, 0, cArray3, 0, n10);
                        c[] cArray4 = cArray3;
                    }
                    n12 = n10 + 1;
                    var2_4[n10] = c10;
                    n10 = n12;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return;
            }
        } else {
            n10 = cArray.length;
        }
        if (n10 == 0) {
            EmptySubscription.complete(d10);
            return;
        }
        int n13 = 1;
        if (n10 == n13) {
            var2_8[0].subscribe(d10);
            return;
        }
        object = new FlowableAmb$a(d10, n10);
        ((FlowableAmb$a)object).a((c[])var2_8);
    }
}

