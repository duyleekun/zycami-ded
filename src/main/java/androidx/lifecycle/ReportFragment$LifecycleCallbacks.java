/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.ReportFragment;

public class ReportFragment$LifecycleCallbacks
implements Application.ActivityLifecycleCallbacks {
    public static void registerIn(Activity activity) {
        ReportFragment$LifecycleCallbacks reportFragment$LifecycleCallbacks = new ReportFragment$LifecycleCallbacks();
        activity.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)reportFragment$LifecycleCallbacks);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityPostCreated(Activity activity, Bundle object) {
        object = Lifecycle$Event.ON_CREATE;
        ReportFragment.dispatch(activity, (Lifecycle$Event)((Object)object));
    }

    public void onActivityPostResumed(Activity activity) {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_RESUME;
        ReportFragment.dispatch(activity, lifecycle$Event);
    }

    public void onActivityPostStarted(Activity activity) {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
        ReportFragment.dispatch(activity, lifecycle$Event);
    }

    public void onActivityPreDestroyed(Activity activity) {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_DESTROY;
        ReportFragment.dispatch(activity, lifecycle$Event);
    }

    public void onActivityPrePaused(Activity activity) {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_PAUSE;
        ReportFragment.dispatch(activity, lifecycle$Event);
    }

    public void onActivityPreStopped(Activity activity) {
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_STOP;
        ReportFragment.dispatch(activity, lifecycle$Event);
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}

