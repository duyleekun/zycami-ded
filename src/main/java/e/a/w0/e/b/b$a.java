/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.e1.b;
import e.a.w0.i.c;
import e.a.y;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class b$a
extends b
implements Iterator {
    public final Semaphore b;
    public final AtomicReference c;
    public y d;

    public b$a() {
        Serializable serializable;
        this.b = serializable = new Semaphore(0);
        this.c = serializable;
    }

    public void d(y object) {
        boolean bl2;
        AtomicReference atomicReference = this.c;
        if ((object = atomicReference.getAndSet(object)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            object = this.b;
            ((Semaphore)object).release();
        }
    }

    public boolean hasNext() {
        boolean bl2;
        Object object = this.d;
        if (object != null && (bl2 = ((y)object).g())) {
            throw ExceptionHelper.f(this.d.d());
        }
        object = this.d;
        if ((object == null || (bl2 = ((y)object).h())) && (object = this.d) == null) {
            try {
                e.a.w0.i.c.b();
                object = this.b;
            }
            catch (InterruptedException interruptedException) {
                y y10;
                this.dispose();
                this.d = y10 = y.b(interruptedException);
                throw ExceptionHelper.f(interruptedException);
            }
            ((Semaphore)object).acquire();
            object = this.c;
            Object var3_4 = null;
            this.d = object = (y)((AtomicReference)object).getAndSet(null);
            boolean bl3 = ((y)object).g();
            if (bl3) {
                throw ExceptionHelper.f(((y)object).d());
            }
        }
        return this.d.h();
    }

    public Object next() {
        Object object;
        boolean bl2 = this.hasNext();
        if (bl2 && (bl2 = ((y)(object = this.d)).h())) {
            object = this.d.e();
            this.d = null;
            return object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        e.a.a1.a.Y(throwable);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Read-only iterator.");
        throw unsupportedOperationException;
    }
}

