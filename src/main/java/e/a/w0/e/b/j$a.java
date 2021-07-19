/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.b;
import e.a.w0.e.b.j$b;

public final class j$a
extends b {
    public final j$b b;

    public j$a(j$b b10) {
        this.b = b10;
    }

    public void onComplete() {
        this.b.onComplete();
    }

    public void onError(Throwable throwable) {
        this.b.onError(throwable);
    }

    public void onNext(Object object) {
        this.b.l();
    }
}

