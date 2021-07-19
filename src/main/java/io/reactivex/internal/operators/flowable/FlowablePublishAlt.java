/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import e.a.u0.a;
import e.a.v0.g;
import e.a.w0.c.h;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt$InnerSubscription;
import io.reactivex.internal.operators.flowable.FlowablePublishAlt$PublishConnection;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowablePublishAlt
extends a
implements h,
e.a.w0.a.c {
    public final c b;
    public final int c;
    public final AtomicReference d;

    public FlowablePublishAlt(c atomicReference, int n10) {
        this.b = atomicReference;
        this.c = n10;
        this.d = atomicReference = new AtomicReference();
    }

    public void O8(g object) {
        Serializable serializable;
        int n10;
        AtomicReference atomicReference;
        boolean bl2;
        Serializable serializable2;
        while ((serializable2 = (FlowablePublishAlt$PublishConnection)this.d.get()) == null || (bl2 = serializable2.isDisposed())) {
            atomicReference = this.d;
            atomicReference = this.d;
            n10 = this.c;
            serializable = new FlowablePublishAlt$PublishConnection(atomicReference, n10);
            boolean bl3 = atomicReference.compareAndSet(serializable2, serializable);
            if (!bl3) continue;
            serializable2 = serializable;
            break;
        }
        serializable = serializable2.connect;
        bl2 = ((AtomicBoolean)serializable).get();
        boolean bl4 = true;
        n10 = 0;
        if (bl2 || !(bl2 = ((AtomicBoolean)(serializable = serializable2.connect)).compareAndSet(false, bl4))) {
            bl4 = false;
            atomicReference = null;
        }
        try {
            object.accept(serializable2);
            if (bl4) {
                object = this.b;
                object.subscribe((d)((Object)serializable2));
            }
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
    }

    public int k() {
        return this.c;
    }

    public void m(b b10) {
        AtomicReference atomicReference = this.d;
        b10 = (FlowablePublishAlt$PublishConnection)b10;
        atomicReference.compareAndSet(b10, null);
    }

    public void m6(d d10) {
        Number number;
        Serializable serializable;
        while ((serializable = (FlowablePublishAlt$PublishConnection)this.d.get()) == null) {
            AtomicReference atomicReference = this.d;
            atomicReference = this.d;
            int n10 = this.c;
            number = new FlowablePublishAlt$PublishConnection(atomicReference, n10);
            boolean bl2 = atomicReference.compareAndSet(serializable, number);
            if (!bl2) continue;
            serializable = number;
            break;
        }
        number = new FlowablePublishAlt$InnerSubscription(d10, (FlowablePublishAlt$PublishConnection)serializable);
        d10.onSubscribe((e)((Object)number));
        boolean bl3 = ((FlowablePublishAlt$PublishConnection)serializable).add((FlowablePublishAlt$InnerSubscription)number);
        if (bl3) {
            boolean bl4 = ((FlowablePublishAlt$InnerSubscription)number).isCancelled();
            if (bl4) {
                ((FlowablePublishAlt$PublishConnection)serializable).remove((FlowablePublishAlt$InnerSubscription)number);
            } else {
                ((FlowablePublishAlt$PublishConnection)serializable).drain();
            }
            return;
        }
        serializable = ((FlowablePublishAlt$PublishConnection)serializable).error;
        if (serializable != null) {
            d10.onError((Throwable)serializable);
        } else {
            d10.onComplete();
        }
    }

    public c source() {
        return this.b;
    }
}

