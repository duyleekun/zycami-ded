/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.r;
import io.reactivex.internal.disposables.DisposableHelper;

public final class h$a
implements g0,
b {
    public final l0 a;
    public final r b;
    public b c;
    public boolean d;

    public h$a(l0 l02, r r10) {
        this.a = l02;
        this.b = r10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            l0 l02 = this.a;
            Boolean bl3 = Boolean.FALSE;
            l02.onSuccess(bl3);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.dispose();
            this.onError(throwable);
            return;
        }
        boolean bl3 = object2.test(object);
        if (bl3) {
            this.d = bl3 = true;
            this.c.dispose();
            object = this.a;
            object2 = Boolean.TRUE;
            object.onSuccess(object2);
        }
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
}

