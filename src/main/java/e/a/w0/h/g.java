/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import io.reactivex.internal.subscribers.InnerQueuedSubscriber;

public interface g {
    public void drain();

    public void innerComplete(InnerQueuedSubscriber var1);

    public void innerError(InnerQueuedSubscriber var1, Throwable var2);

    public void innerNext(InnerQueuedSubscriber var1, Object var2);
}

