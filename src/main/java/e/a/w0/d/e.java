/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.w0.d.c;

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

