/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import e.a.w0.h.c;

public final class e
extends c {
    public void onError(Throwable throwable) {
        this.a = null;
        this.b = throwable;
        this.countDown();
    }

    public void onNext(Object object) {
        this.a = object;
    }
}

