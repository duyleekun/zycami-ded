/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import e.a.v0.g;
import e.a.w0.a.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableRefCount$RefConnection
extends AtomicReference
implements Runnable,
g {
    private static final long serialVersionUID = -4552101107598366241L;
    public boolean connected;
    public boolean disconnectedEarly;
    public final FlowableRefCount parent;
    public long subscriberCount;
    public b timer;

    public FlowableRefCount$RefConnection(FlowableRefCount flowableRefCount) {
        this.parent = flowableRefCount;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void accept(b b10) {
        DisposableHelper.replace(this, b10);
        FlowableRefCount flowableRefCount = this.parent;
        synchronized (flowableRefCount) {
            boolean bl2 = this.disconnectedEarly;
            if (bl2) {
                Object object = this.parent;
                object = ((FlowableRefCount)object).b;
                object = (c)object;
                object.m(b10);
            }
            return;
        }
    }

    public void run() {
        this.parent.O8(this);
    }
}

