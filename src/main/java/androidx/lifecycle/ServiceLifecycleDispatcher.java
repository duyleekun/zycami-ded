/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ServiceLifecycleDispatcher$DispatchRunnable;

public class ServiceLifecycleDispatcher {
    private final Handler mHandler;
    private ServiceLifecycleDispatcher$DispatchRunnable mLastDispatchRunnable;
    private final LifecycleRegistry mRegistry;

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner) {
        LifecycleRegistry lifecycleRegistry;
        this.mRegistry = lifecycleRegistry = new LifecycleRegistry(lifecycleOwner);
        this.mHandler = lifecycleOwner;
    }

    private void postDispatchRunnable(Lifecycle$Event lifecycle$Event) {
        ServiceLifecycleDispatcher$DispatchRunnable serviceLifecycleDispatcher$DispatchRunnable = this.mLastDispatchRunnable;
        if (serviceLifecycleDispatcher$DispatchRunnable != null) {
            serviceLifecycleDispatcher$DispatchRunnable.run();
        }
        LifecycleRegistry lifecycleRegistry = this.mRegistry;
        this.mLastDispatchRunnable = serviceLifecycleDispatcher$DispatchRunnable = new ServiceLifecycleDispatcher$DispatchRunnable(lifecycleRegistry, lifecycle$Event);
        this.mHandler.postAtFrontOfQueue((Runnable)serviceLifecycleDispatcher$DispatchRunnable);
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }

    public void onServicePreSuperOnBind() {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
        this.postDispatchRunnable(lifecycle$Event);
    }

    public void onServicePreSuperOnCreate() {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_CREATE;
        this.postDispatchRunnable(lifecycle$Event);
    }

    public void onServicePreSuperOnDestroy() {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
        this.postDispatchRunnable(lifecycle$Event);
        lifecycle$Event = Lifecycle$Event.ON_DESTROY;
        this.postDispatchRunnable(lifecycle$Event);
    }

    public void onServicePreSuperOnStart() {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
        this.postDispatchRunnable(lifecycle$Event);
    }
}

