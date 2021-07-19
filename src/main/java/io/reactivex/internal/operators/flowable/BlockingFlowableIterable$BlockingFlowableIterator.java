/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.s0.b;
import e.a.w0.i.c;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class BlockingFlowableIterable$BlockingFlowableIterator
extends AtomicReference
implements o,
Iterator,
Runnable,
b {
    private static final long serialVersionUID = 6695226475494099826L;
    public final long batchSize;
    public final Condition condition;
    public volatile boolean done;
    public volatile Throwable error;
    public final long limit;
    public final Lock lock;
    public long produced;
    public final SpscArrayQueue queue;

    public BlockingFlowableIterable$BlockingFlowableIterator(int n10) {
        long l10;
        SpscArrayQueue spscArrayQueue;
        this.queue = spscArrayQueue = new SpscArrayQueue(n10);
        this.batchSize = l10 = (long)n10;
        int n11 = n10 >> 2;
        this.limit = l10 = (long)(n10 - n11);
        Object object = new ReentrantLock();
        this.lock = object;
        this.condition = object = object.newCondition();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
        this.signalConsumer();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasNext() {
        Throwable throwable2222222;
        while (true) {
            Object object;
            boolean bl2;
            if (bl2 = this.isDisposed()) {
                object = this.error;
                if (object == null) {
                    return false;
                }
                throw ExceptionHelper.f((Throwable)object);
            }
            bl2 = this.done;
            SpscArrayQueue spscArrayQueue = this.queue;
            boolean bl3 = spscArrayQueue.isEmpty();
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
            c.b();
            object = this.lock;
            object.lock();
            while (!(bl2 = this.done) && (bl2 = ((SpscArrayQueue)(object = this.queue)).isEmpty()) && !(bl2 = this.isDisposed())) {
                object = this.condition;
                object.await();
            }
            object = this.lock;
            object.unlock();
            continue;
            {
                catch (Throwable throwable2222222) {
                    break;
                }
                catch (InterruptedException interruptedException) {}
                {
                    this.run();
                    RuntimeException runtimeException = ExceptionHelper.f(interruptedException);
                    throw runtimeException;
                }
            }
        }
        this.lock.unlock();
        throw throwable2222222;
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object = this.queue.poll();
            long l10 = this.produced + 1L;
            long l11 = this.limit;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                this.produced = l11 = 0L;
                e e10 = (e)this.get();
                e10.request(l10);
            } else {
                this.produced = l10;
            }
            return object;
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
        Object object2 = this.queue;
        boolean bl2 = ((SpscArrayQueue)object2).offer(object);
        if (!bl2) {
            SubscriptionHelper.cancel(this);
            object2 = "Queue full?!";
            object = new MissingBackpressureException((String)object2);
            this.onError((Throwable)object);
        } else {
            this.signalConsumer();
        }
    }

    public void onSubscribe(e e10) {
        long l10 = this.batchSize;
        SubscriptionHelper.setOnce(this, e10, l10);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
        throw unsupportedOperationException;
    }

    public void run() {
        SubscriptionHelper.cancel(this);
        this.signalConsumer();
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

