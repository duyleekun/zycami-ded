/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.i;
import e.a.s0.b;
import e.a.v0.f;

public interface l
extends i {
    public boolean isCancelled();

    public long requested();

    public l serialize();

    public void setCancellable(f var1);

    public void setDisposable(b var1);

    public boolean tryOnError(Throwable var1);
}

