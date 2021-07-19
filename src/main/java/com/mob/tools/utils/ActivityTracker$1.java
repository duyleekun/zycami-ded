/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.mob.tools.utils.ActivityTracker;

public class ActivityTracker$1
implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ ActivityTracker this$0;

    public ActivityTracker$1(ActivityTracker activityTracker) {
        this.this$0 = activityTracker;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        ActivityTracker.access$000(this.this$0, activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        ActivityTracker.access$500(this.this$0, activity);
    }

    public void onActivityPaused(Activity activity) {
        ActivityTracker.access$300(this.this$0, activity);
    }

    public void onActivityResumed(Activity activity) {
        ActivityTracker.access$200(this.this$0, activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        ActivityTracker.access$600(this.this$0, activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        ActivityTracker.access$100(this.this$0, activity);
    }

    public void onActivityStopped(Activity activity) {
        ActivityTracker.access$400(this.this$0, activity);
    }
}

