/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.n1;
import e.a.w0.e.e.n1$b;
import e.a.y0.l;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class n1$a
implements g0 {
    public final ArrayCompositeDisposable a;
    public final n1$b b;
    public final l c;
    public b d;
    public final /* synthetic */ n1 e;

    public n1$a(n1 n12, ArrayCompositeDisposable arrayCompositeDisposable, n1$b b10, l l10) {
        this.e = n12;
        this.a = arrayCompositeDisposable;
        this.b = b10;
        this.c = l10;
    }

    public void onComplete() {
        this.b.d = true;
    }

    public void onError(Throwable throwable) {
        this.a.dispose();
        this.c.onError(throwable);
    }

    public void onNext(Object object) {
        this.d.dispose();
        this.b.d = true;
    }

    public void onSubscribe(b b10) {
        b b11 = this.d;
        boolean bl2 = DisposableHelper.validate(b11, b10);
        if (bl2) {
            this.d = b10;
            b11 = this.a;
            int n10 = 1;
            ((ArrayCompositeDisposable)b11).setResource(n10, b10);
        }
    }
}

