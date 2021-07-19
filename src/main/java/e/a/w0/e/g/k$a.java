/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.g;
import io.reactivex.internal.disposables.EmptyDisposable;

public final class k$a
implements l0 {
    public final l0 a;
    public final g b;
    public boolean c;

    public k$a(l0 l02, g g10) {
        this.a = l02;
        this.b = g10;
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.a.onError(throwable);
    }

    public void onSubscribe(b object) {
        g g10;
        try {
            g10 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c = true;
            object.dispose();
            object = this.a;
            EmptyDisposable.error(throwable, (l0)object);
            return;
        }
        g10.accept(object);
        this.a.onSubscribe((b)object);
    }

    public void onSuccess(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.a.onSuccess(object);
    }
}

