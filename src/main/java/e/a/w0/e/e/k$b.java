/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.c.n;
import e.a.w0.d.k;
import e.a.w0.e.e.k$a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class k$b
extends k
implements g0,
b {
    public final Callable K;
    public final Callable L;
    public b M;
    public final AtomicReference N;
    public Collection O;

    public k$b(g0 atomicReference, Callable callable, Callable callable2) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((g0)((Object)atomicReference), mpscLinkedQueue);
        this.N = atomicReference = new AtomicReference();
        this.K = callable;
        this.L = callable2;
    }

    public void dispose() {
        boolean bl2 = this.H;
        if (!bl2) {
            this.H = true;
            Object object = this.M;
            object.dispose();
            this.k();
            bl2 = this.b();
            if (bl2) {
                object = this.G;
                object.clear();
            }
        }
    }

    public void i(g0 g02, Collection collection) {
        this.F.onNext(collection);
    }

    public boolean isDisposed() {
        return this.H;
    }

    public void k() {
        DisposableHelper.dispose(this.N);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        try {
            object4 = this.K;
            object4 = object4.call();
            object3 = "The buffer supplied is null";
            object4 = e.a.w0.b.a.g(object4, (String)object3);
            object4 = (Collection)object4;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.dispose();
            this.F.onError(throwable);
            return;
        }
        try {
            object3 = this.L;
            object3 = object3.call();
            object2 = "The boundary ObservableSource supplied is null";
            object3 = e.a.w0.b.a.g(object3, (String)object2);
            object3 = (e0)object3;
            object2 = new k$a(this);
            object = this.N;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.H = true;
            this.M.dispose();
            this.F.onError(throwable);
            return;
        }
        boolean bl2 = DisposableHelper.replace((AtomicReference)object, (b)object2);
        if (bl2) {
            synchronized (this) {
                object = this.O;
                if (object == null) {
                    return;
                }
                this.O = object4;
            }
            object3.subscribe((g0)object2);
            object4 = null;
            this.g(object, false, this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        Object object;
        Object object2;
        synchronized (this) {
            object2 = this.O;
            if (object2 == null) {
                return;
            }
            object = null;
            this.O = null;
        }
        object = this.G;
        object.offer(object2);
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            object2 = this.G;
            object = this.F;
            e.a.w0.i.n.d((n)object2, (g0)object, false, this, this);
        }
    }

    public void onError(Throwable throwable) {
        this.dispose();
        this.F.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Collection collection = this.O;
            if (collection == null) {
                return;
            }
            collection.add(object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSubscribe(b b10) {
        String string2;
        Object object2;
        Object object = this.M;
        boolean bl2 = DisposableHelper.validate((b)object, b10);
        if (!bl2) return;
        this.M = b10;
        object = this.F;
        boolean bl3 = true;
        try {
            object2 = this.K;
            object2 = object2.call();
            string2 = "The buffer supplied is null";
            object2 = e.a.w0.b.a.g(object2, string2);
            this.O = object2 = (Collection)object2;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.H = bl3;
            b10.dispose();
            EmptyDisposable.error(throwable, (g0)object);
            return;
        }
        try {
            object2 = this.L;
            object2 = object2.call();
            string2 = "The boundary ObservableSource supplied is null";
            object2 = e.a.w0.b.a.g(object2, string2);
            object2 = (e0)object2;
            b10 = new k$a(this);
            AtomicReference atomicReference = this.N;
            atomicReference.set(b10);
            object.onSubscribe(this);
            bl2 = this.H;
            if (bl2) return;
            object2.subscribe((g0)((Object)b10));
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.H = bl3;
            b10.dispose();
            EmptyDisposable.error(throwable, (g0)object);
            return;
        }
    }
}

