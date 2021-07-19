/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.c.n;
import e.a.w0.h.h;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class k$b
extends h
implements e,
Runnable,
b {
    public final Callable k0;
    public final long o0;
    public final TimeUnit p0;
    public final h0 q0;
    public e r0;
    public Collection s0;
    public final AtomicReference t0;

    public k$b(d atomicReference, Callable callable, long l10, TimeUnit timeUnit, h0 h02) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((d)((Object)atomicReference), mpscLinkedQueue);
        this.t0 = atomicReference = new AtomicReference();
        this.k0 = callable;
        this.o0 = l10;
        this.p0 = timeUnit;
        this.q0 = h02;
    }

    public void cancel() {
        this.X = true;
        this.r0.cancel();
        DisposableHelper.dispose(this.t0);
    }

    public void dispose() {
        this.cancel();
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.t0.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public boolean k(d d10, Collection collection) {
        this.V.onNext(collection);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        Object object = this.t0;
        DisposableHelper.dispose((AtomicReference)object);
        synchronized (this) {
            object = this.s0;
            if (object == null) {
                return;
            }
            this.s0 = null;
        }
        Object object2 = this.W;
        object2.offer(object);
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            object = this.W;
            object2 = this.V;
            e.a.w0.i.n.e((n)object, (d)object2, false, null, this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.t0);
        synchronized (this) {
            this.s0 = null;
        }
        this.V.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Collection collection = this.s0;
            if (collection != null) {
                collection.add(object);
            }
            return;
        }
    }

    public void onSubscribe(e object) {
        Object object2 = this.r0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            this.r0 = object;
            object2 = this.k0;
            object2 = object2.call();
            String string2 = "The supplied buffer is null";
            object2 = e.a.w0.b.a.g(object2, string2);
            try {
                this.s0 = object2 = (Collection)object2;
                object2 = this.V;
                object2.onSubscribe(this);
                bl2 = this.X;
                if (!bl2) {
                    long l10 = Long.MAX_VALUE;
                    object.request(l10);
                    h0 h02 = this.q0;
                    long l11 = this.o0;
                    TimeUnit timeUnit = this.p0;
                    object = h02.g(this, l11, l11, timeUnit);
                    object2 = this.t0;
                    string2 = null;
                    bl2 = ((AtomicReference)object2).compareAndSet(null, object);
                    if (!bl2) {
                        object.dispose();
                    }
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                object2 = this.V;
                EmptySubscription.error(throwable, (d)object2);
            }
        }
    }

    public void request(long l10) {
        this.j(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        try {
            object2 = this.k0;
            object2 = object2.call();
            object = "The supplied buffer is null";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (Collection)object2;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
            this.V.onError(throwable);
            return;
        }
        synchronized (this) {
            object = this.s0;
            if (object == null) {
                return;
            }
            this.s0 = object2;
        }
        this.h(object, false, this);
    }
}

