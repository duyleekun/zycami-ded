/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;

public final class v$a
implements l0 {
    public final l0 a;
    public final o b;

    public v$a(l0 l02, o o10) {
        this.a = l02;
        this.b = o10;
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper function returned a null value.";
        object = e.a.w0.b.a.g(object, (String)object2);
        this.a.onSuccess(object);
    }
}

