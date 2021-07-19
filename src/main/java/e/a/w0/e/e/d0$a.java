/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.s0.b;
import e.a.t;
import io.reactivex.internal.disposables.DisposableHelper;

public final class d0$a
implements g0,
b {
    public final t a;
    public final long b;
    public b c;
    public long d;
    public boolean e;

    public d0$a(t t10, long l10) {
        this.a = t10;
        this.b = l10;
    }

    public void dispose() {
        this.c.dispose();
    }

    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (!bl2) {
            this.e = bl2 = true;
            t t10 = this.a;
            t10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        long l10 = this.d;
        long l11 = this.b;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.e = true;
            this.c.dispose();
            this.a.onSuccess(object);
            return;
        }
        this.d = ++l10;
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

