/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import e.a.s0.b;
import e.a.w0.b.a;
import e.a.w0.c.n;
import e.a.w0.e.b.j$a;
import e.a.w0.h.h;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class j$b
extends h
implements o,
e,
b {
    public final Callable k0;
    public final c o0;
    public e p0;
    public b q0;
    public Collection r0;

    public j$b(d d10, Callable callable, c c10) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super(d10, mpscLinkedQueue);
        this.k0 = callable;
        this.o0 = c10;
    }

    public void cancel() {
        boolean bl2 = this.X;
        if (!bl2) {
            this.X = true;
            this.q0.dispose();
            Object object = this.p0;
            object.cancel();
            bl2 = this.b();
            if (bl2) {
                object = this.W;
                object.clear();
            }
        }
    }

    public void dispose() {
        this.cancel();
    }

    public boolean isDisposed() {
        return this.X;
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
    public void l() {
        Object object;
        Object object2;
        try {
            object2 = this.k0;
            object2 = object2.call();
            object = "The buffer supplied is null";
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
            object = this.r0;
            if (object == null) {
                return;
            }
            this.r0 = object2;
        }
        this.h(object, false, this);
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

    public void onSubscribe(e object) {
        Object object2 = this.p0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (!bl2) {
            return;
        }
        this.p0 = object;
        try {
            object2 = this.k0;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.X = true;
            object.cancel();
            object = this.V;
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        object2 = object2.call();
        Object object3 = "The buffer supplied is null";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        this.r0 = object2 = (Collection)object2;
        this.q0 = object2 = new j$a(this);
        object3 = this.V;
        object3.onSubscribe(this);
        boolean bl3 = this.X;
        if (!bl3) {
            long l10 = Long.MAX_VALUE;
            object.request(l10);
            object = this.o0;
            object.subscribe((d)object2);
        }
    }

    public void request(long l10) {
        this.j(l10);
    }
}

