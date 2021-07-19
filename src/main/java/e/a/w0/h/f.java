/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.c;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class f
extends CountDownLatch
implements o,
Future,
e {
    public Object a;
    public Throwable b;
    public final AtomicReference c;

    public f() {
        super(1);
        AtomicReference atomicReference;
        this.c = atomicReference = new AtomicReference();
    }

    public void cancel() {
    }

    public boolean cancel(boolean bl2) {
        SubscriptionHelper subscriptionHelper;
        e e10;
        while ((e10 = (e)this.c.get()) != this && e10 != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            AtomicReference atomicReference = this.c;
            boolean bl3 = atomicReference.compareAndSet(e10, subscriptionHelper);
            if (!bl3) continue;
            if (e10 != null) {
                e10.cancel();
            }
            this.countDown();
            return true;
        }
        return false;
    }

    public Object get() {
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            e.a.w0.i.c.b();
            this.await();
        }
        if ((object = (Object)this.isCancelled()) == false) {
            Throwable throwable = this.b;
            if (throwable == null) {
                return this.a;
            }
            ExecutionException executionException = new ExecutionException(throwable);
            throw executionException;
        }
        CancellationException cancellationException = new CancellationException();
        throw cancellationException;
    }

    public Object get(long l10, TimeUnit timeUnit) {
        boolean bl2;
        long l11;
        long l12 = this.getCount();
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            e.a.w0.i.c.b();
            object = this.await(l10, timeUnit);
            if (object == false) {
                String string2 = ExceptionHelper.e(l10, timeUnit);
                TimeoutException timeoutException = new TimeoutException(string2);
                throw timeoutException;
            }
        }
        if (!(bl2 = this.isCancelled())) {
            Throwable throwable = this.b;
            if (throwable == null) {
                return this.a;
            }
            ExecutionException executionException = new ExecutionException(throwable);
            throw executionException;
        }
        CancellationException cancellationException = new CancellationException();
        throw cancellationException;
    }

    public boolean isCancelled() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.c.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public boolean isDone() {
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void onComplete() {
        Object object;
        Object object2 = this.a;
        if (object2 == null) {
            object2 = new NoSuchElementException("The source is empty");
            this.onError((Throwable)object2);
            return;
        }
        while ((object2 = (e)this.c.get()) != this && object2 != (object = SubscriptionHelper.CANCELLED)) {
            object = this.c;
            boolean bl2 = ((AtomicReference)object).compareAndSet(object2, this);
            if (!bl2) continue;
            this.countDown();
            break;
        }
    }

    public void onError(Throwable throwable) {
        Object object;
        e e10;
        while ((e10 = (e)this.c.get()) != this && e10 != (object = SubscriptionHelper.CANCELLED)) {
            this.b = throwable;
            object = this.c;
            boolean bl2 = ((AtomicReference)object).compareAndSet(e10, this);
            if (!bl2) continue;
            this.countDown();
            return;
        }
        e.a.a1.a.Y(throwable);
    }

    public void onNext(Object object) {
        Object object2 = this.a;
        if (object2 != null) {
            ((e)this.c.get()).cancel();
            object = new IndexOutOfBoundsException("More than one element received");
            this.onError((Throwable)object);
            return;
        }
        this.a = object;
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this.c, e10, Long.MAX_VALUE);
    }

    public void request(long l10) {
    }
}

