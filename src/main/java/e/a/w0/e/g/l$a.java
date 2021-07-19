/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.w0.e.g.l;

public final class l$a
implements l0 {
    public final l0 a;
    public final /* synthetic */ l b;

    public l$a(l l10, l0 l02) {
        this.b = l10;
        this.a = l02;
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
            this.a.onError(throwable);
            return;
        }
        object2 = ((l)object2).b;
        object2.accept(object);
        this.a.onSuccess(object);
    }
}

