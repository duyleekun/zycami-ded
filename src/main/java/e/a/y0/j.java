/*
 * Decompiled with CFR 0.151.
 */
package e.a.y0;

import e.a.l0;
import e.a.w0.a.b;
import e.a.w0.b.a;
import e.a.w0.i.f;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class j
implements l0,
e.a.s0.b {
    private final AtomicReference a;
    private final b b;

    public j() {
        Object object = new AtomicReference();
        this.a = object;
        this.b = object = new b();
    }

    public final void a(e.a.s0.b b10) {
        e.a.w0.b.a.g(b10, "resource is null");
        this.b.b(b10);
    }

    public void b() {
    }

    public final void dispose() {
        Object object = this.a;
        boolean bl2 = DisposableHelper.dispose((AtomicReference)object);
        if (bl2) {
            object = this.b;
            ((b)object).dispose();
        }
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed((e.a.s0.b)this.a.get());
    }

    public final void onSubscribe(e.a.s0.b b10) {
        AtomicReference atomicReference = this.a;
        Class<?> clazz = this.getClass();
        boolean bl2 = f.c(atomicReference, b10, clazz);
        if (bl2) {
            this.b();
        }
    }
}

