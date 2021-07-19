/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.i.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class h
extends CountDownLatch
implements g0,
Future,
b {
    public Object a;
    public Throwable b;
    public final AtomicReference c;

    public h() {
        super(1);
        AtomicReference atomicReference;
        this.c = atomicReference = new AtomicReference();
    }

    public boolean cancel(boolean bl2) {
        DisposableHelper disposableHelper;
        b b10;
        while ((b10 = (b)this.c.get()) != this && b10 != (disposableHelper = DisposableHelper.DISPOSED)) {
            AtomicReference atomicReference = this.c;
            boolean bl3 = atomicReference.compareAndSet(b10, disposableHelper);
            if (!bl3) continue;
            if (b10 != null) {
                b10.dispose();
            }
            this.countDown();
            return true;
        }
        return false;
    }

    public void dispose() {
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
        return DisposableHelper.isDisposed((b)this.c.get());
    }

    public boolean isDisposed() {
        return this.isDone();
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
        while ((object2 = (b)this.c.get()) != this && object2 != (object = DisposableHelper.DISPOSED)) {
            object = this.c;
            boolean bl2 = ((AtomicReference)object).compareAndSet(object2, this);
            if (!bl2) continue;
            this.countDown();
            break;
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        if (object == null) {
            Object object2;
            this.b = throwable;
            while ((object = (b)this.c.get()) != this && object != (object2 = DisposableHelper.DISPOSED)) {
                object2 = this.c;
                boolean bl2 = ((AtomicReference)object2).compareAndSet(object, this);
                if (!bl2) continue;
                this.countDown();
                return;
            }
            e.a.a1.a.Y(throwable);
            return;
        }
        e.a.a1.a.Y(throwable);
    }

    public void onNext(Object object) {
        Object object2 = this.a;
        if (object2 != null) {
            ((b)this.c.get()).dispose();
            object = new IndexOutOfBoundsException("More than one element received");
            this.onError((Throwable)object);
            return;
        }
        this.a = object;
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this.c, b10);
    }
}

