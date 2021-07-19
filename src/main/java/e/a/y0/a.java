/*
 * Decompiled with CFR 0.151.
 */
package e.a.y0;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.i.f;
import io.reactivex.internal.disposables.DisposableHelper;

public abstract class a
implements g0 {
    private b a;

    public final void a() {
        b b10 = this.a;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.a = disposableHelper;
        b10.dispose();
    }

    public void b() {
    }

    public final void onSubscribe(b b10) {
        b b11 = this.a;
        Class<?> clazz = this.getClass();
        boolean bl2 = f.e(b11, b10, clazz);
        if (bl2) {
            this.a = b10;
            this.b();
        }
    }
}

