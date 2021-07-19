/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.v0.a;
import io.reactivex.internal.disposables.DisposableHelper;

public final class h$a
implements l0,
b {
    public final l0 a;
    public final a b;
    public b c;

    public h$a(l0 l02, a a10) {
        this.a = l02;
        this.b = a10;
    }

    private void a() {
        a a10 = this.b;
        try {
            a10.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
        this.a();
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.a.onSuccess(object);
        this.a();
    }
}

