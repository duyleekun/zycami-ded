/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.l;
import e.a.m;
import e.a.t0.a;
import i.g.d;
import i.g.e;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter;
import io.reactivex.internal.operators.flowable.FlowableCreate$BufferAsyncEmitter;
import io.reactivex.internal.operators.flowable.FlowableCreate$DropAsyncEmitter;
import io.reactivex.internal.operators.flowable.FlowableCreate$ErrorAsyncEmitter;
import io.reactivex.internal.operators.flowable.FlowableCreate$LatestAsyncEmitter;
import io.reactivex.internal.operators.flowable.FlowableCreate$MissingEmitter;
import io.reactivex.internal.operators.flowable.FlowableCreate$a;

public final class FlowableCreate
extends j {
    public final m b;
    public final BackpressureStrategy c;

    public FlowableCreate(m m10, BackpressureStrategy backpressureStrategy) {
        this.b = m10;
        this.c = backpressureStrategy;
    }

    public void m6(d object) {
        Object object2 = FlowableCreate$a.a;
        BackpressureStrategy backpressureStrategy = this.c;
        int n10 = backpressureStrategy.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 4;
                    if (n11 != n10) {
                        n10 = j.f0();
                        object2 = new FlowableCreate$BufferAsyncEmitter((d)object, n10);
                    } else {
                        object2 = new FlowableCreate$LatestAsyncEmitter((d)object);
                    }
                } else {
                    object2 = new FlowableCreate$DropAsyncEmitter;
                    object2 = new FlowableCreate$DropAsyncEmitter((d)object);
                }
            } else {
                object2 = new FlowableCreate$ErrorAsyncEmitter;
                object2 = new FlowableCreate$ErrorAsyncEmitter((d)object);
            }
        } else {
            object2 = new FlowableCreate$MissingEmitter;
            object2 = new FlowableCreate$MissingEmitter((d)object);
        }
        object.onSubscribe((e)object2);
        object = this.b;
        try {
            object.subscribe((l)object2);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            ((FlowableCreate$BaseEmitter)object2).onError(throwable);
        }
    }
}

