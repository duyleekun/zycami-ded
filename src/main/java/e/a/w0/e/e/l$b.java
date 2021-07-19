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
import e.a.w0.e.e.l$a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class l$b
extends k
implements g0,
b {
    public final Callable K;
    public final e0 L;
    public b M;
    public b N;
    public Collection O;

    public l$b(g0 g02, Callable callable, e0 e02) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super(g02, mpscLinkedQueue);
        this.K = callable;
        this.L = e02;
    }

    public void dispose() {
        boolean bl2 = this.H;
        if (!bl2) {
            this.H = true;
            this.N.dispose();
            Object object = this.M;
            object.dispose();
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k() {
        Object object;
        Object object2;
        try {
            object2 = this.K;
            object2 = object2.call();
            object = "The buffer supplied is null";
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
            object = this.O;
            if (object == null) {
                return;
            }
            this.O = object2;
        }
        this.g(object, false, this);
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

    public void onSubscribe(b object) {
        Object object2 = this.M;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.M = object;
            object2 = this.K;
            object2 = object2.call();
            String string2 = "The buffer supplied is null";
            object2 = e.a.w0.b.a.g(object2, string2);
            try {
                this.O = object2 = (Collection)object2;
                this.N = object = new l$a(this);
                object2 = this.F;
                object2.onSubscribe(this);
                bl2 = this.H;
                if (!bl2) {
                    object2 = this.L;
                    object2.subscribe((g0)object);
                }
            }
            catch (Throwable throwable) {
                boolean bl3;
                e.a.t0.a.b(throwable);
                this.H = bl3 = true;
                object.dispose();
                object = this.F;
                EmptyDisposable.error(throwable, (g0)object);
            }
        }
    }
}

