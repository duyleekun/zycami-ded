/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0$c;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.c.n;
import e.a.w0.e.b.k$c$a;
import e.a.w0.h.h;
import i.g.d;
import i.g.e;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class k$c
extends h
implements e,
Runnable {
    public final Callable k0;
    public final long o0;
    public final long p0;
    public final TimeUnit q0;
    public final h0$c r0;
    public final List s0;
    public e t0;

    public k$c(d linkedList, Callable callable, long l10, long l11, TimeUnit timeUnit, h0$c h0$c) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((d)((Object)linkedList), mpscLinkedQueue);
        this.k0 = callable;
        this.o0 = l10;
        this.p0 = l11;
        this.q0 = timeUnit;
        this.r0 = h0$c;
        this.s0 = linkedList = new LinkedList();
    }

    public static /* synthetic */ void l(k$c k$c, Object object, boolean bl2, b b10) {
        k$c.i(object, bl2, b10);
    }

    public void cancel() {
        this.X = true;
        this.t0.cancel();
        this.r0.dispose();
        this.m();
    }

    public boolean k(d d10, Collection collection) {
        d10.onNext(collection);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m() {
        synchronized (this) {
            List list = this.s0;
            list.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onComplete() {
        n n10;
        boolean bl2;
        Object object;
        Object object2;
        synchronized (this) {
            object2 = this.s0;
            object = new ArrayList(object2);
            object2 = this.s0;
            object2.clear();
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Collection)object.next();
            n10 = this.W;
            n10.offer(object2);
        }
        this.Y = true;
        boolean bl3 = this.b();
        if (bl3) {
            object = this.W;
            object2 = this.V;
            n10 = null;
            h0$c h0$c = this.r0;
            e.a.w0.i.n.e((n)object, (d)object2, false, h0$c, this);
        }
    }

    public void onError(Throwable throwable) {
        this.Y = true;
        this.r0.dispose();
        this.m();
        this.V.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Object object2 = this.s0;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (Collection)object3;
                object3.add((Object)object);
            }
            return;
        }
    }

    public void onSubscribe(e object) {
        Object object2 = this.t0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (!bl2) {
            return;
        }
        this.t0 = object;
        try {
            object2 = this.k0;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.r0.dispose();
            object.cancel();
            object = this.V;
            EmptySubscription.error(throwable, (d)object);
            return;
        }
        object2 = object2.call();
        Object object3 = "The supplied buffer is null";
        object2 = e.a.w0.b.a.g(object2, (String)object3);
        object2 = (Collection)object2;
        this.s0.add(object2);
        this.V.onSubscribe(this);
        object.request(Long.MAX_VALUE);
        h0$c h0$c = this.r0;
        long l10 = this.p0;
        TimeUnit timeUnit = this.q0;
        h0$c.d(this, l10, l10, timeUnit);
        object = this.r0;
        object3 = new k$c$a(this, (Collection)object2);
        long l11 = this.o0;
        object2 = this.q0;
        ((h0$c)object).c((Runnable)object3, l11, (TimeUnit)((Object)object2));
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
        boolean bl2 = this.X;
        if (bl2) {
            return;
        }
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
            boolean bl3 = this.X;
            if (bl3) {
                return;
            }
            object = this.s0;
            object.add(object2);
        }
        object = this.r0;
        k$c$a k$c$a = new k$c$a(this, (Collection)object2);
        long l10 = this.o0;
        object2 = this.q0;
        ((h0$c)object).c(k$c$a, l10, (TimeUnit)((Object)object2));
    }
}

