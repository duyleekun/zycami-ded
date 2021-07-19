/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.c.n;
import e.a.w0.h.h;
import i.g.d;
import i.g.e;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class k$a
extends h
implements e,
Runnable,
b {
    public final Callable k0;
    public final long o0;
    public final TimeUnit p0;
    public final int q0;
    public final boolean r0;
    public final h0$c s0;
    public Collection t0;
    public b u0;
    public e v0;
    public long w0;
    public long x0;

    public k$a(d d10, Callable callable, long l10, TimeUnit timeUnit, int n10, boolean bl2, h0$c h0$c) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super(d10, mpscLinkedQueue);
        this.k0 = callable;
        this.o0 = l10;
        this.p0 = timeUnit;
        this.q0 = n10;
        this.r0 = bl2;
        this.s0 = h0$c;
    }

    public void cancel() {
        boolean bl2 = this.X;
        if (!bl2) {
            this.X = bl2 = true;
            this.dispose();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispose() {
        synchronized (this) {
            Object var1_1 = null;
            this.t0 = null;
        }
        this.v0.cancel();
        this.s0.dispose();
    }

    public boolean isDisposed() {
        return this.s0.isDisposed();
    }

    public boolean k(d d10, Collection collection) {
        d10.onNext(collection);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onComplete() {
        // MONITORENTER : this
        Object object = this.t0;
        Object object2 = null;
        this.t0 = null;
        // MONITOREXIT : this
        if (object == null) return;
        object2 = this.W;
        object2.offer(object);
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            object = this.W;
            object2 = this.V;
            e.a.w0.i.n.e((n)object, (d)object2, false, this, this);
        }
        object = this.s0;
        object.dispose();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Throwable throwable) {
        synchronized (this) {
            this.t0 = null;
        }
        this.V.onError(throwable);
        this.s0.dispose();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        long l10;
        int n10;
        Object object2;
        synchronized (this) {
            object2 = this.t0;
            if (object2 == null) {
                return;
            }
            object2.add(object);
            n10 = object2.size();
            int n11 = this.q0;
            if (n10 < n11) {
                return;
            }
            n10 = 0;
            object = null;
            this.t0 = null;
            long l11 = this.w0;
            l10 = 1L;
            this.w0 = l11 += l10;
        }
        n10 = (int)(this.r0 ? 1 : 0);
        if (n10 != 0) {
            object = this.u0;
            object.dispose();
        }
        n10 = 0;
        object = null;
        this.i(object2, false, this);
        try {
            object = this.k0;
            object = object.call();
            object2 = "The supplied buffer is null";
            object = e.a.w0.b.a.g(object, (String)object2);
            object = (Collection)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
            this.V.onError(throwable);
            return;
        }
        synchronized (this) {
            long l12;
            this.t0 = object;
            this.x0 = l12 = this.x0 + l10;
        }
        n10 = (int)(this.r0 ? 1 : 0);
        if (n10 != 0) {
            object2 = this.s0;
            long l13 = this.o0;
            TimeUnit timeUnit = this.p0;
            this.u0 = object = ((h0$c)object2).d(this, l13, l13, timeUnit);
        }
    }

    public void onSubscribe(e object) {
        Object object2 = this.v0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (!bl2) {
            return;
        }
        this.v0 = object;
        try {
            object2 = this.k0;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.s0.dispose();
            object.cancel();
            object = this.V;
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        object2 = object2.call();
        Object object3 = "The supplied buffer is null";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        this.t0 = object2 = (Collection)object2;
        this.V.onSubscribe(this);
        object3 = this.s0;
        long l10 = this.o0;
        TimeUnit timeUnit = this.p0;
        this.u0 = object2 = ((h0$c)object3).d(this, l10, l10, timeUnit);
        object.request(Long.MAX_VALUE);
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
            long l10;
            long l11;
            long l12;
            long l13;
            object = this.t0;
            if (object != null && (l13 = (l12 = (l11 = this.w0) - (l10 = this.x0)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                this.t0 = object2;
                // MONITOREXIT @DISABLED, blocks:[3, 5] lbl17 : MonitorExitStatement: MONITOREXIT : this
                this.i(object, false, this);
                return;
            }
            return;
        }
    }
}

