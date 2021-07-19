/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.e1.b;
import e.a.w0.e.b.i$b;

public final class i$a
extends b {
    public final i$b b;
    public boolean c;

    public i$a(i$b b10) {
        this.b = b10;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.b.m();
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
        this.a();
        this.b.m();
    }
}

