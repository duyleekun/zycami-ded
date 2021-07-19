/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a1.a;
import e.a.d;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;

public final class d$a
implements d,
b,
Runnable {
    public final d a;
    public final h0 b;
    public b c;
    public volatile boolean d;

    public d$a(d d10, h0 h02) {
        this.a = d10;
        this.b = h02;
    }

    public void dispose() {
        this.d = true;
        this.b.e(this);
    }

    public boolean isDisposed() {
        return this.d;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.a.onError(throwable);
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

    public void run() {
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
    }
}

