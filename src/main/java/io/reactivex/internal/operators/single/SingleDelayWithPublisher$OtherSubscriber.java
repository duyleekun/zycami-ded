/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.a1.a;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import e.a.w0.d.o;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithPublisher$OtherSubscriber
extends AtomicReference
implements e.a.o,
b {
    private static final long serialVersionUID = -8565274649390031272L;
    public boolean done;
    public final l0 downstream;
    public final o0 source;
    public e upstream;

    public SingleDelayWithPublisher$OtherSubscriber(l0 l02, o0 o02) {
        this.downstream = l02;
        this.source = o02;
    }

    public void dispose() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        o0 o02 = this.source;
        l0 l02 = this.downstream;
        o o10 = new o(this, l02);
        o02.f(o10);
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.upstream.cancel();
        this.onComplete();
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

