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
import e.a.w0.e.e.m$c$a;
import e.a.w0.e.e.m$c$b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class m$c
extends k
implements Runnable,
b {
    public final Callable K;
    public final long L;
    public final long M;
    public final TimeUnit N;
    public final h0$c O;
    public final List P;
    public b Q;

    public m$c(g0 linkedList, Callable callable, long l10, long l11, TimeUnit timeUnit, h0$c h0$c) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((g0)((Object)linkedList), mpscLinkedQueue);
        this.K = callable;
        this.L = l10;
        this.M = l11;
        this.N = timeUnit;
        this.O = h0$c;
        this.P = linkedList = new LinkedList();
    }

    public static /* synthetic */ void k(m$c m$c, Object object, boolean bl2, b b10) {
        m$c.h(object, bl2, b10);
    }

    public static /* synthetic */ void l(m$c m$c, Object object, boolean bl2, b b10) {
        m$c.h(object, bl2, b10);
    }

    public void dispose() {
        boolean bl2 = this.H;
        if (!bl2) {
            this.H = bl2 = true;
            this.m();
            this.Q.dispose();
            h0$c h0$c = this.O;
            h0$c.dispose();
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
     */
    public void m() {
        synchronized (this) {
            List list = this.P;
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
            object2 = this.P;
            object = new ArrayList(object2);
            object2 = this.P;
            object2.clear();
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Collection)object.next();
            n10 = this.G;
            n10.offer(object2);
        }
        this.I = true;
        boolean bl3 = this.b();
        if (bl3) {
            object = this.G;
            object2 = this.F;
            n10 = null;
            h0$c h0$c = this.O;
            e.a.w0.i.n.d((n)object, (g0)object2, false, h0$c, this);
        }
    }

    public void onError(Throwable throwable) {
        this.I = true;
        this.m();
        this.F.onError(throwable);
        this.O.dispose();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        synchronized (this) {
            Object object2 = this.P;
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

    public void onSubscribe(b object) {
        Object object2 = this.Q;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.Q = object;
            object2 = this.K;
            object2 = object2.call();
            Object object3 = "The buffer supplied is null";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            try {
                object2 = (Collection)object2;
                this.P.add(object2);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object.dispose();
                object = this.F;
                EmptyDisposable.error(throwable, (g0)object);
                object = this.O;
                object.dispose();
            }
            this.F.onSubscribe(this);
            object3 = this.O;
            long l10 = this.M;
            TimeUnit timeUnit = this.N;
            ((h0$c)object3).d(this, l10, l10, timeUnit);
            object = this.O;
            object3 = new m$c$b(this, (Collection)object2);
            long l11 = this.L;
            object2 = this.N;
            ((h0$c)object).c((Runnable)object3, l11, (TimeUnit)((Object)object2));
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
        boolean bl2 = this.H;
        if (bl2) {
            return;
        }
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
        synchronized (this) {
            boolean bl3 = this.H;
            if (bl3) {
                return;
            }
            object = this.P;
            object.add(object2);
        }
        object = this.O;
        m$c$a m$c$a = new m$c$a(this, (Collection)object2);
        long l10 = this.L;
        object2 = this.N;
        ((h0$c)object).c(m$c$a, l10, (TimeUnit)((Object)object2));
    }
}

