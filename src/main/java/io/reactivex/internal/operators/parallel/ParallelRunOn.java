/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.h0;
import e.a.h0$c;
import e.a.w0.g.i;
import e.a.z0.a;
import i.g.d;
import io.reactivex.internal.operators.parallel.ParallelRunOn$RunOnConditionalSubscriber;
import io.reactivex.internal.operators.parallel.ParallelRunOn$RunOnSubscriber;
import io.reactivex.internal.operators.parallel.ParallelRunOn$a;
import io.reactivex.internal.queue.SpscArrayQueue;

public final class ParallelRunOn
extends a {
    public final a a;
    public final h0 b;
    public final int c;

    public ParallelRunOn(a a10, h0 h02, int n10) {
        this.a = a10;
        this.b = h02;
        this.c = n10;
    }

    public int G() {
        return this.a.G();
    }

    public void V(int n10, d[] object, d[] dArray, h0$c h0$c) {
        object = object[n10];
        int n11 = this.c;
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(n11);
        n11 = object instanceof e.a.w0.c.a;
        if (n11 != 0) {
            object = (e.a.w0.c.a)object;
            int n12 = this.c;
            ParallelRunOn$RunOnConditionalSubscriber parallelRunOn$RunOnConditionalSubscriber = new ParallelRunOn$RunOnConditionalSubscriber((e.a.w0.c.a)object, n12, spscArrayQueue, h0$c);
            dArray[n10] = parallelRunOn$RunOnConditionalSubscriber;
        } else {
            int n13 = this.c;
            ParallelRunOn$RunOnSubscriber parallelRunOn$RunOnSubscriber = new ParallelRunOn$RunOnSubscriber((d)object, n13, spscArrayQueue, h0$c);
            dArray[n10] = parallelRunOn$RunOnSubscriber;
        }
    }

    public void a(d[] dArray) {
        int n10 = this.U(dArray);
        if (n10 == 0) {
            return;
        }
        n10 = dArray.length;
        d[] dArray2 = new d[n10];
        Object object = this.b;
        boolean bl2 = object instanceof i;
        if (bl2) {
            object = (i)object;
            ParallelRunOn$a parallelRunOn$a = new ParallelRunOn$a(this, dArray, dArray2);
            object.a(n10, parallelRunOn$a);
        } else {
            object = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                h0$c h0$c = this.b.c();
                this.V(i10, dArray, dArray2, h0$c);
            }
        }
        this.a.a(dArray2);
    }
}

