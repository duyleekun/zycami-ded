/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 */
package androidx.core.app;

import android.app.Application;
import androidx.core.app.ActivityRecreator$LifecycleCheckCallbacks;

public class ActivityRecreator$2
implements Runnable {
    public final /* synthetic */ Application val$application;
    public final /* synthetic */ ActivityRecreator$LifecycleCheckCallbacks val$callbacks;

    public ActivityRecreator$2(Application application, ActivityRecreator$LifecycleCheckCallbacks activityRecreator$LifecycleCheckCallbacks) {
        this.val$application = application;
        this.val$callbacks = activityRecreator$LifecycleCheckCallbacks;
    }

    public void run() {
        Application application = this.val$application;
        ActivityRecreator$LifecycleCheckCallbacks activityRecreator$LifecycleCheckCallbacks = this.val$callbacks;
        application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)activityRecreator$LifecycleCheckCallbacks);
    }
}

