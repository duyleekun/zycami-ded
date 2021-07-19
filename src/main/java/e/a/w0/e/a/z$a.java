/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.d;
import e.a.g0;
import e.a.w0.d.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class z$a
extends b
implements d {
    public final g0 a;
    public e.a.s0.b b;

    public z$a(g0 g02) {
        this.a = g02;
    }

    public Void a() {
        return null;
    }

    public void clear() {
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(e.a.s0.b object) {
        e.a.s0.b b10 = this.b;
        boolean bl2 = DisposableHelper.validate(b10, (e.a.s0.b)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public int requestFusion(int n10) {
        return n10 & 2;
    }
}

