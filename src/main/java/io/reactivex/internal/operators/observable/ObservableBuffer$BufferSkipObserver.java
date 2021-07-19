/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer$BufferSkipObserver
extends AtomicBoolean
implements g0,
b {
    private static final long serialVersionUID = -8223395059921494546L;
    public final Callable bufferSupplier;
    public final ArrayDeque buffers;
    public final int count;
    public final g0 downstream;
    public long index;
    public final int skip;
    public b upstream;

    public ObservableBuffer$BufferSkipObserver(g0 arrayDeque, int n10, int n11, Callable callable) {
        this.downstream = arrayDeque;
        this.count = n10;
        this.skip = n11;
        this.bufferSupplier = callable;
        this.buffers = arrayDeque = new ArrayDeque();
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        Object object;
        boolean bl2;
        while (!(bl2 = ((ArrayDeque)(object = this.buffers)).isEmpty())) {
            object = this.downstream;
            Object e10 = this.buffers.poll();
            object.onNext(e10);
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.buffers.clear();
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        long l10;
        long l11 = this.index;
        this.index = l10 = 1L + l11;
        int n10 = this.skip;
        l10 = n10;
        long l12 = (l11 %= l10) - (l10 = 0L);
        Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object4 == false) {
            try {
                object3 = this.bufferSupplier;
            }
            catch (Throwable throwable) {
                this.buffers.clear();
                this.upstream.dispose();
                this.downstream.onError(throwable);
                return;
            }
            object3 = object3.call();
            object2 = "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.";
            object3 = a.g(object3, (String)object2);
            object3 = (Collection)object3;
            object2 = this.buffers;
            ((ArrayDeque)object2).offer(object3);
        }
        object3 = this.buffers.iterator();
        while (bl2 = object3.hasNext()) {
            object2 = (Collection)object3.next();
            object2.add(object);
            n10 = this.count;
            int n11 = object2.size();
            if (n10 > n11) continue;
            object3.remove();
            g0 g02 = this.downstream;
            g02.onNext(object2);
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

