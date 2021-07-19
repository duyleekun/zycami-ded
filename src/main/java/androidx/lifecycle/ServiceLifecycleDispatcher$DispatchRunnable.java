/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleRegistry;

public class ServiceLifecycleDispatcher$DispatchRunnable
implements Runnable {
    public final Lifecycle$Event mEvent;
    private final LifecycleRegistry mRegistry;
    private boolean mWasExecuted = false;

    public ServiceLifecycleDispatcher$DispatchRunnable(LifecycleRegistry lifecycleRegistry, Lifecycle$Event lifecycle$Event) {
        this.mRegistry = lifecycleRegistry;
        this.mEvent = lifecycle$Event;
    }

    public void run() {
        boolean bl2 = this.mWasExecuted;
        if (!bl2) {
            LifecycleRegistry lifecycleRegistry = this.mRegistry;
            Lifecycle$Event lifecycle$Event = this.mEvent;
            lifecycleRegistry.handleLifecycleEvent(lifecycle$Event);
            this.mWasExecuted = bl2 = true;
        }
    }
}

