/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.ActivityRecreator;

public final class ActivityRecreator$LifecycleCheckCallbacks
implements Application.ActivityLifecycleCallbacks {
    public Object currentlyRecreatingToken;
    private Activity mActivity;
    private boolean mDestroyed = false;
    private final int mRecreatingHashCode;
    private boolean mStarted = false;
    private boolean mStopQueued = false;

    public ActivityRecreator$LifecycleCheckCallbacks(Activity activity) {
        int n10;
        this.mActivity = activity;
        this.mRecreatingHashCode = n10 = activity.hashCode();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        Activity activity2 = this.mActivity;
        if (activity2 == activity) {
            boolean bl2;
            activity = null;
            this.mActivity = null;
            this.mDestroyed = bl2 = true;
        }
    }

    public void onActivityPaused(Activity activity) {
        int n10;
        Object object;
        boolean bl2;
        boolean bl3 = this.mDestroyed;
        if (bl3 && !(bl3 = this.mStopQueued) && !(bl3 = this.mStarted) && (bl2 = ActivityRecreator.queueOnStopIfNecessary(object = this.currentlyRecreatingToken, n10 = this.mRecreatingHashCode, activity))) {
            this.mStopQueued = true;
            bl2 = false;
            activity = null;
            this.currentlyRecreatingToken = null;
        }
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Activity activity2 = this.mActivity;
        if (activity2 == activity) {
            boolean bl2;
            this.mStarted = bl2 = true;
        }
    }

    public void onActivityStopped(Activity activity) {
    }
}

