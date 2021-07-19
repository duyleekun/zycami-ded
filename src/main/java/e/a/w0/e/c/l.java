/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.q;
import e.a.s0.b;
import e.a.s0.c;
import e.a.t;
import e.a.w0.b.a;
import java.util.concurrent.Callable;

public final class l
extends q {
    public final Callable a;

    public l(Callable callable) {
        this.a = callable;
    }

    public void t1(t t10) {
        Object object = c.a();
        t10.onSubscribe((b)object);
        object = this.a;
        object = object.call();
        String string2 = "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, string2);
        try {
            object = (Throwable)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
        }
        t10.onError((Throwable)object);
    }
}

