/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.f.a;
import e.a.w0.i.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingObservableIterable$BlockingObservableIterator
extends AtomicReference
implements g0,
Iterator,
b {
    private static final long serialVersionUID = 6695226475494099826L;
    public final Condition condition;
    public volatile boolean done;
    public volatile Throwable error;
    public final Lock lock;
    public final a queue;

    public BlockingObservableIterable$BlockingObservableIterator(int n10) {
        a a10;
        this.queue = a10 = new a(n10);
        Object object = new ReentrantLock();
        this.lock = object;
        this.condition = object = object.newCondition();
    }

    public void dispose() {
        DisposableHelper.dispose(this);
        this.signalConsumer();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasNext() {
        block6: while (true) {
            Object object;
            boolean bl2 = this.isDisposed();
            Lock lock = null;
            if (bl2) {
                object = this.error;
                if (object == null) {
                    return false;
                }
                throw ExceptionHelper.f((Throwable)object);
            }
            bl2 = this.done;
            a a10 = this.queue;
            boolean bl3 = a10.isEmpty();
            if (bl2) {
                object = this.error;
                if (object != null) {
                    throw ExceptionHelper.f((Throwable)object);
                }
                if (bl3) {
                    return false;
                }
            }
            if (!bl3) {
                return true;
            }
            try {
                c.b();
                object = this.lock;
                object.lock();
            }
            catch (InterruptedException interruptedException) {
                DisposableHelper.dispose(this);
                this.signalConsumer();
                throw ExceptionHelper.f(interruptedException);
            }
            try {
                while (true) {
                    if ((bl2 = this.done) || !(bl2 = ((a)(object = this.queue)).isEmpty()) || (bl2 = this.isDisposed())) continue block6;
                    object = this.condition;
                    object.await();
                }
            }
            finally {
                object = this.lock;
                object.unlock();
                continue;
            }
            break;
        }
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            return this.queue.poll();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void onComplete() {
        this.done = true;
        this.signalConsumer();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.signalConsumer();
    }

    public void onNext(Object object) {
        this.queue.offer(object);
        this.signalConsumer();
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
        throw unsupportedOperationException;
    }

    public void signalConsumer() {
        Object object = this.lock;
        object.lock();
        try {
            object = this.condition;
            object.signalAll();
            return;
        }
        finally {
            this.lock.unlock();
        }
    }
}

