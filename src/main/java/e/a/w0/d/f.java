/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.d;
import e.a.l0;
import e.a.s0.b;
import e.a.t;
import e.a.w0.i.c;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class f
extends CountDownLatch
implements l0,
d,
t {
    public Object a;
    public Throwable b;
    public b c;
    public volatile boolean d;

    public f() {
        super(1);
    }

    public boolean a(long l10, TimeUnit timeUnit) {
        Throwable throwable;
        block6: {
            long l11;
            long l12 = this.getCount();
            long l13 = l12 - (l11 = 0L);
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object != false) {
                try {
                    e.a.w0.i.c.b();
                }
                catch (InterruptedException interruptedException) {
                    this.f();
                    throw ExceptionHelper.f(interruptedException);
                }
                boolean bl2 = this.await(l10, timeUnit);
                if (bl2) break block6;
                this.f();
                return false;
            }
        }
        if ((throwable = this.b) == null) {
            return true;
        }
        throw ExceptionHelper.f(throwable);
    }

    public Object b() {
        Throwable throwable;
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            try {
                e.a.w0.i.c.b();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                this.f();
                throw ExceptionHelper.f(interruptedException);
            }
        }
        if ((throwable = this.b) == null) {
            return this.a;
        }
        throw ExceptionHelper.f(throwable);
    }

    public Object c(Object object) {
        Object object2;
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            try {
                e.a.w0.i.c.b();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                this.f();
                throw ExceptionHelper.f(interruptedException);
            }
        }
        if ((object2 = this.b) == null) {
            object2 = this.a;
            if (object2 != null) {
                object = object2;
            }
            return object;
        }
        throw ExceptionHelper.f((Throwable)object2);
    }

    public Throwable d() {
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            try {
                e.a.w0.i.c.b();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                this.f();
                return interruptedException;
            }
        }
        return this.b;
    }

    public Throwable e(long l10, TimeUnit timeUnit) {
        block8: {
            long l11;
            long l12 = this.getCount();
            long l13 = l12 - (l11 = 0L);
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object != false) {
                try {
                    e.a.w0.i.c.b();
                }
                catch (InterruptedException interruptedException) {
                    this.f();
                    throw ExceptionHelper.f(interruptedException);
                }
                object = this.await(l10, timeUnit);
                if (object != false) break block8;
                this.f();
                Object object2 = ExceptionHelper.e(l10, timeUnit);
                TimeoutException timeoutException = new TimeoutException((String)object2);
                object2 = ExceptionHelper.f(timeoutException);
                throw object2;
            }
        }
        return this.b;
    }

    public void f() {
        boolean bl2;
        this.d = bl2 = true;
        b b10 = this.c;
        if (b10 != null) {
            b10.dispose();
        }
    }

    public void onComplete() {
        this.countDown();
    }

    public void onError(Throwable throwable) {
        this.b = throwable;
        this.countDown();
    }

    public void onSubscribe(b b10) {
        this.c = b10;
        boolean bl2 = this.d;
        if (bl2) {
            b10.dispose();
        }
    }

    public void onSuccess(Object object) {
        this.a = object;
        this.countDown();
    }
}

