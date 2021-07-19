/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.w0.i.c;
import e.a.y;
import e.a.y0.d;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

public final class b$a
extends d
implements Iterator {
    public y b;
    public final Semaphore c;
    public final AtomicReference d;

    public b$a() {
        Serializable serializable;
        this.c = serializable = new Semaphore(0);
        this.d = serializable;
    }

    public void b(y object) {
        boolean bl2;
        AtomicReference atomicReference = this.d;
        if ((object = atomicReference.getAndSet(object)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            object = this.c;
            ((Semaphore)object).release();
        }
    }

    public boolean hasNext() {
        boolean bl2;
        Object object = this.b;
        if (object != null && (bl2 = ((y)object).g())) {
            throw ExceptionHelper.f(this.b.d());
        }
        object = this.b;
        if (object == null) {
            try {
                e.a.w0.i.c.b();
                object = this.c;
            }
            catch (InterruptedException interruptedException) {
                y y10;
                this.dispose();
                this.b = y10 = y.b(interruptedException);
                throw ExceptionHelper.f(interruptedException);
            }
            ((Semaphore)object).acquire();
            object = this.d;
            Object var3_4 = null;
            this.b = object = (y)((AtomicReference)object).getAndSet(null);
            boolean bl3 = ((y)object).g();
            if (bl3) {
                throw ExceptionHelper.f(((y)object).d());
            }
        }
        return this.b.h();
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object = this.b.e();
            this.b = null;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
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

