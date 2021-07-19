/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.mob.tools.utils;

import android.app.Activity;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.ActivityTracker$EachTracker;
import com.mob.tools.utils.ActivityTracker$Tracker;

public class ActivityTracker$5
implements ActivityTracker$EachTracker {
    public final /* synthetic */ ActivityTracker this$0;
    public final /* synthetic */ Activity val$activity;

    public ActivityTracker$5(ActivityTracker activityTracker, Activity activity) {
        this.this$0 = activityTracker;
        this.val$activity = activity;
    }

    public void each(ActivityTracker$Tracker activityTracker$Tracker) {
        Activity activity = this.val$activity;
        activityTracker$Tracker.onResumed(activity);
    }
}

