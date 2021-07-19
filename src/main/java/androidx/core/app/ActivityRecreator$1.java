/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.app;

import androidx.core.app.ActivityRecreator$LifecycleCheckCallbacks;

public class ActivityRecreator$1
implements Runnable {
    public final /* synthetic */ ActivityRecreator$LifecycleCheckCallbacks val$callbacks;
    public final /* synthetic */ Object val$token;

    public ActivityRecreator$1(ActivityRecreator$LifecycleCheckCallbacks lifecycleCheckCallbacks, Object object) {
        this.val$callbacks = lifecycleCheckCallbacks;
        this.val$token = object;
    }

    public void run() {
        Object object;
        ActivityRecreator$LifecycleCheckCallbacks activityRecreator$LifecycleCheckCallbacks = this.val$callbacks;
        activityRecreator$LifecycleCheckCallbacks.currentlyRecreatingToken = object = this.val$token;
    }
}

