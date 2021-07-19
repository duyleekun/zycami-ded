/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.d$b;
import e.a.w0.e.e.z0;
import e.a.y;
import e.a.z;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d$a
implements Iterator {
    private final d$b a;
    private final e0 b;
    private Object c;
    private boolean d;
    private boolean e;
    private Throwable f;
    private boolean g;

    public d$a(e0 e02, d$b b10) {
        boolean bl2;
        this.d = bl2 = true;
        this.e = bl2;
        this.b = e02;
        this.a = b10;
    }

    private boolean a() {
        Object object;
        boolean bl2 = this.g;
        boolean bl3 = true;
        if (!bl2) {
            this.g = bl3;
            this.a.c();
            Object object2 = this.b;
            object = new z0((e0)object2);
            object2 = this.a;
            ((z)object).subscribe((g0)object2);
        }
        try {
            object = this.a;
        }
        catch (InterruptedException interruptedException) {
            this.a.dispose();
            this.f = interruptedException;
            throw ExceptionHelper.f(interruptedException);
        }
        object = ((d$b)object).d();
        boolean bl4 = ((y)object).h();
        if (bl4) {
            this.e = false;
            this.c = object = ((y)object).e();
            return bl3;
        }
        this.d = false;
        bl3 = ((y)object).f();
        if (bl3) {
            return false;
        }
        this.f = object = ((y)object).d();
        throw ExceptionHelper.f((Throwable)object);
    }

    public boolean hasNext() {
        Throwable throwable = this.f;
        if (throwable == null) {
            boolean bl2 = this.d;
            boolean bl3 = false;
            if (!bl2) {
                return false;
            }
            bl2 = this.e;
            if (!bl2 || (bl2 = this.a())) {
                bl3 = true;
            }
            return bl3;
        }
        throw ExceptionHelper.f(throwable);
    }

    public Object next() {
        Throwable throwable = this.f;
        if (throwable == null) {
            boolean bl2 = this.hasNext();
            if (bl2) {
                this.e = true;
                return this.c;
            }
            throwable = new NoSuchElementException("No more elements");
            throw throwable;
        }
        throw ExceptionHelper.f(throwable);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Read only iterator");
        throw unsupportedOperationException;
    }
}

