/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.h0;
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
import java.util.concurrent.atomic.AtomicReference;

public final class m$b
extends k
implements Runnable,
b {
    public final Callable K;
    public final long L;
    public final TimeUnit M;
    public final h0 N;
    public b O;
    public Collection P;
    public final AtomicReference Q;

    public m$b(g0 atomicReference, Callable callable, long l10, TimeUnit timeUnit, h0 h02) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((g0)((Object)atomicReference), mpscLinkedQueue);
        this.Q = atomicReference = new AtomicReference();
        this.K = callable;
        this.L = l10;
        this.M = timeUnit;
        this.N = h02;
    }

    public void dispose() {
        DisposableHelper.dispose(this.Q);
        this.O.dispose();
    }

    public void i(g0 g02, Collection collection) {
        this.F.onNext(collection);
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.Q.get();
        if (v10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
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
        Object object = this.P;
        this.P = null;
        // MONITOREXIT : this
        if (object != null) {
            Object object2 = this.G;
            object2.offer(object);
            this.I = true;
            boolean bl2 = this.b();
            if (bl2) {
                object = this.G;
                object2 = this.F;
                e.a.w0.i.n.d((n)object, (g0)object2, false, null, this);
            }
        }
        DisposableHelper.dispose(this.Q);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Throwable throwable) {
        synchronized (this) {
            this.P = null;
        }
        this.F.onError(throwable);
        DisposableHelper.dispose(this.Q);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Collection collection = this.P;
            if (collection == null) {
                return;
            }
            collection.add(object);
            return;
        }
    }

    public void onSubscribe(b object) {
        Object object2 = this.O;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.O = object;
            object = this.K;
            object = object.call();
            object2 = "The buffer supplied is null";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                this.P = object = (Collection)object;
                object = this.F;
                object.onSubscribe(this);
                boolean bl3 = this.H;
                if (!bl3) {
                    object2 = this.N;
                    object2 = this.Q;
                    long l10 = this.L;
                    TimeUnit timeUnit = this.M;
                    object = ((h0)object2).g(this, l10, l10, timeUnit);
                    bl2 = ((AtomicReference)object2).compareAndSet(null, object);
                    if (!bl2) {
                        object.dispose();
                    }
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.dispose();
                object2 = this.F;
                EmptyDisposable.error(throwable, (g0)object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
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
            this.F.onError(throwable);
            this.dispose();
            return;
        }
        object = this.P;
        if (object != null) {
            this.P = object2;
        }
        // MONITOREXIT : this
        if (object == null) {
            DisposableHelper.dispose(this.Q);
            return;
        }
        this.g(object, false, this);
    }
}

