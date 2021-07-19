/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.w0.e.e.k$b;
import e.a.y0.d;

public final class k$a
extends d {
    public final k$b b;
    public boolean c;

    public k$a(k$b b10) {
        this.b = b10;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.b.l();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.dispose();
        this.b.l();
    }
}

