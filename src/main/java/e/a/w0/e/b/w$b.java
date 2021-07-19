/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.a;
import e.a.v0.g;
import e.a.w0.h.b;
import i.g.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;

public final class w$b
extends b {
    public final g f;
    public final g g;
    public final a h;
    public final a i;

    public w$b(d d10, g g10, g g11, a a10, a a11) {
        super(d10);
        this.f = g10;
        this.g = g11;
        this.h = a10;
        this.i = a11;
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
        d d10;
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
            d d11 = this.a;
            int n11 = 2;
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = object;
            throwableArray[n10] = throwable;
            CompositeException compositeException = new CompositeException(throwableArray);
            d11.onError(compositeException);
            n10 = 0;
            d10 = null;
        }
        if (n10 != 0) {
            d10 = this.a;
            d10.onError((Throwable)object);
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
}

