/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.g;
import e.a.w0.c.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;

public final class w$a
extends e.a.w0.h.a {
    public final g f;
    public final g g;
    public final e.a.v0.a h;
    public final e.a.v0.a i;

    public w$a(a a10, g g10, g g11, e.a.v0.a a11, e.a.v0.a a12) {
        super(a10);
        this.f = g10;
        this.g = g11;
        this.h = a11;
        this.i = a12;
    }

    public void onComplete() {
        Object object;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        try {
            object = this.h;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return;
        }
        object.run();
        this.d = bl2 = true;
        object = this.a;
        object.onComplete();
        object = this.i;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void onError(Throwable object) {
        a a10;
        int n10 = (int)(this.d ? 1 : 0);
        if (n10 != 0) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        n10 = 1;
        this.d = n10;
        g g10 = this.g;
        try {
            g10.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a a11 = this.a;
            int n11 = 2;
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = object;
            throwableArray[n10] = throwable;
            CompositeException compositeException = new CompositeException(throwableArray);
            a11.onError(compositeException);
            n10 = 0;
            a10 = null;
        }
        if (n10 != 0) {
            a10 = this.a;
            a10.onError((Throwable)object);
        }
        object = this.i;
        try {
            object.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        g g10;
        int n10 = this.d;
        if (n10 != 0) {
            return;
        }
        n10 = this.e;
        if (n10 != 0) {
            this.a.onNext(null);
            return;
        }
        try {
            g10 = this.f;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return;
        }
        g10.accept(object);
        this.a.onNext(object);
    }

    /*
     * Loose catch block
     */
    public Object poll() {
        Object object;
        int n10;
        int n11;
        Object object2;
        int n12;
        block22: {
            g g10;
            n12 = 0;
            object2 = null;
            n11 = 2;
            n10 = 1;
            object = this.c;
            object = object.poll();
            if (object == null) break block22;
            try {
                g10 = this.f;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                {
                    catch (Throwable throwable2) {
                        this.i.run();
                        throw throwable2;
                    }
                }
                g10 = this.g;
                g10.accept(throwable);
                object2 = ExceptionHelper.d(throwable);
                throw object2;
                catch (Throwable throwable3) {
                    Throwable[] throwableArray = new Throwable[n11];
                    throwableArray[0] = throwable;
                    throwableArray[n10] = throwable3;
                    CompositeException compositeException = new CompositeException(throwableArray);
                    throw compositeException;
                }
            }
            g10.accept(object);
            object2 = this.i;
            object2.run();
        }
        n12 = this.e;
        if (n12 == n10) {
            this.h.run();
            object2 = this.i;
            object2.run();
        }
        return object;
        catch (Throwable throwable) {
            g g11;
            e.a.t0.a.b(throwable);
            try {
                g11 = this.g;
            }
            catch (Throwable throwable4) {
                Throwable[] throwableArray = new Throwable[n11];
                throwableArray[0] = throwable;
                throwableArray[n10] = throwable4;
                CompositeException compositeException = new CompositeException(throwableArray);
                throw compositeException;
            }
            g11.accept(throwable);
            throw ExceptionHelper.d(throwable);
        }
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }

    public boolean tryOnNext(Object object) {
        g g10;
        boolean bl2 = this.d;
        if (bl2) {
            return false;
        }
        try {
            g10 = this.f;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return false;
        }
        g10.accept(object);
        return this.a.tryOnNext(object);
    }
}

