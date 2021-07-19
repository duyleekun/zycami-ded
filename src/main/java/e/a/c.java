/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.s0.b;
import e.a.v0.f;

public interface c {
    public boolean isDisposed();

    public void onComplete();

    public void onError(Throwable var1);

    public void setCancellable(f var1);

    public void setDisposable(b var1);

    public boolean tryOnError(Throwable var1);
}

