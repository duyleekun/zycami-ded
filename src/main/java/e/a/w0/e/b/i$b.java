/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.c.n;
import e.a.w0.e.b.i$a;
import e.a.w0.h.h;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class i$b
extends h
implements o,
e,
b {
    public final Callable k0;
    public final Callable o0;
    public e p0;
    public final AtomicReference q0;
    public Collection r0;

    public i$b(d atomicReference, Callable callable, Callable callable2) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((d)((Object)atomicReference), mpscLinkedQueue);
        this.q0 = atomicReference = new AtomicReference();
        this.k0 = callable;
        this.o0 = callable2;
    }

    public void cancel() {
        boolean bl2 = this.X;
        if (!bl2) {
            this.X = true;
            Object object = this.p0;
            object.cancel();
            this.l();
            bl2 = this.b();
            if (bl2) {
                object = this.W;
                object.clear();
            }
        }
    }

    public void dispose() {
        this.p0.cancel();
        this.l();
    }

    public boolean isDisposed() {
        boolean bl2;
        DisposableHelper disposableHelper;
        Object v10 = this.q0.get();
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

    public void l() {
        DisposableHelper.dispose(this.q0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        try {
            object4 = this.k0;
            object4 = object4.call();
            object3 = "The buffer supplied is null";
            object4 = e.a.w0.b.a.g(object4, (String)object3);
            object4 = (Collection)object4;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
            this.V.onError(throwable);
            return;
        }
        try {
            object3 = this.o0;
            object3 = object3.call();
            object2 = "The boundary publisher supplied is null";
            object3 = e.a.w0.b.a.g(object3, (String)object2);
            object3 = (c)object3;
            object2 = new i$a(this);
            object = this.q0;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.X = true;
            this.p0.cancel();
            this.V.onError(throwable);
            return;
        }
        boolean bl2 = DisposableHelper.replace((AtomicReference)object, (b)object2);
        if (bl2) {
            synchronized (this) {
                object = this.r0;
                if (object == null) {
                    return;
                }
                this.r0 = object4;
            }
            object3.subscribe((d)object2);
            object4 = null;
            this.h(object, false, this);
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
            object2 = this.r0;
            if (object2 == null) {
                return;
            }
            object = null;
            this.r0 = null;
        }
        object = this.W;
        object.offer(object2);
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            object2 = this.W;
            object = this.V;
            e.a.w0.i.n.e((n)object2, (d)object, false, this, this);
        }
    }

    public void onError(Throwable throwable) {
        this.cancel();
        this.V.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Collection collection = this.r0;
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
    public void onSubscribe(e e10) {
        Object object3;
        Object object2;
        Object object = this.p0;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (!bl2) {
            return;
        }
        this.p0 = e10;
        object = this.V;
        boolean bl3 = true;
        try {
            object2 = this.k0;
            object2 = object2.call();
            object3 = "The buffer supplied is null";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            this.r0 = object2 = (Collection)object2;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.X = bl3;
            e10.cancel();
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        try {
            object2 = this.o0;
            object2 = object2.call();
            object3 = "The boundary publisher supplied is null";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            object2 = (c)object2;
            i$a i$a = new i$a(this);
            object3 = this.q0;
            ((AtomicReference)object3).set(i$a);
            object.onSubscribe(this);
            bl2 = this.X;
            if (!bl2) {
                long l10 = Long.MAX_VALUE;
                e10.request(l10);
                object2.subscribe(i$a);
            }
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.X = bl3;
            e10.cancel();
            EmptySubscription.error(throwable, (d)object);
            return;
        }
    }

    public void request(long l10) {
        this.j(l10);
    }
}

