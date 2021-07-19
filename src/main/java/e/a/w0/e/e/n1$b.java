/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class n1$b
implements g0 {
    public final g0 a;
    public final ArrayCompositeDisposable b;
    public b c;
    public volatile boolean d;
    public boolean e;

    public n1$b(g0 g02, ArrayCompositeDisposable arrayCompositeDisposable) {
        this.a = g02;
        this.b = arrayCompositeDisposable;
    }

    public void onComplete() {
        this.b.dispose();
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.dispose();
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            g0 g02 = this.a;
            g02.onNext(object);
        } else {
            bl2 = this.d;
            if (bl2) {
                this.e = bl2 = true;
                g0 g03 = this.a;
                g03.onNext(object);
            }
        }
    }

    public void onSubscribe(b b10) {
        b b11 = this.c;
        boolean bl2 = DisposableHelper.validate(b11, b10);
        if (bl2) {
            this.c = b10;
            b11 = this.b;
            ((ArrayCompositeDisposable)b11).setResource(0, b10);
        }
    }
}

