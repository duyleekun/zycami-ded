/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.j;
import e.a.o;
import e.a.v0.g;
import e.a.w0.c.h;
import e.a.w0.e.b.s0;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowablePublish$PublishSubscriber;
import io.reactivex.internal.operators.flowable.FlowablePublish$a;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublish
extends e.a.u0.a
implements h,
s0 {
    public static final long f = Long.MIN_VALUE;
    public final j b;
    public final AtomicReference c;
    public final int d;
    public final c e;

    private FlowablePublish(c c10, j j10, AtomicReference atomicReference, int n10) {
        this.e = c10;
        this.b = j10;
        this.c = atomicReference;
        this.d = n10;
    }

    public static e.a.u0.a W8(j j10, int n10) {
        AtomicReference atomicReference = new AtomicReference();
        FlowablePublish$a flowablePublish$a = new FlowablePublish$a(atomicReference, n10);
        FlowablePublish flowablePublish = new FlowablePublish(flowablePublish$a, j10, atomicReference, n10);
        return e.a.a1.a.T(flowablePublish);
    }

    public void O8(g object) {
        Serializable serializable;
        int n10;
        AtomicReference atomicReference;
        boolean bl2;
        Serializable serializable2;
        while ((serializable2 = (FlowablePublish$PublishSubscriber)this.c.get()) == null || (bl2 = serializable2.isDisposed())) {
            atomicReference = this.c;
            atomicReference = this.c;
            n10 = this.d;
            serializable = new FlowablePublish$PublishSubscriber(atomicReference, n10);
            boolean bl3 = atomicReference.compareAndSet(serializable2, serializable);
            if (!bl3) continue;
            serializable2 = serializable;
            break;
        }
        serializable = serializable2.shouldConnect;
        bl2 = ((AtomicBoolean)serializable).get();
        boolean bl4 = true;
        n10 = 0;
        if (bl2 || !(bl2 = ((AtomicBoolean)(serializable = serializable2.shouldConnect)).compareAndSet(false, bl4))) {
            bl4 = false;
            atomicReference = null;
        }
        try {
            object.accept(serializable2);
            if (bl4) {
                object = this.b;
                ((j)object).l6((o)((Object)serializable2));
            }
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
    }

    public c g() {
        return this.b;
    }

    public int k() {
        return this.d;
    }

    public void m6(d d10) {
        this.e.subscribe(d10);
    }

    public c source() {
        return this.b;
    }
}

