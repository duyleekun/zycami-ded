/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.t0.a;
import e.a.v0.d;
import e.a.w0.e.g.b;

public final class b$a
implements l0 {
    private final l0 a;
    public final /* synthetic */ b b;

    public b$a(b b10, l0 l02) {
        this.b = b10;
        this.a = l02;
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(e.a.s0.b b10) {
        this.a.onSubscribe(b10);
    }

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a.onError(throwable);
            return;
        }
        d d10 = ((b)object2).c;
        object2 = ((b)object2).b;
        boolean bl2 = d10.a(object, object2);
        object2 = this.a;
        object = bl2;
        object2.onSuccess(object);
    }
}

