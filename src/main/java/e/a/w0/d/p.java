/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.d;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;

public final class p
implements d,
e {
    public final i.g.d a;
    public b b;

    public p(i.g.d d10) {
        this.a = d10;
    }

    public void cancel() {
        this.b.dispose();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onSubscribe(b object) {
        b b10 = this.b;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
    }
}

