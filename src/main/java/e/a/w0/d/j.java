/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import io.reactivex.internal.observers.InnerQueuedObserver;

public interface j {
    public void drain();

    public void innerComplete(InnerQueuedObserver var1);

    public void innerError(InnerQueuedObserver var1, Throwable var2);

    public void innerNext(InnerQueuedObserver var1, Object var2);
}

