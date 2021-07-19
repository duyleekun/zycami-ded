/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.e.b.d$b;
import e.a.y;
import i.g.c;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class d$a
implements Iterator {
    private final d$b a;
    private final c b;
    private Object c;
    private boolean d;
    private boolean e;
    private Throwable f;
    private boolean g;

    public d$a(c c10, d$b b10) {
        boolean bl2;
        this.d = bl2 = true;
        this.e = bl2;
        this.b = c10;
        this.a = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a() {
        try {
            Object object;
            boolean bl2 = this.g;
            boolean bl3 = true;
            if (!bl2) {
                this.g = bl3;
                object = this.a;
                ((d$b)object).e();
                object = this.b;
                object = j.f3((c)object);
                object = ((j)object).S3();
                d$b d$b = this.a;
                ((j)object).l6(d$b);
            }
            object = this.a;
            boolean bl4 = ((y)(object = ((d$b)object).f())).h();
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
            bl3 = ((y)object).g();
            if (bl3) {
                this.f = object = ((y)object).d();
                object = ExceptionHelper.f((Throwable)object);
                throw object;
            }
            String string2 = "Should not reach here";
            object = new IllegalStateException(string2);
            throw object;
        }
        catch (InterruptedException interruptedException) {
            this.a.dispose();
            this.f = interruptedException;
            throw ExceptionHelper.f(interruptedException);
        }
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

