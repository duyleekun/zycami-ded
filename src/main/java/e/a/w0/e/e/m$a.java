/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.c.n;
import e.a.w0.d.k;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class m$a
extends k
implements Runnable,
b {
    public final Callable K;
    public final long L;
    public final TimeUnit M;
    public final int N;
    public final boolean O;
    public final h0$c P;
    public Collection Q;
    public b R;
    public b S;
    public long T;
    public long U;

    public m$a(g0 g02, Callable callable, long l10, TimeUnit timeUnit, int n10, boolean bl2, h0$c h0$c) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super(g02, mpscLinkedQueue);
        this.K = callable;
        this.L = l10;
        this.M = timeUnit;
        this.N = n10;
        this.O = bl2;
        this.P = h0$c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispose() {
        boolean bl2 = this.H;
        if (bl2) return;
        this.H = true;
        this.S.dispose();
        this.P.dispose();
        synchronized (this) {
            bl2 = false;
            Object var2_2 = null;
            this.Q = null;
            return;
        }
    }

    public void i(g0 g02, Collection collection) {
        g02.onNext(collection);
    }

    public boolean isDisposed() {
        return this.H;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onComplete() {
        Object object = this.P;
        object.dispose();
        // MONITORENTER : this
        object = this.Q;
        Object object2 = null;
        this.Q = null;
        // MONITOREXIT : this
        if (object == null) return;
        object2 = this.G;
        object2.offer(object);
        this.I = true;
        boolean bl2 = this.b();
        if (!bl2) return;
        object = this.G;
        object2 = this.F;
        e.a.w0.i.n.d((n)object, (g0)object2, false, this, this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Throwable throwable) {
        synchronized (this) {
            this.Q = null;
        }
        this.F.onError(throwable);
        this.P.dispose();
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
            object2 = this.Q;
            if (object2 == null) {
                return;
            }
            object2.add(object);
            n10 = object2.size();
            int n11 = this.N;
            if (n10 < n11) {
                return;
            }
            n10 = 0;
            object = null;
            this.Q = null;
            long l11 = this.T;
            l10 = 1L;
            this.T = l11 += l10;
        }
        n10 = (int)(this.O ? 1 : 0);
        if (n10 != 0) {
            object = this.R;
            object.dispose();
        }
        n10 = 0;
        object = null;
        this.h(object2, false, this);
        try {
            object = this.K;
            object = object.call();
            object2 = "The buffer supplied is null";
            object = e.a.w0.b.a.g(object, (String)object2);
            object = (Collection)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.F.onError(throwable);
            this.dispose();
            return;
        }
        synchronized (this) {
            long l12;
            this.Q = object;
            this.U = l12 = this.U + l10;
        }
        n10 = (int)(this.O ? 1 : 0);
        if (n10 != 0) {
            object2 = this.P;
            long l13 = this.L;
            TimeUnit timeUnit = this.M;
            this.R = object = ((h0$c)object2).d(this, l13, l13, timeUnit);
        }
    }

    public void onSubscribe(b object) {
        Object object2 = this.S;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.S = object;
            object2 = this.K;
            object2 = object2.call();
            Object object3 = "The buffer supplied is null";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            try {
                this.Q = object2 = (Collection)object2;
                this.F.onSubscribe(this);
                object2 = this.P;
                long l10 = this.L;
                TimeUnit timeUnit = this.M;
                object3 = this;
                this.R = object = ((h0$c)object2).d(this, l10, l10, timeUnit);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object.dispose();
                object = this.F;
                EmptyDisposable.error(throwable, (g0)object);
                object = this.P;
                object.dispose();
            }
        }
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
            object2 = this.K;
            object2 = object2.call();
            object = "The bufferSupplier returned a null buffer";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (Collection)object2;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.dispose();
            this.F.onError(throwable);
            return;
        }
        synchronized (this) {
            long l10;
            long l11;
            long l12;
            long l13;
            object = this.Q;
            if (object != null && (l13 = (l12 = (l11 = this.T) - (l10 = this.U)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                this.Q = object2;
                // MONITOREXIT @DISABLED, blocks:[3, 5] lbl17 : MonitorExitStatement: MONITOREXIT : this
                this.h(object, false, this);
                return;
            }
            return;
        }
    }
}

